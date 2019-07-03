package com.paprika.response;

import lombok.Data;

import java.util.List;

/**
 * @author adam
 * @date 2019/7/2
 */
@Data
public class QueryResponse<T> {

    private List<T> list;

    private Long count;

}
