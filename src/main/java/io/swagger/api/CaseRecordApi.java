/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.CaseData;
import io.swagger.model.UserFlagAnnotationManualData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-05-05T14:02:48.497Z[GMT]")
@Validated
public interface CaseRecordApi {

    @Operation(summary = "Add a flag, annotation, or user data", description = "Add a flag, annotation, or user data", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "requested data updated"),
        
        @ApiResponse(responseCode = "201", description = "requested data created"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid") })
    @RequestMapping(value = "/case-record",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> addUserFlagAnnotationManualData(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "caseId", required = true) Integer caseId, @Parameter(in = ParameterIn.QUERY, description = "" ,schema=@Schema()) @Valid @RequestParam(value = "contentId", required = false) Integer contentId, @Parameter(in = ParameterIn.DEFAULT, description = "create or update flag, annotations, or user data", schema=@Schema()) @Valid @RequestBody UserFlagAnnotationManualData body);


    @Operation(summary = "searches context within a category", description = "By passing in the appropriate options, you can search for available cases in the registry ", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CaseData.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/case-record",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CaseData> searchCategory(@NotNull @Parameter(in = ParameterIn.QUERY, description = "case-id for the category" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "caseId", required = true) String caseId, @Parameter(in = ParameterIn.QUERY, description = "sections to query for the case-id" ,schema=@Schema()) @Valid @RequestParam(value = "sections", required = false) String sections);

}

