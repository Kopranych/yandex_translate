package api.yandex.translate.model;

import lombok.Data;

import java.util.List;

@Data
public class JSONResponse {
    private Integer code;
    private String lang;
    private List<String> text;
}
