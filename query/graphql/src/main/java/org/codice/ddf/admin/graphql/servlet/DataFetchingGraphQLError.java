/**
 * Copyright (c) Codice Foundation
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package org.codice.ddf.admin.graphql.servlet;

import static graphql.ErrorType.DataFetchingException;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.execution.ExecutionPath;
import graphql.language.SourceLocation;
import java.util.List;
import org.codice.ddf.admin.api.report.ErrorMessage;

public class DataFetchingGraphQLError implements GraphQLError {

  private String code;
  private List<Object> path;

  public DataFetchingGraphQLError(ErrorMessage msg, ExecutionPath path) {
    this.code = msg.getCode();
    this.path = path.toList();
  }

  @Override
  public String getMessage() {
    return code;
  }

  @Override
  public List<Object> getPath() {
    return path;
  }

  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }

  @Override
  public ErrorType getErrorType() {
    return DataFetchingException;
  }
}
