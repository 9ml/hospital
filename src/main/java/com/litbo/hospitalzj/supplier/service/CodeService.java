package com.litbo.hospitalzj.supplier.service;

import com.litbo.hospitalzj.sf.entity.Code;

public interface CodeService {
    Integer insertCode(Code code);
    Integer deleteAllCodeByEmail(String email);

    Code findCodeAndEmail(String suEmail, String code);
}
