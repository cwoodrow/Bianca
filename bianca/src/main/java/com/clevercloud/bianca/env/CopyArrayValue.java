/*
 * Copyright (c) 1998-2010 Caucho Technology -- all rights reserved
 * Copyright (c) 2011-2012 Clever Cloud SAS -- all rights reserved
 *
 * This file is part of Bianca(R) Open Source
 *
 * Each copy or derived work must preserve the copyright notice and this
 * notice unmodified.
 *
 * Bianca Open Source is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Bianca Open Source is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE, or any warranty
 * of NON-INFRINGEMENT.  See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Bianca Open Source; if not, write to the
 *
 *   Free Software Foundation, Inc.
 *   59 Temple Place, Suite 330
 *   Boston, MA 02111-1307  USA
 *
 * @author Scott Ferguson
 */
package com.clevercloud.bianca.env;

import java.util.IdentityHashMap;
import java.util.logging.Logger;


/**
 * Represents a PHP array value.
 */
public class CopyArrayValue extends ArrayValue {

   private static final Logger log = Logger.getLogger(CopyArrayValue.class.getName());
   private final ConstArrayValue _constArray;
   private ArrayValue _copyArray;

   public CopyArrayValue(ConstArrayValue constArray) {
      _constArray = constArray;
   }

   /**
    * Converts to a boolean.
    */
   @Override
   public boolean toBoolean() {
      if (_copyArray != null) {
         return _copyArray.toBoolean();
      } else {
         return _constArray.toBoolean();
      }
   }

   /**
    * Copy for assignment.
    */
   @Override
   public Value copy() {
      if (_copyArray != null) {
         return _copyArray.copy();
      } else {
         return _constArray.copy();
      }
   }

   /**
    * Copy for serialization
    */
   @Override
   public Value copy(Env env, IdentityHashMap<Value, Value> map) {
      if (_copyArray != null) {
         return _copyArray.copy(env, map);
      } else {
         return _constArray.copy(env, map);
      }
   }

   /**
    * Copy for saving a function arguments.
    */
   @Override
   public Value copySaveFunArg() {
      if (_copyArray != null) {
         return _copyArray.copySaveFunArg();
      } else {
         return _constArray.copySaveFunArg();
      }
   }

   /**
    * Returns the size.
    */
   @Override
   public int getSize() {
      if (_copyArray != null) {
         return _copyArray.getSize();
      } else {
         return _constArray.getSize();
      }
   }

   /**
    * Clears the array
    */
   @Override
   public void clear() {
      getCopyArray().clear();
   }

   /**
    * Adds a new value.
    */
   @Override
   public Value put(Value key, Value value) {
      return getCopyArray().put(key, value);
   }

   /**
    * Add
    */
   @Override
   public Value put(Value value) {
      return getCopyArray().put(value);
   }

   /**
    * Add
    */
   @Override
   public ArrayValue unshift(Value value) {
      return getCopyArray().unshift(value);
   }

   /**
    * Splices.
    */
   @Override
   public ArrayValue splice(int start, int end, ArrayValue replace) {
      return getCopyArray().splice(start, end, replace);
   }

   /**
    * Slices.
    */
   @Override
   public ArrayValue slice(Env env, int start, int end, boolean isPreserveKeys) {
      return getCopyArray().slice(env, start, end, isPreserveKeys);
   }

   /**
    * Returns the value as an array.
    */
   @Override
   public Value getArray(Value fieldName) {
      return getCopyArray().getArray(fieldName);
   }

   /**
    * Returns the value as an argument which may be a reference.
    */
   @Override
   public Value getArg(Value index, boolean isTop) {
      return getCopyArray().getArg(index, isTop);
   }

   /**
    * Convert to an argument value.
    */
   @Override
   public Value toLocalValue() {
      return getCopyArray().toLocalValue();
   }

   /**
    * Returns the field value, creating an object if it's unset.
    */
   @Override
   public Value getObject(Env env, Value fieldName) {
      return getCopyArray().getObject(env, fieldName);
   }

