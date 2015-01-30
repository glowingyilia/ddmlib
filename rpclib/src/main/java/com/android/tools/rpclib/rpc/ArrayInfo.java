/*
* Copyright (C) 2015 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*
* THIS WILL BE REMOVED ONCE THE CODE GENERATOR IS INTEGRATED INTO THE BUILD.
*/
package com.android.tools.rpclib.rpc;

import com.android.tools.rpclib.binary.Decoder;
import com.android.tools.rpclib.binary.Encoder;
import com.android.tools.rpclib.binary.ObjectTypeID;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class ArrayInfo implements TypeInfo {
  String Name;
  TypeKind Kind;
  TypeInfo ElementType;

  // Constructs a default-initialized {@link ArrayInfo}.
  public ArrayInfo() {
  }

  // Constructs and decodes a {@link ArrayInfo} from the {@link Decoder} d.
  public ArrayInfo(Decoder d) throws IOException {
    decode(d);
  }

  // Getters
  @Override
  public String getName() {
    return Name;
  }

  @Override
  public TypeKind getKind() {
    return Kind;
  }

  public TypeInfo getElementType() {
    return ElementType;
  }

  // Setters
  @Override
  public void setName(String v) {
    Name = v;
  }

  @Override
  public void setKind(TypeKind v) {
    Kind = v;
  }

  public void setElementType(TypeInfo v) {
    ElementType = v;
  }

  @Override
  public void encode(@NotNull Encoder e) throws IOException {
    ObjectFactory.encode(e, this);
  }

  @Override
  public void decode(@NotNull Decoder d) throws IOException {
    ObjectFactory.decode(d, this);
  }

  @Override
  public ObjectTypeID type() {
    return ObjectFactory.ArrayInfoID;
  }
}