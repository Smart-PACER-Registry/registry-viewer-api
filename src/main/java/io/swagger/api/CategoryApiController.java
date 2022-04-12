package io.swagger.api;

import io.swagger.model.Categories;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class CategoryApiController implements CategoryApi {

    private static final Logger log = LoggerFactory.getLogger(CategoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoryApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Categories> searchCategory(@NotNull @Parameter(in = ParameterIn.QUERY, description = "case-id for the category" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "case-id", required = true) String caseId,@NotNull @Parameter(in = ParameterIn.QUERY, description = "categories for the case-id" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "categories", required = true) String categories) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Categories>(objectMapper.readValue("[ {\n  \"date\" : \"2022-01-14T05:00:00Z\",\n  \"sub-category\" : \"Syphilis\",\n  \"details\" : {\n    \"date\" : \"2022-01-14T05:00:00Z\",\n    \"coding\" : {\n      \"system\" : \"LOINC\",\n      \"code\" : \"20507-0\",\n      \"display\" : \"Reagin Ab [Presence] in Serum by RPR\"\n    },\n    \"unit\" : \"unit\",\n    \"etc\" : \"other stuff to include\",\n    \"value\" : \"Reactive\"\n  },\n  \"source\" : \"2021-07-10T00:00:00^http://loinc.org^20507-0^Reagin Ab [Presence] in Serum by RPR^Reactive\",\n  \"category\" : \"LabResults\",\n  \"value\" : \"2021-07-10T00:00:00^http://loinc.org^20507-0^Reagin Ab [Presence] in Serum by RPR^Reactive\"\n}, {\n  \"date\" : \"2022-01-14T05:00:00Z\",\n  \"sub-category\" : \"Syphilis\",\n  \"details\" : {\n    \"date\" : \"2022-01-14T05:00:00Z\",\n    \"coding\" : {\n      \"system\" : \"LOINC\",\n      \"code\" : \"20507-0\",\n      \"display\" : \"Reagin Ab [Presence] in Serum by RPR\"\n    },\n    \"unit\" : \"unit\",\n    \"etc\" : \"other stuff to include\",\n    \"value\" : \"Reactive\"\n  },\n  \"source\" : \"2021-07-10T00:00:00^http://loinc.org^20507-0^Reagin Ab [Presence] in Serum by RPR^Reactive\",\n  \"category\" : \"LabResults\",\n  \"value\" : \"2021-07-10T00:00:00^http://loinc.org^20507-0^Reagin Ab [Presence] in Serum by RPR^Reactive\"\n} ]", Categories.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Categories>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Categories>(HttpStatus.NOT_IMPLEMENTED);
    }

}
