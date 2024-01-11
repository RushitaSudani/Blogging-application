package org.technous.bloggingApp.util;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ApiResponse {
    private String message;
    private boolean Status;

    //private Object object;
}
