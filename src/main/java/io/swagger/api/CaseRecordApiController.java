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
public class CaseRecordApiController implements CaseRecordApi {

    private static final Logger log = LoggerFactory.getLogger(CaseRecordApiController.class);
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
    public CaseRecordApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addFlagOrAnnotation(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "case-id", required = true) Integer caseId,@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "content-id", required = true) Integer contentId,@Parameter(in = ParameterIn.DEFAULT, description = "Flag or annotation to add", schema=@Schema()) @Valid @RequestBody FlagAnnotation body) {
        String accept = request.getHeader("Accept");
        
        String sql = "SELECT * FROM viewer_data WHERE observation_id = " + contentId + " AND case_id = " + caseId;
        List<ViewerData> viewerDatas = viewerJdbcTemplate.query(sql, new ViewerDataRowMapper());
        if (viewerDatas.size() > 0) {
            // Update
            sql = "UPDATE viewer_data SET"
                + " flag = '" + body.getFlag() + "',"
                + " annotation = '" + body.getAnnotation() + "'"
                + " WHERE observation_id = " + contentId + " AND case_id = " + caseId;
            viewerJdbcTemplate.update(sql);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            sql = "INSERT INTO viewer_data"
                + " (observation_id, flag, annotation, case_id)"
                + " VALUES (" + contentId + ","
                + " '" + body.getFlag() + "',"
                + " '" + body.getAnnotation() + "',"
                + " " + caseId + ")";
            viewerJdbcTemplate.update(sql);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
    }

    private Integer getConceptCodeForCategory(String category) {
        List<Category> categories = viewerJdbcTemplate.query("SELECT c.concept_id AS ConceptId, c.section AS Section, c.category AS Category FROM category c WHERE section='" + category + "'", new CategoryConceptCodeRowMapper());
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
            if (domainId == 13L) { // Drug_Exposure
                sql = "SELECT"
                    + " d.drug_exposure_start_date AS startDate,"
                    + " d.drug_exposure_end_date AS endDate,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " d.refills AS Refills,"
                    + " d.quantity AS Quantity,"
                    + " d.days_supply AS DaysSupply,"
                    + " d.sig AS Sig,"
                    + " cr.vocabulary_id AS RouteSystem,"
                    + " cr.concept_code AS RouteCode,"
                    + " cr.concept_name AS RouteDisplay,"
                    + " d.lot_number AS LotNumber"
                    + " FROM drug_exposure d join concept c on d.drug_concept_id = c.concept_id"
                    + " left join concept cr on d.route_concept_id = cr.concept_id"
                    + " WHERE d.drug_exposure_id = " + entityId;
            } else if (domainId == 19L) { // condition_occurrence
                sql = "SELECT"
                    + " cd.condition_start_date AS startDate,"
                    + " cd.condition_end_date AS endDate,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display"
                    + " FROM condition_occurrence cd join concept c on cd.condition_concept_id = c.concept_id"
                    + " WHERE cd.condition_occurrence_id = " + entityId;
            } else if (domainId == 27L) { // observation
                sql = "SELECT"
                    + " o.observation_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " o.value_as_number AS ValueAsNumber,"
                    + " o.value_as_string AS ValueAsString,"
                    + " cv.vocabulary_id AS ValueAsConceptSystem,"
                    + " cv.concept_code AS ValueAsConceptCode,"
                    + " cv.concept_name AS ValueAsConceptDisplay,"
                    + " cu.concept_name AS Unit"
                    + " FROM observation o join concept c on o.observation_concept_id = c.concept_id"
                    + " left join concept cv on o.value_as_concept_id = cv.concept_id"
                    + " left join concept cu on o.unit_concept_id = cu.concept_id"
                    + " WHERE o.observation_id = " + entityId;
            } else if (domainId == 21L) { // measurement
                sql = "SELECT"
                    + " m.measurement_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " co.concept_name AS Operator"
                    + " m.value_as_number AS ValueAsNumber,"
                    + " cv.vocabulary_id AS ValueAsConceptSystem,"
                    + " cv.concept_code AS ValueAsConceptCode,"
                    + " cv.concept_name AS ValueAsConceptDisplay,"
                    + " cu.concept_name AS Unit,"
                    + " m.range_low AS RangeLow,"
                    + " m.range_high AS RangeHigh"
                    + " FROM measurement m join concept c on m.measurement_concept_id = c.concept_id"
                    + " left join concept cv on m.value_as_concept_id = cv.concept_id"
                    + " left join concept cu on m.unit_concept_id = cu.concept_id"
                    + " left join concept co on m.operator_concept_id = co.concept_id"
                    + " WHERE m.measurement_id = " + entityId;
            } else if (domainId == 5085L) { // note
                sql = "SELECT"
                    + " n.note_date AS Date,"
                    + " c.vocabulary_id AS System,"
                    + " c.concept_code AS Code,"
                    + " c.concept_name AS Display,"
                    + " n.note_text AS Value"
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
            String sql = "SELECT observation_id, flag, annotation, case_id FROM viewer_data WHERE case_id = " + caseId;
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
                    String flag = viewerData.getFlag();
                    String annotation = viewerData.getAnnotation();
                    if (flag != null && !flag.isEmpty() && !"null".equalsIgnoreCase(flag))
                        content.setFlag(viewerData.getFlag());
                    if (annotation != null && !annotation.isEmpty() && !"null".equalsIgnoreCase(annotation))
                        content.setAnnotation(viewerData.getAnnotation());
                }
                addDetails(content);
            }

            CaseData sectionsResponse = new CaseData();
            sectionsResponse.setContents(registryData);
            sectionsResponse.setCaseId(caseIdInteger);
            sectionsResponse.setCount(registryData.size());

            return new ResponseEntity<CaseData>(sectionsResponse, HttpStatus.OK);
        }

        return new ResponseEntity<CaseData>(HttpStatus.NOT_IMPLEMENTED);
    }

}
