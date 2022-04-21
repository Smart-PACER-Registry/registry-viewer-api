package io.swagger.api;

import io.swagger.dbo.CategoryConceptCodeRowMapper;
import io.swagger.dbo.CaseDataRowMapper;
import io.swagger.dbo.DetailsRowMapper;
import io.swagger.dbo.FactRelationshipRowMapper;
import io.swagger.dbo.ViewerDataRowMapper;
import io.swagger.model.CaseData;
import io.swagger.model.Category;
import io.swagger.model.Content;
import io.swagger.model.Details;
import io.swagger.model.FactRelationship;
import io.swagger.model.FlagAnnotation;
import io.swagger.model.ViewerData;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-14T14:20:46.754Z[GMT]")
@RestController
public class CategoryApiController implements CategoryApi {

    private static final Logger log = LoggerFactory.getLogger(CategoryApiController.class);
    private static final long observation_concept_code_min = 2000000000L;

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    @Qualifier("registryJdbcTemplate")
    private JdbcTemplate registryJdbcTemplate;

    @Autowired
    @Qualifier("viewerJdbcTemplate")
    private JdbcTemplate viewerJdbcTemplate;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addFlagOrAnnotation(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "content-id", required = true) Integer contentId,@Parameter(in = ParameterIn.DEFAULT, description = "Flag or annotation to add", schema=@Schema()) @Valid @RequestBody FlagAnnotation body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    private Integer getConceptCodeForCategory(String category) {
        List<Category> categories = viewerJdbcTemplate.query("SELECT * FROM category WHERE section='" + category + "'", new CategoryConceptCodeRowMapper());
        if (categories.size()>0) {
            return categories.get(0).getConceptId();
        } else {
            return 0;
        }
    }

    private String createSearchSqlStatement (Integer caseId, String categoriesToSend) {
        String sqlSelectFrom = "SELECT"
            + " o.observation_date AS Date, "
            + " o.observation_id AS ObservationId, "
            + " o.observation_concept_id AS ObservationConceptId, "
            + " oc.vocabulary_id AS ObservationConceptSystem, "
            + " oc.concept_code AS ObservationConceptCode, "
            + " oc.concept_name AS ObservationConceptName, "
            + " ot.vocabulary_id AS ObservationTypeConceptSystem, "
            + " ot.concept_code AS ObservationTypeConceptCode, "
            + " ot.concept_name AS ObservationTypeConceptName, "
            + " o.value_as_string AS DerivedValue, "
            + " o.observation_source_value AS SourceValue "
            + " FROM"
            + " observation o join person p on o.person_id = p.person_id"
            + " join f_person fp on p.person_id = fp.person_id"
            + " join case_info ci on p.person_id = ci.person_id"
            + " left join concept oc on o.observation_concept_id = oc.concept_id"
            + " left join concept ot on o.observation_type_concept_id = ot.concept_id"
            + " WHERE"
            + " ci.case_info_id = " + caseId;
        
        if (categoriesToSend != null && !categoriesToSend.isEmpty()) {
            String[] categories = categoriesToSend.split(",");
            for (String category : categories) {
                Integer concept_code = getConceptCodeForCategory(category);
                if (concept_code > 0) {
                    sqlSelectFrom += " AND o.observation_concept_id = " + concept_code;
                }
            }
        } else {
            sqlSelectFrom += " AND o.observation_concept_id > " + observation_concept_code_min;
        }

        return sqlSelectFrom;
    }