   /**
    * Sets the array ref.
    */
   @Override
   public Var putVar() {
      return getCopyArray().putVar();
   }

   /**
    * Add
    */
   @Override
   public ArrayValue append(Value key, Value value) {
      return getCopyArray().append(key, value);
   }

   /**
    * Add
    */
   @Override
   public ArrayValue append(Value value) {
      return getCopyArray().append(value);
   }

   /**
    * Gets a new value.
    */
   @Override
   public Value get(Value key) {
      if (_copyArray != null) {
         return _copyArray.get(key);
      } else {
         return _constArray.get(key);
      }
   }

   /**
    * Returns the corresponding key if this array contains the given value
    *
    * @param value to search for in the array
    * @return the key if it is found in the array, NULL otherwise
    */
   @Override
   public Value contains(Value value) {
      if (_copyArray != null) {
         return _copyArray.contains(value);
      } else {
         return _constArray.contains(value);
      }
   }

   /**
    * Returns the corresponding key if this array contains the given value
    *
    * @param value to search for in the array
    * @return the key if it is found in the array, NULL otherwise
    */
   @Override
   public Value containsStrict(Value value) {
      if (_copyArray != null) {
         return _copyArray.containsStrict(value);
      } else {
         return _constArray.containsStrict(value);
      }
   }

   /**
    * Returns the corresponding value if this array contains the given key
    *
    * @param key to search for in the array
    * @return the value if it is found in the array, NULL otherwise
    */
   @Override
   public Value containsKey(Value key) {
      if (_copyArray != null) {
         return _copyArray.containsKey(key);
      } else {
         return _constArray.containsKey(key);
      }
   }

   /**
    * Removes a value.
    */
   @Override
   public Value remove(Value key) {
      return getCopyArray().remove(key);
   }

   /**
    * Returns the array ref.
    */
   @Override
   public Var getVar(Value index) {
      return getCopyArray().getVar(index);
   }

   /**
    * Pops the top value.
    */
   @Override
   public Value pop(Env env) {
      return getCopyArray().pop(env);
   }

   /**
    * Pops the top value.
    */
   @Override
   public Value createTailKey() {
      return getCopyArray().createTailKey();
   }

   /**
    * Shuffles the array
    */
   @Override
   public Value shuffle() {
      return getCopyArray().shuffle();
   }

   @Override
   public Entry getHead() {
      if (_copyArray != null) {
         return _copyArray.getHead();
      } else {
         return _constArray.getHead();
      }
   }

   @Override
   protected Entry getTail() {
      if (_copyArray != null) {
         return _copyArray.getTail();
      } else {
         return _constArray.getTail();
      }
   }

   private ArrayValue getCopyArray() {
      if (_copyArray == null) {
         _copyArray = new ArrayValueImpl(_constArray);
      }

      return _copyArray;
   }

   @Override
   public int cmp(Value rValue) {
      if (_copyArray != null) {
         return _copyArray.cmp(rValue);
      } else {
         return _constArray.cmp(rValue);
      }
   }

   @Override
   public boolean eq(Value rValue) {
      if (_copyArray != null) {
         return _copyArray.eq(rValue);
      } else {
         return _constArray.eq(rValue);
      }
   }

   @Override
   public boolean eql(Value rValue) {
      if (_copyArray != null) {
         return _copyArray.eql(rValue);
      } else {
         return _constArray.eql(rValue);
      }
   }

   @Override
   public int hashCode() {
      if (_copyArray != null) {
         return _copyArray.hashCode();
      } else {
         return _constArray.hashCode();
      }
   }

   @Override
   public Value toValue() {
      /*
      if (_copyArray != null)
      return _copyArray;
      else
      return _constArray;
       */

      return this;
   }

   @Override
   public boolean equals(Object o) {
      if (_copyArray != null) {
         return _copyArray.equals(o);
      } else {
         return _constArray.equals(o);
      }
   }
}
