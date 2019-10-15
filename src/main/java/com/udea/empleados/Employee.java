
package com.udea.empleados;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@ApiModel(description = "All details about the Employee. ")
public class Employee {
    @ApiModelProperty(notes = "The database generated employee ID")
    @Id
    private String id;
    @ApiModelProperty(notes = "The personal email id")
    private @NonNull
    String email;
    @ApiModelProperty(notes = "The employee full name")
    private @NonNull
    String fullName;
    @ApiModelProperty(notes = "The employee email id")
    private @NonNull
    String managerEmail;
    @ApiModelProperty(notes = "The personal salario")
    private @NonNull
    String salario;
    @ApiModelProperty(notes = "The personal cargo")
    private @NonNull
    String cargo;
    @ApiModelProperty(notes = "The personal direccion")
    private @NonNull
    String direccion;
    @ApiModelProperty(notes = "The personal oficina")
    private @NonNull
    String oficina;
    @ApiModelProperty(notes = "The personal dependencia")
    private @NonNull
    String dependencia;
}
