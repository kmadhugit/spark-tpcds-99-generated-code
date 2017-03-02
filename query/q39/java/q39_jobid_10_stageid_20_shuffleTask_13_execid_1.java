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
/* 018 */   private long agg_bufValue4;
/* 019 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 020 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 021 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 025 */   private scala.collection.Iterator inputadapter_input;
/* 026 */   private UnsafeRow agg_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 029 */   private int agg_value19;
/* 030 */   private UnsafeRow agg_result1;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 034 */   private UnsafeRow filter_result;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 037 */   private UnsafeRow project_result;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 042 */
/* 043 */   public GeneratedIterator(Object[] references) {
/* 044 */     this.references = references;
/* 045 */   }
/* 046 */
/* 047 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 048 */     partitionIndex = index;
/* 049 */     this.inputs = inputs;
/* 050 */     wholestagecodegen_init_0();
/* 051 */     wholestagecodegen_init_1();
/* 052 */
/* 053 */   }
/* 054 */
/* 055 */   private void wholestagecodegen_init_0() {
/* 056 */     agg_initAgg = false;
/* 057 */
/* 058 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 059 */
/* 060 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 061 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 062 */     inputadapter_input = inputs[0];
/* 063 */     agg_result = new UnsafeRow(4);
/* 064 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 065 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 066 */
/* 067 */     agg_result1 = new UnsafeRow(5);
/* 068 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 069 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 070 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 071 */     filter_result = new UnsafeRow(5);
/* 072 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 073 */
/* 074 */   }
/* 075 */
/* 076 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 077 */     agg_hashMap = agg_plan.createHashMap();
/* 078 */
/* 079 */     while (inputadapter_input.hasNext()) {
/* 080 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 081 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 082 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 083 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 084 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 085 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 086 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 087 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 088 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 089 */       double inputadapter_value4 = inputadapter_row.getDouble(4);
/* 090 */       double inputadapter_value5 = inputadapter_row.getDouble(5);
/* 091 */       double inputadapter_value6 = inputadapter_row.getDouble(6);
/* 092 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 093 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 094 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 095 */       long inputadapter_value8 = inputadapter_isNull8 ? -1L : (inputadapter_row.getLong(8));
/* 096 */
/* 097 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 098 */
/* 099 */       UnsafeRow agg_fastAggBuffer = null;
/* 100 */
/* 101 */       if (agg_fastAggBuffer == null) {
/* 102 */         // generate grouping key
/* 103 */         agg_holder.reset();
/* 104 */
/* 105 */         agg_rowWriter.zeroOutNullBytes();
/* 106 */
/* 107 */         if (inputadapter_isNull) {
/* 108 */           agg_rowWriter.setNullAt(0);
/* 109 */         } else {
/* 110 */           agg_rowWriter.write(0, inputadapter_value);
/* 111 */         }
/* 112 */
/* 113 */         if (inputadapter_isNull1) {
/* 114 */           agg_rowWriter.setNullAt(1);
/* 115 */         } else {
/* 116 */           agg_rowWriter.write(1, inputadapter_value1);
/* 117 */         }
/* 118 */
/* 119 */         if (inputadapter_isNull2) {
/* 120 */           agg_rowWriter.setNullAt(2);
/* 121 */         } else {
/* 122 */           agg_rowWriter.write(2, inputadapter_value2);
/* 123 */         }
/* 124 */
/* 125 */         if (inputadapter_isNull3) {
/* 126 */           agg_rowWriter.setNullAt(3);
/* 127 */         } else {
/* 128 */           agg_rowWriter.write(3, inputadapter_value3);
/* 129 */         }
/* 130 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 131 */         agg_value19 = 42;
/* 132 */
/* 133 */         if (!inputadapter_isNull) {
/* 134 */           agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value19);
/* 135 */         }
/* 136 */
/* 137 */         if (!inputadapter_isNull1) {
/* 138 */           agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value19);
/* 139 */         }
/* 140 */
/* 141 */         if (!inputadapter_isNull2) {
/* 142 */           agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value19);
/* 143 */         }
/* 144 */
/* 145 */         if (!inputadapter_isNull3) {
/* 146 */           agg_value19 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value19);
/* 147 */         }
/* 148 */         if (true) {
/* 149 */           // try to get the buffer from hash map
/* 150 */           agg_unsafeRowAggBuffer =
/* 151 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value19);
/* 152 */         }
/* 153 */         if (agg_unsafeRowAggBuffer == null) {
/* 154 */           if (agg_sorter == null) {
/* 155 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 156 */           } else {
/* 157 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 158 */           }
/* 159 */
/* 160 */           // the hash map had be spilled, it should have enough memory now,
/* 161 */           // try  to allocate buffer again.
/* 162 */           agg_unsafeRowAggBuffer =
/* 163 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value19);
/* 164 */           if (agg_unsafeRowAggBuffer == null) {
/* 165 */             // failed to allocate the first page
/* 166 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 167 */           }
/* 168 */         }
/* 169 */       }
/* 170 */
/* 171 */       if (agg_fastAggBuffer != null) {
/* 172 */         // update fast row
/* 173 */
/* 174 */       } else {
/* 175 */         // update unsafe row
/* 176 */
/* 177 */         // common sub-expressions
/* 178 */         boolean agg_isNull19 = false;
/* 179 */
/* 180 */         double agg_value26 = agg_unsafeRowAggBuffer.getDouble(1);
/* 181 */         double agg_value24 = -1.0;
/* 182 */         agg_value24 = inputadapter_value5 - agg_value26;
/* 183 */         boolean agg_isNull22 = false;
/* 184 */
/* 185 */         double agg_value28 = agg_unsafeRowAggBuffer.getDouble(0);
/* 186 */
/* 187 */         double agg_value27 = -1.0;
/* 188 */         agg_value27 = agg_value28 + inputadapter_value4;
/* 189 */         boolean agg_isNull26 = false;
/* 190 */
/* 191 */         boolean agg_isNull27 = false;
/* 192 */
/* 193 */         double agg_value33 = agg_unsafeRowAggBuffer.getDouble(0);
/* 194 */
/* 195 */         double agg_value32 = -1.0;
/* 196 */         agg_value32 = agg_value33 + inputadapter_value4;
/* 197 */
/* 198 */         boolean agg_value31 = false;
/* 199 */         agg_value31 = (java.lang.Double.isNaN(agg_value32) && java.lang.Double.isNaN(0.0D)) || agg_value32 == 0.0D;
/* 200 */         boolean agg_isNull25 = false;
/* 201 */         double agg_value30 = -1.0;
/* 202 */         if (!false && agg_value31) {
/* 203 */           agg_isNull25 = false;
/* 204 */           agg_value30 = 0.0D;
/* 205 */         } else {
/* 206 */           boolean agg_isNull36 = false;
/* 207 */
/* 208 */           double agg_value42 = agg_unsafeRowAggBuffer.getDouble(0);
/* 209 */
/* 210 */           double agg_value41 = -1.0;
/* 211 */           agg_value41 = agg_value42 + inputadapter_value4;
/* 212 */           boolean agg_isNull32 = false;
/* 213 */           double agg_value37 = -1.0;
/* 214 */           if (agg_value41 == 0) {
/* 215 */             agg_isNull32 = true;
/* 216 */           } else {
/* 217 */             boolean agg_isNull33 = false;
/* 218 */
/* 219 */             double agg_value40 = agg_unsafeRowAggBuffer.getDouble(1);
/* 220 */             double agg_value38 = -1.0;
/* 221 */             agg_value38 = inputadapter_value5 - agg_value40;
/* 222 */             agg_value37 = (double)(agg_value38 / agg_value41);
/* 223 */           }
/* 224 */           agg_isNull25 = agg_isNull32;
/* 225 */           agg_value30 = agg_value37;
/* 226 */         }
/* 227 */         // evaluate aggregate function
/* 228 */         boolean agg_isNull39 = true;
/* 229 */         double agg_value44 = -1.0;
/* 230 */
/* 231 */         double agg_value45 = agg_unsafeRowAggBuffer.getDouble(1);
/* 232 */
/* 233 */         boolean agg_isNull41 = true;
/* 234 */         double agg_value46 = -1.0;
/* 235 */
/* 236 */         if (!agg_isNull25) {
/* 237 */           agg_isNull41 = false; // resultCode could change nullability.
/* 238 */           agg_value46 = agg_value30 * inputadapter_value4;
/* 239 */
/* 240 */         }
/* 241 */         if (!agg_isNull41) {
/* 242 */           agg_isNull39 = false; // resultCode could change nullability.
/* 243 */           agg_value44 = agg_value45 + agg_value46;
/* 244 */
/* 245 */         }
/* 246 */         boolean agg_isNull43 = true;
/* 247 */         double agg_value48 = -1.0;
/* 248 */
/* 249 */         boolean agg_isNull44 = false;
/* 250 */
/* 251 */         double agg_value50 = agg_unsafeRowAggBuffer.getDouble(2);
/* 252 */
/* 253 */         double agg_value49 = -1.0;
/* 254 */         agg_value49 = agg_value50 + inputadapter_value6;
/* 255 */
/* 256 */         boolean agg_isNull47 = true;
/* 257 */         double agg_value52 = -1.0;
/* 258 */
/* 259 */         boolean agg_isNull48 = true;
/* 260 */         double agg_value53 = -1.0;
/* 261 */
/* 262 */         boolean agg_isNull49 = true;
/* 263 */         double agg_value54 = -1.0;
/* 264 */
/* 265 */         if (!agg_isNull25) {
/* 266 */           agg_isNull49 = false; // resultCode could change nullability.
/* 267 */           agg_value54 = agg_value24 * agg_value30;
/* 268 */
/* 269 */         }
/* 270 */         if (!agg_isNull49) {
/* 271 */           double agg_value55 = agg_unsafeRowAggBuffer.getDouble(0);
/* 272 */
/* 273 */           agg_isNull48 = false; // resultCode could change nullability.
/* 274 */           agg_value53 = agg_value54 * agg_value55;
/* 275 */
/* 276 */         }
/* 277 */         if (!agg_isNull48) {
/* 278 */           agg_isNull47 = false; // resultCode could change nullability.
/* 279 */           agg_value52 = agg_value53 * inputadapter_value4;
/* 280 */
/* 281 */         }
/* 282 */         if (!agg_isNull47) {
/* 283 */           agg_isNull43 = false; // resultCode could change nullability.
/* 284 */           agg_value48 = agg_value49 + agg_value52;
/* 285 */
/* 286 */         }
/* 287 */         boolean agg_isNull52 = true;
/* 288 */         double agg_value57 = -1.0;
/* 289 */
/* 290 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 291 */         double agg_value58 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 292 */         if (!agg_isNull53) {
/* 293 */           if (!inputadapter_isNull7) {
/* 294 */             agg_isNull52 = false; // resultCode could change nullability.
/* 295 */             agg_value57 = agg_value58 + inputadapter_value7;
/* 296 */
/* 297 */           }
/* 298 */
/* 299 */         }
/* 300 */         boolean agg_isNull55 = true;
/* 301 */         long agg_value60 = -1L;
/* 302 */
/* 303 */         boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 304 */         long agg_value61 = agg_isNull56 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 305 */         if (!agg_isNull56) {
/* 306 */           if (!inputadapter_isNull8) {
/* 307 */             agg_isNull55 = false; // resultCode could change nullability.
/* 308 */             agg_value60 = agg_value61 + inputadapter_value8;
/* 309 */
/* 310 */           }
/* 311 */
/* 312 */         }
/* 313 */         // update unsafe row buffer
/* 314 */         agg_unsafeRowAggBuffer.setDouble(0, agg_value27);
/* 315 */
/* 316 */         if (!agg_isNull39) {
/* 317 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value44);
/* 318 */         } else {
/* 319 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 320 */         }
/* 321 */
/* 322 */         if (!agg_isNull43) {
/* 323 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value48);
/* 324 */         } else {
/* 325 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 326 */         }
/* 327 */
/* 328 */         if (!agg_isNull52) {
/* 329 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value57);
/* 330 */         } else {
/* 331 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 332 */         }
/* 333 */
/* 334 */         if (!agg_isNull55) {
/* 335 */           agg_unsafeRowAggBuffer.setLong(4, agg_value60);
/* 336 */         } else {
/* 337 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 338 */         }
/* 339 */
/* 340 */       }
/* 341 */       if (shouldStop()) return;
/* 342 */     }
/* 343 */
/* 344 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 345 */   }
/* 346 */
/* 347 */   private void wholestagecodegen_init_1() {
/* 348 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 349 */     project_result = new UnsafeRow(5);
/* 350 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 351 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 352 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 353 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 354 */
/* 355 */   }
/* 356 */
/* 357 */   protected void processNext() throws java.io.IOException {
/* 358 */     if (!agg_initAgg) {
/* 359 */       agg_initAgg = true;
/* 360 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 361 */       agg_doAggregateWithKeys();
/* 362 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 363 */     }
/* 364 */
/* 365 */     // output the result
/* 366 */
/* 367 */     while (agg_mapIter.next()) {
/* 368 */       wholestagecodegen_numOutputRows.add(1);
/* 369 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 370 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 371 */
/* 372 */       boolean agg_isNull58 = agg_aggKey.isNullAt(0);
/* 373 */       UTF8String agg_value63 = agg_isNull58 ? null : (agg_aggKey.getUTF8String(0));
/* 374 */       boolean agg_isNull59 = agg_aggKey.isNullAt(1);
/* 375 */       int agg_value64 = agg_isNull59 ? -1 : (agg_aggKey.getInt(1));
/* 376 */       boolean agg_isNull60 = agg_aggKey.isNullAt(2);
/* 377 */       int agg_value65 = agg_isNull60 ? -1 : (agg_aggKey.getInt(2));
/* 378 */       boolean agg_isNull61 = agg_aggKey.isNullAt(3);
/* 379 */       int agg_value66 = agg_isNull61 ? -1 : (agg_aggKey.getInt(3));
/* 380 */       double agg_value67 = agg_aggBuffer.getDouble(0);
/* 381 */       double agg_value68 = agg_aggBuffer.getDouble(1);
/* 382 */       double agg_value69 = agg_aggBuffer.getDouble(2);
/* 383 */       boolean agg_isNull65 = agg_aggBuffer.isNullAt(3);
/* 384 */       double agg_value70 = agg_isNull65 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 385 */       boolean agg_isNull66 = agg_aggBuffer.isNullAt(4);
/* 386 */       long agg_value71 = agg_isNull66 ? -1L : (agg_aggBuffer.getLong(4));
/* 387 */       boolean agg_isNull68 = false;
/* 388 */
/* 389 */       boolean agg_value73 = false;
/* 390 */       agg_value73 = (java.lang.Double.isNaN(agg_value67) && java.lang.Double.isNaN(0.0D)) || agg_value67 == 0.0D;
/* 391 */       boolean agg_isNull67 = false;
/* 392 */       double agg_value72 = -1.0;
/* 393 */       if (!false && agg_value73) {
/* 394 */         final double agg_value76 = -1.0;
/* 395 */         agg_isNull67 = true;
/* 396 */         agg_value72 = agg_value76;
/* 397 */       } else {
/* 398 */         boolean agg_isNull73 = false;
/* 399 */
/* 400 */         boolean agg_value78 = false;
/* 401 */         agg_value78 = (java.lang.Double.isNaN(agg_value67) && java.lang.Double.isNaN(1.0D)) || agg_value67 == 1.0D;
/* 402 */         boolean agg_isNull72 = false;
/* 403 */         double agg_value77 = -1.0;
/* 404 */         if (!false && agg_value78) {
/* 405 */           Object agg_obj = ((Expression) references[3]).eval(null);
/* 406 */           double agg_value81 = (Double) agg_obj;
/* 407 */           agg_isNull72 = false;
/* 408 */           agg_value77 = agg_value81;
/* 409 */         } else {
/* 410 */           boolean agg_isNull80 = false;
/* 411 */
/* 412 */           double agg_value85 = -1.0;
/* 413 */           agg_value85 = agg_value67 - 1.0D;
/* 414 */           boolean agg_isNull78 = false;
/* 415 */           double agg_value83 = -1.0;
/* 416 */           if (agg_value85 == 0) {
/* 417 */             agg_isNull78 = true;
/* 418 */           } else {
/* 419 */             agg_value83 = (double)(agg_value69 / agg_value85);
/* 420 */           }
/* 421 */           boolean agg_isNull77 = agg_isNull78;
/* 422 */           double agg_value82 = -1.0;
/* 423 */
/* 424 */           if (!agg_isNull78) {
/* 425 */             agg_value82 = java.lang.Math.sqrt(agg_value83);
/* 426 */           }
/* 427 */           agg_isNull72 = agg_isNull77;
/* 428 */           agg_value77 = agg_value82;
/* 429 */         }
/* 430 */         agg_isNull67 = agg_isNull72;
/* 431 */         agg_value72 = agg_value77;
/* 432 */       }
/* 433 */       boolean agg_isNull86 = agg_isNull66;
/* 434 */       double agg_value91 = -1.0;
/* 435 */       if (!agg_isNull66) {
/* 436 */         agg_value91 = (double) agg_value71;
/* 437 */       }
/* 438 */       boolean agg_isNull83 = false;
/* 439 */       double agg_value88 = -1.0;
/* 440 */       if (agg_isNull86 || agg_value91 == 0) {
/* 441 */         agg_isNull83 = true;
/* 442 */       } else {
/* 443 */         boolean agg_isNull84 = agg_isNull65;
/* 444 */         double agg_value89 = -1.0;
/* 445 */         if (!agg_isNull65) {
/* 446 */           agg_value89 = agg_value70;
/* 447 */         }
/* 448 */         if (agg_isNull84) {
/* 449 */           agg_isNull83 = true;
/* 450 */         } else {
/* 451 */           agg_value88 = (double)(agg_value89 / agg_value91);
/* 452 */         }
/* 453 */       }
/* 454 */
/* 455 */       boolean filter_isNull = true;
/* 456 */       boolean filter_value = false;
/* 457 */
/* 458 */       boolean filter_isNull1 = true;
/* 459 */       double filter_value1 = -1.0;
/* 460 */
/* 461 */       boolean filter_isNull2 = true;
/* 462 */       boolean filter_value2 = false;
/* 463 */
/* 464 */       if (!agg_isNull83) {
/* 465 */         filter_isNull2 = false; // resultCode could change nullability.
/* 466 */         filter_value2 = (java.lang.Double.isNaN(agg_value88) && java.lang.Double.isNaN(0.0D)) || agg_value88 == 0.0D;
/* 467 */
/* 468 */       }
/* 469 */       if (!filter_isNull2 && filter_value2) {
/* 470 */         filter_isNull1 = false;
/* 471 */         filter_value1 = 0.0D;
/* 472 */       }
/* 473 */
/* 474 */       else {
/* 475 */         boolean filter_isNull6 = false;
/* 476 */         double filter_value6 = -1.0;
/* 477 */         if (agg_isNull83 || agg_value88 == 0) {
/* 478 */           filter_isNull6 = true;
/* 479 */         } else {
/* 480 */           if (agg_isNull67) {
/* 481 */             filter_isNull6 = true;
/* 482 */           } else {
/* 483 */             filter_value6 = (double)(agg_value72 / agg_value88);
/* 484 */           }
/* 485 */         }
/* 486 */         filter_isNull1 = filter_isNull6;
/* 487 */         filter_value1 = filter_value6;
/* 488 */       }
/* 489 */       if (!filter_isNull1) {
/* 490 */         filter_isNull = false; // resultCode could change nullability.
/* 491 */         filter_value = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value1, 1.0D) > 0;
/* 492 */
/* 493 */       }
/* 494 */       if (filter_isNull || !filter_value) continue;
/* 495 */       boolean filter_isNull10 = true;
/* 496 */       boolean filter_value10 = false;
/* 497 */
/* 498 */       boolean filter_isNull11 = true;
/* 499 */       double filter_value11 = -1.0;
/* 500 */
/* 501 */       boolean filter_isNull12 = true;
/* 502 */       boolean filter_value12 = false;
/* 503 */
/* 504 */       if (!agg_isNull83) {
/* 505 */         filter_isNull12 = false; // resultCode could change nullability.
/* 506 */         filter_value12 = (java.lang.Double.isNaN(agg_value88) && java.lang.Double.isNaN(0.0D)) || agg_value88 == 0.0D;
/* 507 */
/* 508 */       }
/* 509 */       if (!filter_isNull12 && filter_value12) {
/* 510 */         final double filter_value15 = -1.0;
/* 511 */         filter_isNull11 = true;
/* 512 */         filter_value11 = filter_value15;
/* 513 */       }
/* 514 */
/* 515 */       else {
/* 516 */         boolean filter_isNull16 = false;
/* 517 */         double filter_value16 = -1.0;
/* 518 */         if (agg_isNull83 || agg_value88 == 0) {
/* 519 */           filter_isNull16 = true;
/* 520 */         } else {
/* 521 */           if (agg_isNull67) {
/* 522 */             filter_isNull16 = true;
/* 523 */           } else {
/* 524 */             filter_value16 = (double)(agg_value72 / agg_value88);
/* 525 */           }
/* 526 */         }
/* 527 */         filter_isNull11 = filter_isNull16;
/* 528 */         filter_value11 = filter_value16;
/* 529 */       }
/* 530 */       if (!filter_isNull11) {
/* 531 */         filter_isNull10 = false; // resultCode could change nullability.
/* 532 */         filter_value10 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value11, 1.5D) > 0;
/* 533 */
/* 534 */       }
/* 535 */       if (filter_isNull10 || !filter_value10) continue;
/* 536 */
/* 537 */       filter_numOutputRows.add(1);
/* 538 */
/* 539 */       boolean project_isNull4 = true;
/* 540 */       double project_value4 = -1.0;
/* 541 */
/* 542 */       boolean project_isNull5 = true;
/* 543 */       boolean project_value5 = false;
/* 544 */
/* 545 */       if (!agg_isNull83) {
/* 546 */         project_isNull5 = false; // resultCode could change nullability.
/* 547 */         project_value5 = (java.lang.Double.isNaN(agg_value88) && java.lang.Double.isNaN(0.0D)) || agg_value88 == 0.0D;
/* 548 */
/* 549 */       }
/* 550 */       if (!project_isNull5 && project_value5) {
/* 551 */         final double project_value8 = -1.0;
/* 552 */         project_isNull4 = true;
/* 553 */         project_value4 = project_value8;
/* 554 */       }
/* 555 */
/* 556 */       else {
/* 557 */         boolean project_isNull9 = false;
/* 558 */         double project_value9 = -1.0;
/* 559 */         if (agg_isNull83 || agg_value88 == 0) {
/* 560 */           project_isNull9 = true;
/* 561 */         } else {
/* 562 */           if (agg_isNull67) {
/* 563 */             project_isNull9 = true;
/* 564 */           } else {
/* 565 */             project_value9 = (double)(agg_value72 / agg_value88);
/* 566 */           }
/* 567 */         }
/* 568 */         project_isNull4 = project_isNull9;
/* 569 */         project_value4 = project_value9;
/* 570 */       }
/* 571 */       project_rowWriter.zeroOutNullBytes();
/* 572 */
/* 573 */       if (agg_isNull59) {
/* 574 */         project_rowWriter.setNullAt(0);
/* 575 */       } else {
/* 576 */         project_rowWriter.write(0, agg_value64);
/* 577 */       }
/* 578 */
/* 579 */       if (agg_isNull60) {
/* 580 */         project_rowWriter.setNullAt(1);
/* 581 */       } else {
/* 582 */         project_rowWriter.write(1, agg_value65);
/* 583 */       }
/* 584 */
/* 585 */       if (agg_isNull61) {
/* 586 */         project_rowWriter.setNullAt(2);
/* 587 */       } else {
/* 588 */         project_rowWriter.write(2, agg_value66);
/* 589 */       }
/* 590 */
/* 591 */       if (agg_isNull83) {
/* 592 */         project_rowWriter.setNullAt(3);
/* 593 */       } else {
/* 594 */         project_rowWriter.write(3, agg_value88);
/* 595 */       }
/* 596 */
/* 597 */       if (project_isNull4) {
/* 598 */         project_rowWriter.setNullAt(4);
/* 599 */       } else {
/* 600 */         project_rowWriter.write(4, project_value4);
/* 601 */       }
/* 602 */       append(project_result);
/* 603 */
/* 604 */       if (shouldStop()) return;
/* 605 */     }
/* 606 */
/* 607 */     agg_mapIter.close();
/* 608 */     if (agg_sorter == null) {
/* 609 */       agg_hashMap.free();
/* 610 */     }
/* 611 */   }
/* 612 */ }
