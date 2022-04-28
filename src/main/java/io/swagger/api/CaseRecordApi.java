/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.CaseData;
import io.swagger.model.FlagAnnotation;
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

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-28T14:24:10.684Z[GMT]")
@Validated
public interface CaseRecordApi {

    @Operation(summary = "Add a flag or annotation", description = "Add a flag or annotation", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "flag or annotation updated"),
        
        @ApiResponse(responseCode = "201", description = "flag or annotation created"),
        
        @ApiResponse(responseCode = "400", description = "invalid input, object invalid") })
    @RequestMapping(value = "/case-record",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> addFlagOrAnnotation(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "case-id", required = true) Integer caseId, @NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "content-id", required = true) Integer contentId, @Parameter(in = ParameterIn.DEFAULT, description = "Flag or annotation to add", schema=@Schema()) @Valid @RequestBody FlagAnnotation body);


    @Operation(summary = "searches context within a category", description = "By passing in the appropriate options, you can search for available cases in the registry ", security = {
        @SecurityRequirement(name = "basicAuth")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", schema = @Schema(implementation = CaseData.class))),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/case-record",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<CaseData> searchCategory(@NotNull @Parameter(in = ParameterIn.QUERY, description = "case-id for the category" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "case-id", required = true) String caseId, @Parameter(in = ParameterIn.QUERY, description = "sections to query for the case-id" ,schema=@Schema()) @Valid @RequestParam(value = "sections", required = false) String sections);

}

