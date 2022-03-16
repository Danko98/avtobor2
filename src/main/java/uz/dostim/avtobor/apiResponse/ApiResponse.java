package uz.dostim.avtobor.apiResponse;

import lombok.Data;

@Data
public class ApiResponse {

    private String massage;
    private boolean success;
    private Object object;

    public ApiResponse(String massage, boolean success) {
        this.massage = massage;
        this.success = success;
    }

    public ApiResponse(Object object) {
        this.object = object;
    }
}
