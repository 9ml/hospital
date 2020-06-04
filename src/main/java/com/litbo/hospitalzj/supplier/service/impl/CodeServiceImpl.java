package com.litbo.hospitalzj.supplier.service.impl;

import com.litbo.hospitalzj.sf.entity.Code;
import com.litbo.hospitalzj.supplier.mapper.CodeMapper;
import com.litbo.hospitalzj.supplier.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeMapper codeMapper;
    @Override
    public Integer insertCode(Code code) {
        return codeMapper.insertCode(code);
    }

    @Override
    public Integer deleteAllCodeByEmail(String email) {
        return codeMapper.deleteAllCodeByEmail(email);
    }

    @Override
    public Code findCodeAndEmail(String suEmail, String code) {
        return codeMapper.findCodeAndEmail(suEmail,code);
    }
}
