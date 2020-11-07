package com.app.dto;

import com.app.model.SalesOutlet;
import com.app.model.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter(AccessLevel.PUBLIC)
@Getter(AccessLevel.PUBLIC)
public class SalesOutletDTO {

    private User userId;
    private List<SalesOutlet> salesOutletList;
}
