package io.swagger.api;

import io.swagger.dbo.CaseRowMapper;
import io.swagger.model.Cases;
import io.swagger.model.ModelCase;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-03-29T13:22:28.494Z[GMT]")
@RestController
public class SearchCasesApiController implements SearchCasesApi {
    final static Logger logger = LoggerFactory.getLogger(SearchCasesApiController.class);

    private static final Logger log = LoggerFactory.getLogger(SearchCasesApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    @Qualifier("registryJdbcTemplate")
    private JdbcTemplate registryJdbcTemplate;
    
    @org.springframework.beans.factory.annotation.Autowired
    public SearchCasesApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    private String CreateSearchSqlStatement (String terms, String fields) {
        String sqlSelectFrom = "SELECT"
            + " ci.case_info_id AS CaseId, "
            + " fp.family_name AS LastName,"
            + " fp.given1_name AS FirstName1,"
            + " fp.given2_name AS FirstName2,"
            + " c.concept_name AS Gender,"
            + " p.year_of_birth AS DobYear,"
            + " p.month_of_birth AS DobMonth,"
            + " p.day_of_birth AS DobDay,"
            + " fp.contact_point1 AS Contact1,"
            + " fp.contact_point2 AS Contact2,"
            + " fp.contact_point3 AS Contact3,"
            + " l.address_1 AS Address1,"
            + " l.address_2 AS Address2,"
            + " l.city AS City,"
            + " l.state AS State,"
            + " l.zip AS Zip,"
            + " ci.status AS Status"
            + " FROM"
            + " person p join f_person fp on p.person_id = fp.person_id"
            + " join case_info ci on p.person_id = ci.person_id"
            + " left join location l on p.location_id = l.location_id"
            + " left join concept c on p.gender_concept_id = c.concept_id";

        String[] values = terms.toLowerCase().split(",");
        String whereString = "";
        if (fields == null || fields.isEmpty()) {
            for (String value : values) {
                String value_ = value.trim().toLowerCase();

                if (!whereString.isEmpty()) {
                    whereString += " AND ";
                }
                whereString += "(LOWER(fp.family_name) LIKE '%" + value_ + "%' OR "
                    + "LOWER(fp.given1_name) LIKE '%" + value_ + "%' OR "
                    + "LOWER(fp.given2_name) LIKE '%" + value_ + "%' OR "
                    + "LOWER(c.concept_name) LIKE '%" + value_ + "%' OR "
                    + "LOWER(l.address_1) LIKE '%" + value_ + "%' OR "
                    + "LOWER(l.address_2) LIKE '%" + value_ + "%' OR "
                    + "LOWER(l.city) LIKE '%" + value_ + "%' OR "
                    + "LOWER(l.state) LIKE '%" + value_ + "%' OR "
                    + "LOWER(l.zip) LIKE '%" + value_ + "%' OR "
                    + "LOWER(ci.status) LIKE '%" + value_ + "%')";
            }
        } else {
            fields = fields.toLowerCase();
            for (String value : values) {
                String value_ = value.trim().toLowerCase();

                String subWhere = "";
                if (fields.contains("lastname")) {
                    subWhere = "LOWER(fp.family_name) LIKE '%" + value_ + "%'";
                }

                if (fields.contains("firstname")) {
                    if (subWhere != null && !subWhere.isEmpty()) {
                        subWhere += " AND ";
                    }
                    subWhere += "(LOWER(fp.given1_name) LIKE '%" + value_ + "%' OR LOWER(fp.given2_name) LIKE '%" + value_ + "%')";
                }

                if (fields.contains("gender")) {
                    if (subWhere != null && !subWhere.isEmpty()) {
                        subWhere += " AND ";
                    }
                    subWhere += "LOWER(c.concept_name) LIKE '%" + value_ + "%'";
                }

                if (fields.contains("street")) {
                    if (subWhere != null && !subWhere.isEmpty()) {
                        subWhere += " AND ";
                    }
                    subWhere += "(LOWER(l.address_1) LIKE '%" + value_ + "%' OR LOWER(l.address_2) LIKE '%" + value_ + "%')";
                }

                if (fields.contains("city")) {
                    if (subWhere != null && !subWhere.isEmpty()) {
                        subWhere += " AND ";
                    }
                    subWhere += "LOWER(l.city) LIKE '%" + value_ + "%'";
                }

                if (fields.contains("state")) {
                    if (subWhere != null && !subWhere.isEmpty()) {
                        subWhere += " AND ";
                    }
                    subWhere += "LOWER(l.state) LIKE '%" + value_ + "%'";
                }

                if (fields.contains("zip")) {
                    if (subWhere != null && !subWhere.isEmpty()) {
                        subWhere += " AND ";
                    }
                    subWhere += "LOWER(l.zip) LIKE '%" + value_ + "%'";
                }

                if (fields.contains("status")) {
                    if (subWhere != null && !subWhere.isEmpty()) {
                        subWhere += " AND ";
                    }
                    subWhere += "LOWER(ci.status) LIKE '%" + value_ + "%'";
                }

                if (!subWhere.isEmpty()) {
                    if (!whereString.isEmpty()) {
                        whereString += " AND ";
                    }
                    whereString += subWhere;
                }

            }

        }

        return sqlSelectFrom + " WHERE " + whereString;
    }

    public ResponseEntity<Cases> searchCases(@NotNull @Parameter(in = ParameterIn.QUERY, description = "search terms for cases" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "terms", required = true) String terms,@Parameter(in = ParameterIn.QUERY, description = "search columns for cases" ,schema=@Schema()) @Valid @RequestParam(value = "fields", required = false) String fields) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            // Search database for terms. Terms are comma separated string values.
            String sql = CreateSearchSqlStatement (terms.trim(), fields);
            logger.debug("searchCases:Query: " + sql);
            List<ModelCase> caseList = registryJdbcTemplate.query(sql, new CaseRowMapper());
            Cases cases = new Cases();
            cases.setCount(caseList.size());
            cases.setCases(caseList);

            return new ResponseEntity<Cases>(cases, HttpStatus.OK);
        }

        return new ResponseEntity<Cases>(HttpStatus.OK);
    }

}
