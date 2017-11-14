/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private double agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private double agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 024 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 025 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 026 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 029 */   private scala.collection.Iterator inputadapter_input;
/* 030 */   private UnsafeRow agg_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 033 */   private int agg_value18;
/* 034 */   private UnsafeRow agg_result1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 039 */
/* 040 */   public GeneratedIterator(Object[] references) {
/* 041 */     this.references = references;
/* 042 */   }
/* 043 */
/* 044 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 045 */     partitionIndex = index;
/* 046 */     this.inputs = inputs;
/* 047 */     agg_initAgg = false;
/* 048 */
/* 049 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 050 */
/* 051 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 052 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 053 */     inputadapter_input = inputs[0];
/* 054 */     agg_result = new UnsafeRow(2);
/* 055 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 64);
/* 056 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 057 */
/* 058 */     agg_result1 = new UnsafeRow(9);
/* 059 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 060 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 9);
/* 061 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 062 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 063 */
/* 064 */   }
/* 065 */
/* 066 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 067 */     agg_hashMap = agg_plan.createHashMap();
/* 068 */
/* 069 */     while (inputadapter_input.hasNext()) {
/* 070 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 071 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 072 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 073 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 074 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 075 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 076 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 077 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 078 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 079 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 080 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 081 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 082 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 083 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 084 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 085 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 086 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 087 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 088 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 089 */
/* 090 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 091 */
/* 092 */       UnsafeRow agg_fastAggBuffer = null;
/* 093 */
/* 094 */       if (agg_fastAggBuffer == null) {
/* 095 */         // generate grouping key
/* 096 */         agg_holder.reset();
/* 097 */
/* 098 */         agg_rowWriter.zeroOutNullBytes();
/* 099 */
/* 100 */         if (inputadapter_isNull) {
/* 101 */           agg_rowWriter.setNullAt(0);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(0, inputadapter_value);
/* 104 */         }
/* 105 */
/* 106 */         if (inputadapter_isNull1) {
/* 107 */           agg_rowWriter.setNullAt(1);
/* 108 */         } else {
/* 109 */           agg_rowWriter.write(1, inputadapter_value1);
/* 110 */         }
/* 111 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 112 */         agg_value18 = 42;
/* 113 */
/* 114 */         if (!inputadapter_isNull) {
/* 115 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value18);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull1) {
/* 119 */           agg_value18 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value18);
/* 120 */         }
/* 121 */         if (true) {
/* 122 */           // try to get the buffer from hash map
/* 123 */           agg_unsafeRowAggBuffer =
/* 124 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 125 */         }
/* 126 */         if (agg_unsafeRowAggBuffer == null) {
/* 127 */           if (agg_sorter == null) {
/* 128 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 129 */           } else {
/* 130 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 131 */           }
/* 132 */
/* 133 */           // the hash map had be spilled, it should have enough memory now,
/* 134 */           // try  to allocate buffer again.
/* 135 */           agg_unsafeRowAggBuffer =
/* 136 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value18);
/* 137 */           if (agg_unsafeRowAggBuffer == null) {
/* 138 */             // failed to allocate the first page
/* 139 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 140 */           }
/* 141 */         }
/* 142 */       }
/* 143 */
/* 144 */       if (agg_fastAggBuffer != null) {
/* 145 */         // update fast row
/* 146 */
/* 147 */       } else {
/* 148 */         // update unsafe row
/* 149 */
/* 150 */         // common sub-expressions
/* 151 */         boolean agg_isNull14 = false;
/* 152 */         double agg_value21 = -1.0;
/* 153 */         if (!false) {
/* 154 */           agg_value21 = (double) 0;
/* 155 */         }
/* 156 */         // evaluate aggregate function
/* 157 */         boolean agg_isNull17 = true;
/* 158 */         double agg_value24 = -1.0;
/* 159 */
/* 160 */         boolean agg_isNull19 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 161 */         double agg_value26 = agg_isNull19 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 162 */         boolean agg_isNull18 = agg_isNull19;
/* 163 */         double agg_value25 = agg_value26;
/* 164 */         if (agg_isNull18) {
/* 165 */           if (!agg_isNull14) {
/* 166 */             agg_isNull18 = false;
/* 167 */             agg_value25 = agg_value21;
/* 168 */           }
/* 169 */         }
/* 170 */
/* 171 */         if (!inputadapter_isNull2) {
/* 172 */           agg_isNull17 = false; // resultCode could change nullability.
/* 173 */           agg_value24 = agg_value25 + inputadapter_value2;
/* 174 */
/* 175 */         }
/* 176 */         boolean agg_isNull16 = agg_isNull17;
/* 177 */         double agg_value23 = agg_value24;
/* 178 */         if (agg_isNull16) {
/* 179 */           boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 180 */           double agg_value28 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 181 */           if (!agg_isNull21) {
/* 182 */             agg_isNull16 = false;
/* 183 */             agg_value23 = agg_value28;
/* 184 */           }
/* 185 */         }
/* 186 */         boolean agg_isNull23 = true;
/* 187 */         double agg_value30 = -1.0;
/* 188 */
/* 189 */         boolean agg_isNull25 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 190 */         double agg_value32 = agg_isNull25 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 191 */         boolean agg_isNull24 = agg_isNull25;
/* 192 */         double agg_value31 = agg_value32;
/* 193 */         if (agg_isNull24) {
/* 194 */           if (!agg_isNull14) {
/* 195 */             agg_isNull24 = false;
/* 196 */             agg_value31 = agg_value21;
/* 197 */           }
/* 198 */         }
/* 199 */
/* 200 */         if (!inputadapter_isNull3) {
/* 201 */           agg_isNull23 = false; // resultCode could change nullability.
/* 202 */           agg_value30 = agg_value31 + inputadapter_value3;
/* 203 */
/* 204 */         }
/* 205 */         boolean agg_isNull22 = agg_isNull23;
/* 206 */         double agg_value29 = agg_value30;
/* 207 */         if (agg_isNull22) {
/* 208 */           boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 209 */           double agg_value34 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 210 */           if (!agg_isNull27) {
/* 211 */             agg_isNull22 = false;
/* 212 */             agg_value29 = agg_value34;
/* 213 */           }
/* 214 */         }
/* 215 */         boolean agg_isNull29 = true;
/* 216 */         double agg_value36 = -1.0;
/* 217 */
/* 218 */         boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 219 */         double agg_value38 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 220 */         boolean agg_isNull30 = agg_isNull31;
/* 221 */         double agg_value37 = agg_value38;
/* 222 */         if (agg_isNull30) {
/* 223 */           if (!agg_isNull14) {
/* 224 */             agg_isNull30 = false;
/* 225 */             agg_value37 = agg_value21;
/* 226 */           }
/* 227 */         }
/* 228 */
/* 229 */         if (!inputadapter_isNull4) {
/* 230 */           agg_isNull29 = false; // resultCode could change nullability.
/* 231 */           agg_value36 = agg_value37 + inputadapter_value4;
/* 232 */
/* 233 */         }
/* 234 */         boolean agg_isNull28 = agg_isNull29;
/* 235 */         double agg_value35 = agg_value36;
/* 236 */         if (agg_isNull28) {
/* 237 */           boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 238 */           double agg_value40 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 239 */           if (!agg_isNull33) {
/* 240 */             agg_isNull28 = false;
/* 241 */             agg_value35 = agg_value40;
/* 242 */           }
/* 243 */         }
/* 244 */         boolean agg_isNull35 = true;
/* 245 */         double agg_value42 = -1.0;
/* 246 */
/* 247 */         boolean agg_isNull37 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 248 */         double agg_value44 = agg_isNull37 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 249 */         boolean agg_isNull36 = agg_isNull37;
/* 250 */         double agg_value43 = agg_value44;
/* 251 */         if (agg_isNull36) {
/* 252 */           if (!agg_isNull14) {
/* 253 */             agg_isNull36 = false;
/* 254 */             agg_value43 = agg_value21;
/* 255 */           }
/* 256 */         }
/* 257 */
/* 258 */         if (!inputadapter_isNull5) {
/* 259 */           agg_isNull35 = false; // resultCode could change nullability.
/* 260 */           agg_value42 = agg_value43 + inputadapter_value5;
/* 261 */
/* 262 */         }
/* 263 */         boolean agg_isNull34 = agg_isNull35;
/* 264 */         double agg_value41 = agg_value42;
/* 265 */         if (agg_isNull34) {
/* 266 */           boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 267 */           double agg_value46 = agg_isNull39 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 268 */           if (!agg_isNull39) {
/* 269 */             agg_isNull34 = false;
/* 270 */             agg_value41 = agg_value46;
/* 271 */           }
/* 272 */         }
/* 273 */         boolean agg_isNull41 = true;
/* 274 */         double agg_value48 = -1.0;
/* 275 */
/* 276 */         boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 277 */         double agg_value50 = agg_isNull43 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 278 */         boolean agg_isNull42 = agg_isNull43;
/* 279 */         double agg_value49 = agg_value50;
/* 280 */         if (agg_isNull42) {
/* 281 */           if (!agg_isNull14) {
/* 282 */             agg_isNull42 = false;
/* 283 */             agg_value49 = agg_value21;
/* 284 */           }
/* 285 */         }
/* 286 */
/* 287 */         if (!inputadapter_isNull6) {
/* 288 */           agg_isNull41 = false; // resultCode could change nullability.
/* 289 */           agg_value48 = agg_value49 + inputadapter_value6;
/* 290 */
/* 291 */         }
/* 292 */         boolean agg_isNull40 = agg_isNull41;
/* 293 */         double agg_value47 = agg_value48;
/* 294 */         if (agg_isNull40) {
/* 295 */           boolean agg_isNull45 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 296 */           double agg_value52 = agg_isNull45 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 297 */           if (!agg_isNull45) {
/* 298 */             agg_isNull40 = false;
/* 299 */             agg_value47 = agg_value52;
/* 300 */           }
/* 301 */         }
/* 302 */         boolean agg_isNull47 = true;
/* 303 */         double agg_value54 = -1.0;
/* 304 */
/* 305 */         boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 306 */         double agg_value56 = agg_isNull49 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 307 */         boolean agg_isNull48 = agg_isNull49;
/* 308 */         double agg_value55 = agg_value56;
/* 309 */         if (agg_isNull48) {
/* 310 */           if (!agg_isNull14) {
/* 311 */             agg_isNull48 = false;
/* 312 */             agg_value55 = agg_value21;
/* 313 */           }
/* 314 */         }
/* 315 */
/* 316 */         if (!inputadapter_isNull7) {
/* 317 */           agg_isNull47 = false; // resultCode could change nullability.
/* 318 */           agg_value54 = agg_value55 + inputadapter_value7;
/* 319 */
/* 320 */         }
/* 321 */         boolean agg_isNull46 = agg_isNull47;
/* 322 */         double agg_value53 = agg_value54;
/* 323 */         if (agg_isNull46) {
/* 324 */           boolean agg_isNull51 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 325 */           double agg_value58 = agg_isNull51 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 326 */           if (!agg_isNull51) {
/* 327 */             agg_isNull46 = false;
/* 328 */             agg_value53 = agg_value58;
/* 329 */           }
/* 330 */         }
/* 331 */         boolean agg_isNull53 = true;
/* 332 */         double agg_value60 = -1.0;
/* 333 */
/* 334 */         boolean agg_isNull55 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 335 */         double agg_value62 = agg_isNull55 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 336 */         boolean agg_isNull54 = agg_isNull55;
/* 337 */         double agg_value61 = agg_value62;
/* 338 */         if (agg_isNull54) {
/* 339 */           if (!agg_isNull14) {
/* 340 */             agg_isNull54 = false;
/* 341 */             agg_value61 = agg_value21;
/* 342 */           }
/* 343 */         }
/* 344 */
/* 345 */         if (!inputadapter_isNull8) {
/* 346 */           agg_isNull53 = false; // resultCode could change nullability.
/* 347 */           agg_value60 = agg_value61 + inputadapter_value8;
/* 348 */
/* 349 */         }
/* 350 */         boolean agg_isNull52 = agg_isNull53;
/* 351 */         double agg_value59 = agg_value60;
/* 352 */         if (agg_isNull52) {
/* 353 */           boolean agg_isNull57 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 354 */           double agg_value64 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 355 */           if (!agg_isNull57) {
/* 356 */             agg_isNull52 = false;
/* 357 */             agg_value59 = agg_value64;
/* 358 */           }
/* 359 */         }
/* 360 */         // update unsafe row buffer
/* 361 */         if (!agg_isNull16) {
/* 362 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value23);
/* 363 */         } else {
/* 364 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 365 */         }
/* 366 */
/* 367 */         if (!agg_isNull22) {
/* 368 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value29);
/* 369 */         } else {
/* 370 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 371 */         }
/* 372 */
/* 373 */         if (!agg_isNull28) {
/* 374 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value35);
/* 375 */         } else {
/* 376 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 377 */         }
/* 378 */
/* 379 */         if (!agg_isNull34) {
/* 380 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value41);
/* 381 */         } else {
/* 382 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 383 */         }
/* 384 */
/* 385 */         if (!agg_isNull40) {
/* 386 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value47);
/* 387 */         } else {
/* 388 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 389 */         }
/* 390 */
/* 391 */         if (!agg_isNull46) {
/* 392 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value53);
/* 393 */         } else {
/* 394 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 395 */         }
/* 396 */
/* 397 */         if (!agg_isNull52) {
/* 398 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value59);
/* 399 */         } else {
/* 400 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 401 */         }
/* 402 */
/* 403 */       }
/* 404 */       if (shouldStop()) return;
/* 405 */     }
/* 406 */
/* 407 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 408 */   }
/* 409 */
/* 410 */   protected void processNext() throws java.io.IOException {
/* 411 */     if (!agg_initAgg) {
/* 412 */       agg_initAgg = true;
/* 413 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 414 */       agg_doAggregateWithKeys();
/* 415 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 416 */     }
/* 417 */
/* 418 */     // output the result
/* 419 */
/* 420 */     while (agg_mapIter.next()) {
/* 421 */       wholestagecodegen_numOutputRows.add(1);
/* 422 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 423 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 424 */
/* 425 */       boolean agg_isNull58 = agg_aggKey.isNullAt(0);
/* 426 */       UTF8String agg_value65 = agg_isNull58 ? null : (agg_aggKey.getUTF8String(0));
/* 427 */       boolean agg_isNull59 = agg_aggKey.isNullAt(1);
/* 428 */       UTF8String agg_value66 = agg_isNull59 ? null : (agg_aggKey.getUTF8String(1));
/* 429 */       boolean agg_isNull60 = agg_aggBuffer.isNullAt(0);
/* 430 */       double agg_value67 = agg_isNull60 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 431 */       boolean agg_isNull61 = agg_aggBuffer.isNullAt(1);
/* 432 */       double agg_value68 = agg_isNull61 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 433 */       boolean agg_isNull62 = agg_aggBuffer.isNullAt(2);
/* 434 */       double agg_value69 = agg_isNull62 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 435 */       boolean agg_isNull63 = agg_aggBuffer.isNullAt(3);
/* 436 */       double agg_value70 = agg_isNull63 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 437 */       boolean agg_isNull64 = agg_aggBuffer.isNullAt(4);
/* 438 */       double agg_value71 = agg_isNull64 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 439 */       boolean agg_isNull65 = agg_aggBuffer.isNullAt(5);
/* 440 */       double agg_value72 = agg_isNull65 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 441 */       boolean agg_isNull66 = agg_aggBuffer.isNullAt(6);
/* 442 */       double agg_value73 = agg_isNull66 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 443 */
/* 444 */       agg_holder1.reset();
/* 445 */
/* 446 */       agg_rowWriter1.zeroOutNullBytes();
/* 447 */
/* 448 */       if (agg_isNull58) {
/* 449 */         agg_rowWriter1.setNullAt(0);
/* 450 */       } else {
/* 451 */         agg_rowWriter1.write(0, agg_value65);
/* 452 */       }
/* 453 */
/* 454 */       if (agg_isNull59) {
/* 455 */         agg_rowWriter1.setNullAt(1);
/* 456 */       } else {
/* 457 */         agg_rowWriter1.write(1, agg_value66);
/* 458 */       }
/* 459 */
/* 460 */       if (agg_isNull60) {
/* 461 */         agg_rowWriter1.setNullAt(2);
/* 462 */       } else {
/* 463 */         agg_rowWriter1.write(2, agg_value67);
/* 464 */       }
/* 465 */
/* 466 */       if (agg_isNull61) {
/* 467 */         agg_rowWriter1.setNullAt(3);
/* 468 */       } else {
/* 469 */         agg_rowWriter1.write(3, agg_value68);
/* 470 */       }
/* 471 */
/* 472 */       if (agg_isNull62) {
/* 473 */         agg_rowWriter1.setNullAt(4);
/* 474 */       } else {
/* 475 */         agg_rowWriter1.write(4, agg_value69);
/* 476 */       }
/* 477 */
/* 478 */       if (agg_isNull63) {
/* 479 */         agg_rowWriter1.setNullAt(5);
/* 480 */       } else {
/* 481 */         agg_rowWriter1.write(5, agg_value70);
/* 482 */       }
/* 483 */
/* 484 */       if (agg_isNull64) {
/* 485 */         agg_rowWriter1.setNullAt(6);
/* 486 */       } else {
/* 487 */         agg_rowWriter1.write(6, agg_value71);
/* 488 */       }
/* 489 */
/* 490 */       if (agg_isNull65) {
/* 491 */         agg_rowWriter1.setNullAt(7);
/* 492 */       } else {
/* 493 */         agg_rowWriter1.write(7, agg_value72);
/* 494 */       }
/* 495 */
/* 496 */       if (agg_isNull66) {
/* 497 */         agg_rowWriter1.setNullAt(8);
/* 498 */       } else {
/* 499 */         agg_rowWriter1.write(8, agg_value73);
/* 500 */       }
/* 501 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 502 */       append(agg_result1);
/* 503 */
/* 504 */       if (shouldStop()) return;
/* 505 */     }
/* 506 */
/* 507 */     agg_mapIter.close();
/* 508 */     if (agg_sorter == null) {
/* 509 */       agg_hashMap.free();
/* 510 */     }
/* 511 */   }
/* 512 */ }
