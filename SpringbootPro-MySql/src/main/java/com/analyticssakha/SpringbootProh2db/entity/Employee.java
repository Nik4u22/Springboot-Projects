package com.analyticssakha.SpringbootProh2db.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data /*Include getters and setters*/
@NoArgsConstructor /* Default constructor */
@AllArgsConstructor /* Default constructor with all the required orguments*/
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long employeeId;
    @NotBlank(message="Employee must not be empty")
    /*@Length(max = 100, min = 0)
    @Size(max = 100, min = 0, message="Employee must")
    @Email(message="")
    @Positives(message="")
    @Negative(message="")*/
    private String employeeName;

    /*Removed all the boiler code by just adding lombok - @Data, @NoArgsConstructor, @AllArgsConstructor and @Builder annotations */
}
