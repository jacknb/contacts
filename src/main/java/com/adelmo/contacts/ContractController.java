package com.adelmo.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * Created by znb on 17-7-24.
 */
@Controller
@RequestMapping("/")
public class ContractController {

    private ContractRepository contractRepository;

    @Autowired
    public ContractController(ContractRepository contractRepository) {
        //注入ContractRepository
        this.contractRepository = contractRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(Map<String, Object> model) {

        List<Contract> contracts = contractRepository.findAll();
        model.put("contract", contracts);
        return "home";
    }
}
