/*
 * Copyright (c) 2022 by Bank Lombard Odier & Co Ltd, Geneva, Switzerland. This software is subject
 * to copyright protection under the laws of Switzerland and other countries. ALL RIGHTS RESERVED.
 *
 */

package org.acme;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonPropertyOrder({ "type" })
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Parent.ChildA.class, name = ".ChildA"),
        @JsonSubTypes.Type(value = Parent.ChildB.class, name = ".ChildB") })
public abstract class Parent {
    
    public List<Shape> shapes = List.of(new Shape.Circle());
    
    @JsonTypeName(".ChildA")
    public static class ChildA extends Parent {
        public String attChildA = "valA";
    }

    @JsonTypeName(".ChildB")
    public static class ChildB extends Parent {
        public String attChildB = "valB";
    }
}

