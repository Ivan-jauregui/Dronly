package com.drone.Validation;

import lombok.Builder.Default;

public interface ValidationGroups {
    // Estas interfaces serviran como etiquetas para nuestras validaciones por grupo
    interface onCreate extends Default {}
    interface onUpdate extends Default{}
}
