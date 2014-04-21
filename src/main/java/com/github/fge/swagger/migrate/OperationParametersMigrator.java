package com.github.fge.swagger.migrate;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.swagger.util.SwaggerTransformException;

import javax.annotation.Nonnull;

public final class OperationParametersMigrator
    implements SwaggerMigrator
{
    private final SwaggerMigrator typeMigrator = new V11TypeMigrator();
    private final SwaggerMigrator allowableValuesMigrator
        = new V11AllowableValuesMigrator();

    @Nonnull
    @Override
    public JsonNode migrate(@Nonnull final JsonNode input)
        throws SwaggerTransformException
    {
        return typeMigrator.migrate(allowableValuesMigrator.migrate(input));
    }
}