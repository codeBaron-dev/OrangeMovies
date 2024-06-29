package com.codeBaron.orangemovies.domain.ErrorResponseManager

import java.io.Serializable

/**
 * @author Anyanwu Nicholas(codeBaron)
 * @since 10-09-2022
 */

data class ErrorModel(
    val message: String? = null,
    val errors: String? = null
): Serializable