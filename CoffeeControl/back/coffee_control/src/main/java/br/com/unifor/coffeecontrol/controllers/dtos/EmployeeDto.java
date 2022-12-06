package br.com.unifor.coffeecontrol.controllers.dtos;

import br.com.unifor.coffeecontrol.modelos.Employee;
import br.com.unifor.coffeecontrol.modelos.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

public class EmployeeDto {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private int registration;
    @Getter
    private String password;

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.registration = employee.getRegistration();
        this.password = employee.getPassword();
    }
    public static Page<EmployeeDto> convert(Page<Employee> employees) {
        return employees.map(EmployeeDto::new);
    }

}