    void addDetails(Content content) {
        Integer observationId = content.getContentId();

        String sql = "SELECT"
            + " f.domain_concept_id_1 AS domain_concept_id_1,"
            + " f.fact_id_1 AS fact_id_1,"
            + " f.domain_concept_id_2 AS domain_concept_id_2,"
            + " f.fact_id_2 AS fact_id_2,"
            + " f.relationship_concept_id AS relationship_concept_id"
            + " FROM"
            + " fact_relationship f join observation o on o.observation_id = f.fact_id_1"
            + " WHERE"
            + " o.observation_id = " + observationId
            + " AND f.relationship_concept_id = " + 44818759L;
        
        List<FactRelationship> factRelationships = registryJdbcTemplate.query(sql, new FactRelationshipRowMapper());
        Details details = new Details();

        // From the factrelationship, set get resource name to read for each realtionship.
        for (FactRelationship factRelationship : factRelationships) {
            Integer domainId = factRelationship.getDomainConceptId2();
            Integer entityId = factRelationship.getFactId2();
            if (domainId == 13L) {
                sql = "SELECT"
                    + " d.drug_exposure_start_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " CONCAT('quantity:', d.quantity, ', refill:', d.refills) AS Value,"
                    + " d.days_supply AS Unit,"
                    + " d.drug_source_value AS Etc"
                    + " FROM drug_exposure d join concept c on d.drug_concept_id = c.concept_id"
                    + " WHERE d.drug_exposure_id = " + entityId;
            } else if (domainId == 19L) {
                sql = "SELECT"
                    + " cd.condition_start_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " CONCAT('') AS Value,"
                    + " CONCAT('') AS Unit,"
                    + " cd.condition_source_value AS Etc"
                    + " FROM condition_occurrence cd join concept c on cd.condition_concept_id = c.concept_id"
                    + " WHERE cd.condition_occurrence_id = " + entityId;
            } else if (domainId == 27L) {
                sql = "SELECT"
                    + " o.observation_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " CONCAT(o.value_as_number,' ',o.value_as_string, ' ', cv.concept_name) AS Value,"
                    + " cu.concept_name AS Unit,"
                    + " CONCAT(o.observation_source_value, ' ', o.unit_source_value) AS Etc"
                    + " FROM observation o join concept c on o.observation_concept_id = c.concept_id"
                    + " left join concept cv on o.value_as_concept_id = cv.concept_id"
                    + " left join concept cu on o.unit_concept_id = cu.concept_id"
                    + " WHERE o.observation_id = " + entityId;
            } else if (domainId == 21L) {
                sql = "SELECT"
                    + " m.measurement_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " CONCAT(m.value_as_number, ' ', cv.concept_name) AS Value,"
                    + " cu.concept_name AS Unit,"
                    + " CONCAT(m.measurement_source_value, ' ', m.unit_source_value) AS Etc"
                    + " FROM measurement m join concept c on m.measurement_concept_id = c.concept_id"
                    + " left join concept cv on m.value_as_concept_id = cv.concept_id"
                    + " left join concept cu on m.unit_concept_id = cu.concept_id"
                    + " WHERE m.measurement_id = " + entityId;
            } else if (domainId == 5085L) {
                sql = "SELECT"
                    + " n.note_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " n.note_text AS Value,"
                    + " CONCAT('') AS Unit,"
                    + " n.note_source_value AS Etc"
                    + " FROM note n join concept c on n.note_type_concept_id = c.concept_id"
                    + " WHERE n.note_id = " + entityId;
            } else {
                log.error("Invalid Domain ConceptID2");
                continue;
            }

            details.addAll(registryJdbcTemplate.query(sql, new DetailsRowMapper(domainId)));            
        }

        content.setDetails(details);
    }

    public ResponseEntity<CaseData> searchCategory(@NotNull @Parameter(in = ParameterIn.QUERY, description = "case-id for the category" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "case-id", required = true) String caseId,@Parameter(in = ParameterIn.QUERY, description = "sections to query for the case-id" ,schema=@Schema()) @Valid @RequestParam(value = "sections", required = false) String sections) {
        String accept = request.getHeader("Accept");
        Integer caseIdInteger = Integer.valueOf(caseId);

        if (accept != null && accept.contains("application/json")) {
            // Make map for viwer data
            String sql = "SELECT observation_id, flag, annotation FROM viewer_data WHERE case_id = " + caseId;
            ViewerDataRowMapper viewerDataRowMapping = new ViewerDataRowMapper();
            viewerJdbcTemplate.query(sql, viewerDataRowMapping);
            Map<Integer, ViewerData> resultUserDataMap = viewerDataRowMapping.getResultMap();

            sql = "SELECT c.concept_id AS ConceptId, c.section AS Section, c.category AS Category FROM category c";
            CategoryConceptCodeRowMapper categoryConceptCodeRowMapper = new CategoryConceptCodeRowMapper();
            viewerJdbcTemplate.query(sql, categoryConceptCodeRowMapper);

            CaseDataRowMapper caseDataRowMapper = new CaseDataRowMapper(categoryConceptCodeRowMapper.getCategoryConceptMap());
            sql = createSearchSqlStatement(caseIdInteger, sections);
            List<Content> registryData = registryJdbcTemplate.query(sql, caseDataRowMapper);
            
            // Add details to each content
            for (Content content : registryData) {
                ViewerData viewerData = resultUserDataMap.get(content.getContentId());
                if (viewerData != null) {
                    content.setFlag(viewerData.getFlag());
                    content.setAnnotation(viewerData.getAnnotation());
                }
                addDetails(content);
            }

            CaseData sectionsResponse = new CaseData();
            sectionsResponse.setContents(registryData);
            sectionsResponse.setCaseId(caseIdInteger);

            return new ResponseEntity<CaseData>(sectionsResponse, HttpStatus.OK);
        }

        return new ResponseEntity<CaseData>(HttpStatus.NOT_IMPLEMENTED);
    }

}
