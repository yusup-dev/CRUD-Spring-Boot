package com.project.service;

import com.project.entity.Employee;
import com.project.repository.EmpRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpRepository empRepo;

    @Override
    public Employee saveEmp(Employee emp) {
        Employee newEmp = empRepo.save(emp);
        return newEmp;
    }

    @Override
    public List<Employee> getAllEmp() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmpById(int id) {
        return empRepo.findById(id).get();
    }

    @Override
    public boolean deleteEmp(int id) {
        Employee emp = empRepo.findById(id).get();
        if(emp != null){
            empRepo.delete(emp);
            return true;
        }
        return false;
    }

    public void removeSessionMessage()
    {
        HttpSession session = ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();

        session.removeAttribute("msg");

    }

}
