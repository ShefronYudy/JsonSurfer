/*
 * Copyright (c) 2015 WANG Lingsong
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.leo.json.parse;

import org.leo.json.path.ArrayIndex;
import org.leo.json.path.ChildNode;
import org.leo.json.path.JsonPath;
import org.leo.json.path.PathOperator;
import org.leo.json.path.Root;

/**
 * Created by Leo on 2015/3/27.
 */
class JsonPosition extends JsonPath {

    //TODO recycling node for saving gc

    public static JsonPosition start() {
        JsonPosition newPath = new JsonPosition();
        newPath.operators.push(Root.instance());
        return newPath;
    }

    public PathOperator pop() {
        return operators.pop();
    }

    public JsonPosition stepInArray() {
        operators.push(new ArrayIndex());
        return this;
    }

    public JsonPosition stepInObject(String key) {
        operators.push(new ChildNode(key));
        return this;
    }

    public void clear() {
        operators.clear();
        operators = null;
    }

}