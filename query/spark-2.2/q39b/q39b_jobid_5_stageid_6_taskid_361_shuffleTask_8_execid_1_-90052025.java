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
/* 079 */     while (inputadapter_input.hasNext() && !stopEarly()) {
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
/* 180 */         double agg_value25 = agg_unsafeRowAggBuffer.getDouble(0);
/* 181 */
/* 182 */         double agg_value24 = -1.0;
/* 183 */         agg_value24 = agg_value25 + inputadapter_value4;
/* 184 */         boolean agg_isNull23 = false;
/* 185 */
/* 186 */         boolean agg_isNull24 = false;
/* 187 */
/* 188 */         double agg_value30 = agg_unsafeRowAggBuffer.getDouble(0);
/* 189 */
/* 190 */         double agg_value29 = -1.0;
/* 191 */         agg_value29 = agg_value30 + inputadapter_value4;
/* 192 */
/* 193 */         boolean agg_value28 = false;
/* 194 */         agg_value28 = (java.lang.Double.isNaN(agg_value29) && java.lang.Double.isNaN(0.0D)) || agg_value29 == 0.0D;
/* 195 */         boolean agg_isNull22 = false;
/* 196 */         double agg_value27 = -1.0;
/* 197 */         if (!false && agg_value28) {
/* 198 */           agg_isNull22 = false;
/* 199 */           agg_value27 = 0.0D;
/* 200 */         } else {
/* 201 */           boolean agg_isNull33 = false;
/* 202 */
/* 203 */           double agg_value39 = agg_unsafeRowAggBuffer.getDouble(0);
/* 204 */
/* 205 */           double agg_value38 = -1.0;
/* 206 */           agg_value38 = agg_value39 + inputadapter_value4;
/* 207 */           boolean agg_isNull29 = false;
/* 208 */           double agg_value34 = -1.0;
/* 209 */           if (agg_value38 == 0) {
/* 210 */             agg_isNull29 = true;
/* 211 */           } else {
/* 212 */             boolean agg_isNull30 = false;
/* 213 */
/* 214 */             double agg_value37 = agg_unsafeRowAggBuffer.getDouble(1);
/* 215 */             double agg_value35 = -1.0;
/* 216 */             agg_value35 = inputadapter_value5 - agg_value37;
/* 217 */             agg_value34 = (double)(agg_value35 / agg_value38);
/* 218 */           }
/* 219 */           agg_isNull22 = agg_isNull29;
/* 220 */           agg_value27 = agg_value34;
/* 221 */         }
/* 222 */         // evaluate aggregate function
/* 223 */         boolean agg_isNull36 = true;
/* 224 */         double agg_value41 = -1.0;
/* 225 */
/* 226 */         double agg_value42 = agg_unsafeRowAggBuffer.getDouble(1);
/* 227 */
/* 228 */         boolean agg_isNull38 = true;
/* 229 */         double agg_value43 = -1.0;
/* 230 */
/* 231 */         if (!agg_isNull22) {
/* 232 */           agg_isNull38 = false; // resultCode could change nullability.
/* 233 */           agg_value43 = agg_value27 * inputadapter_value4;
/* 234 */
/* 235 */         }
/* 236 */         if (!agg_isNull38) {
/* 237 */           agg_isNull36 = false; // resultCode could change nullability.
/* 238 */           agg_value41 = agg_value42 + agg_value43;
/* 239 */
/* 240 */         }
/* 241 */         boolean agg_isNull40 = true;
/* 242 */         double agg_value45 = -1.0;
/* 243 */
/* 244 */         boolean agg_isNull41 = false;
/* 245 */
/* 246 */         double agg_value47 = agg_unsafeRowAggBuffer.getDouble(2);
/* 247 */
/* 248 */         double agg_value46 = -1.0;
/* 249 */         agg_value46 = agg_value47 + inputadapter_value6;
/* 250 */
/* 251 */         boolean agg_isNull44 = true;
/* 252 */         double agg_value49 = -1.0;
/* 253 */
/* 254 */         boolean agg_isNull45 = true;
/* 255 */         double agg_value50 = -1.0;
/* 256 */
/* 257 */         boolean agg_isNull46 = true;
/* 258 */         double agg_value51 = -1.0;
/* 259 */
/* 260 */         boolean agg_isNull47 = false;
/* 261 */
/* 262 */         double agg_value54 = agg_unsafeRowAggBuffer.getDouble(1);
/* 263 */         double agg_value52 = -1.0;
/* 264 */         agg_value52 = inputadapter_value5 - agg_value54;
/* 265 */
/* 266 */         if (!agg_isNull22) {
/* 267 */           agg_isNull46 = false; // resultCode could change nullability.
/* 268 */           agg_value51 = agg_value52 * agg_value27;
/* 269 */
/* 270 */         }
/* 271 */         if (!agg_isNull46) {
/* 272 */           double agg_value55 = agg_unsafeRowAggBuffer.getDouble(0);
/* 273 */
/* 274 */           agg_isNull45 = false; // resultCode could change nullability.
/* 275 */           agg_value50 = agg_value51 * agg_value55;
/* 276 */
/* 277 */         }
/* 278 */         if (!agg_isNull45) {
/* 279 */           agg_isNull44 = false; // resultCode could change nullability.
/* 280 */           agg_value49 = agg_value50 * inputadapter_value4;
/* 281 */
/* 282 */         }
/* 283 */         if (!agg_isNull44) {
/* 284 */           agg_isNull40 = false; // resultCode could change nullability.
/* 285 */           agg_value45 = agg_value46 + agg_value49;
/* 286 */
/* 287 */         }
/* 288 */         boolean agg_isNull52 = true;
/* 289 */         double agg_value57 = -1.0;
/* 290 */
/* 291 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 292 */         double agg_value58 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 293 */         if (!agg_isNull53) {
/* 294 */           if (!inputadapter_isNull7) {
/* 295 */             agg_isNull52 = false; // resultCode could change nullability.
/* 296 */             agg_value57 = agg_value58 + inputadapter_value7;
/* 297 */
/* 298 */           }
/* 299 */
/* 300 */         }
/* 301 */         boolean agg_isNull55 = true;
/* 302 */         long agg_value60 = -1L;
/* 303 */
/* 304 */         boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 305 */         long agg_value61 = agg_isNull56 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 306 */         if (!agg_isNull56) {
/* 307 */           if (!inputadapter_isNull8) {
/* 308 */             agg_isNull55 = false; // resultCode could change nullability.
/* 309 */             agg_value60 = agg_value61 + inputadapter_value8;
/* 310 */
/* 311 */           }
/* 312 */
/* 313 */         }
/* 314 */         // update unsafe row buffer
/* 315 */         agg_unsafeRowAggBuffer.setDouble(0, agg_value24);
/* 316 */
/* 317 */         if (!agg_isNull36) {
/* 318 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value41);
/* 319 */         } else {
/* 320 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 321 */         }
/* 322 */
/* 323 */         if (!agg_isNull40) {
/* 324 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value45);
/* 325 */         } else {
/* 326 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 327 */         }
/* 328 */
/* 329 */         if (!agg_isNull52) {
/* 330 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value57);
/* 331 */         } else {
/* 332 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 333 */         }
/* 334 */
/* 335 */         if (!agg_isNull55) {
/* 336 */           agg_unsafeRowAggBuffer.setLong(4, agg_value60);
/* 337 */         } else {
/* 338 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 339 */         }
/* 340 */
/* 341 */       }
/* 342 */       if (shouldStop()) return;
/* 343 */     }
/* 344 */
/* 345 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 346 */   }
/* 347 */
/* 348 */   private void wholestagecodegen_init_1() {
/* 349 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 350 */     project_result = new UnsafeRow(5);
/* 351 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 352 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 5);
/* 353 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 354 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 355 */
/* 356 */   }
/* 357 */
/* 358 */   protected void processNext() throws java.io.IOException {
/* 359 */     if (!agg_initAgg) {
/* 360 */       agg_initAgg = true;
/* 361 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 362 */       agg_doAggregateWithKeys();
/* 363 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 364 */     }
/* 365 */
/* 366 */     // output the result
/* 367 */
/* 368 */     while (agg_mapIter.next()) {
/* 369 */       wholestagecodegen_numOutputRows.add(1);
/* 370 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 371 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 372 */
/* 373 */       boolean agg_isNull58 = agg_aggKey.isNullAt(0);
/* 374 */       UTF8String agg_value63 = agg_isNull58 ? null : (agg_aggKey.getUTF8String(0));
/* 375 */       boolean agg_isNull59 = agg_aggKey.isNullAt(1);
/* 376 */       int agg_value64 = agg_isNull59 ? -1 : (agg_aggKey.getInt(1));
/* 377 */       boolean agg_isNull60 = agg_aggKey.isNullAt(2);
/* 378 */       int agg_value65 = agg_isNull60 ? -1 : (agg_aggKey.getInt(2));
/* 379 */       boolean agg_isNull61 = agg_aggKey.isNullAt(3);
/* 380 */       int agg_value66 = agg_isNull61 ? -1 : (agg_aggKey.getInt(3));
/* 381 */       double agg_value67 = agg_aggBuffer.getDouble(0);
/* 382 */       double agg_value68 = agg_aggBuffer.getDouble(1);
/* 383 */       double agg_value69 = agg_aggBuffer.getDouble(2);
/* 384 */       boolean agg_isNull65 = agg_aggBuffer.isNullAt(3);
/* 385 */       double agg_value70 = agg_isNull65 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 386 */       boolean agg_isNull66 = agg_aggBuffer.isNullAt(4);
/* 387 */       long agg_value71 = agg_isNull66 ? -1L : (agg_aggBuffer.getLong(4));
/* 388 */       boolean agg_isNull68 = false;
/* 389 */
/* 390 */       boolean agg_value73 = false;
/* 391 */       agg_value73 = (java.lang.Double.isNaN(agg_value67) && java.lang.Double.isNaN(0.0D)) || agg_value67 == 0.0D;
/* 392 */       boolean agg_isNull67 = false;
/* 393 */       double agg_value72 = -1.0;
/* 394 */       if (!false && agg_value73) {
/* 395 */         final double agg_value76 = -1.0;
/* 396 */         agg_isNull67 = true;
/* 397 */         agg_value72 = agg_value76;
/* 398 */       } else {
/* 399 */         boolean agg_isNull73 = false;
/* 400 */
/* 401 */         boolean agg_value78 = false;
/* 402 */         agg_value78 = (java.lang.Double.isNaN(agg_value67) && java.lang.Double.isNaN(1.0D)) || agg_value67 == 1.0D;
/* 403 */         boolean agg_isNull72 = false;
/* 404 */         double agg_value77 = -1.0;
/* 405 */         if (!false && agg_value78) {
/* 406 */           final double agg_value81 = (double) ((java.lang.Double) references[3]);
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
/* 433 */       boolean agg_isNull85 = agg_isNull66;
/* 434 */       double agg_value90 = -1.0;
/* 435 */       if (!agg_isNull66) {
/* 436 */         agg_value90 = (double) agg_value71;
/* 437 */       }
/* 438 */       boolean agg_isNull83 = false;
/* 439 */       double agg_value88 = -1.0;
/* 440 */       if (agg_isNull85 || agg_value90 == 0) {
/* 441 */         agg_isNull83 = true;
/* 442 */       } else {
/* 443 */         if (agg_isNull65) {
/* 444 */           agg_isNull83 = true;
/* 445 */         } else {
/* 446 */           agg_value88 = (double)(agg_value70 / agg_value90);
/* 447 */         }
/* 448 */       }
/* 449 */
/* 450 */       boolean filter_isNull = true;
/* 451 */       boolean filter_value = false;
/* 452 */
/* 453 */       boolean filter_isNull1 = true;
/* 454 */       double filter_value1 = -1.0;
/* 455 */
/* 456 */       boolean filter_isNull2 = true;
/* 457 */       boolean filter_value2 = false;
/* 458 */
/* 459 */       if (!agg_isNull83) {
/* 460 */         filter_isNull2 = false; // resultCode could change nullability.
/* 461 */         filter_value2 = (java.lang.Double.isNaN(agg_value88) && java.lang.Double.isNaN(0.0D)) || agg_value88 == 0.0D;
/* 462 */
/* 463 */       }
/* 464 */       if (!filter_isNull2 && filter_value2) {
/* 465 */         filter_isNull1 = false;
/* 466 */         filter_value1 = 0.0D;
/* 467 */       }
/* 468 */
/* 469 */       else {
/* 470 */         boolean filter_isNull6 = false;
/* 471 */         double filter_value6 = -1.0;
/* 472 */         if (agg_isNull83 || agg_value88 == 0) {
/* 473 */           filter_isNull6 = true;
/* 474 */         } else {
/* 475 */           if (agg_isNull67) {
/* 476 */             filter_isNull6 = true;
/* 477 */           } else {
/* 478 */             filter_value6 = (double)(agg_value72 / agg_value88);
/* 479 */           }
/* 480 */         }
/* 481 */         filter_isNull1 = filter_isNull6;
/* 482 */         filter_value1 = filter_value6;
/* 483 */       }
/* 484 */       if (!filter_isNull1) {
/* 485 */         filter_isNull = false; // resultCode could change nullability.
/* 486 */         filter_value = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value1, 1.0D) > 0;
/* 487 */
/* 488 */       }
/* 489 */       if (filter_isNull || !filter_value) continue;
/* 490 */       boolean filter_isNull10 = true;
/* 491 */       boolean filter_value10 = false;
/* 492 */
/* 493 */       boolean filter_isNull11 = true;
/* 494 */       double filter_value11 = -1.0;
/* 495 */
/* 496 */       boolean filter_isNull12 = true;
/* 497 */       boolean filter_value12 = false;
/* 498 */
/* 499 */       if (!agg_isNull83) {
/* 500 */         filter_isNull12 = false; // resultCode could change nullability.
/* 501 */         filter_value12 = (java.lang.Double.isNaN(agg_value88) && java.lang.Double.isNaN(0.0D)) || agg_value88 == 0.0D;
/* 502 */
/* 503 */       }
/* 504 */       if (!filter_isNull12 && filter_value12) {
/* 505 */         final double filter_value15 = -1.0;
/* 506 */         filter_isNull11 = true;
/* 507 */         filter_value11 = filter_value15;
/* 508 */       }
/* 509 */
/* 510 */       else {
/* 511 */         boolean filter_isNull16 = false;
/* 512 */         double filter_value16 = -1.0;
/* 513 */         if (agg_isNull83 || agg_value88 == 0) {
/* 514 */           filter_isNull16 = true;
/* 515 */         } else {
/* 516 */           if (agg_isNull67) {
/* 517 */             filter_isNull16 = true;
/* 518 */           } else {
/* 519 */             filter_value16 = (double)(agg_value72 / agg_value88);
/* 520 */           }
/* 521 */         }
/* 522 */         filter_isNull11 = filter_isNull16;
/* 523 */         filter_value11 = filter_value16;
/* 524 */       }
/* 525 */       if (!filter_isNull11) {
/* 526 */         filter_isNull10 = false; // resultCode could change nullability.
/* 527 */         filter_value10 = org.apache.spark.util.Utils.nanSafeCompareDoubles(filter_value11, 1.5D) > 0;
/* 528 */
/* 529 */       }
/* 530 */       if (filter_isNull10 || !filter_value10) continue;
/* 531 */
/* 532 */       filter_numOutputRows.add(1);
/* 533 */
/* 534 */       boolean project_isNull4 = true;
/* 535 */       double project_value4 = -1.0;
/* 536 */
/* 537 */       boolean project_isNull5 = true;
/* 538 */       boolean project_value5 = false;
/* 539 */
/* 540 */       if (!agg_isNull83) {
/* 541 */         project_isNull5 = false; // resultCode could change nullability.
/* 542 */         project_value5 = (java.lang.Double.isNaN(agg_value88) && java.lang.Double.isNaN(0.0D)) || agg_value88 == 0.0D;
/* 543 */
/* 544 */       }
/* 545 */       if (!project_isNull5 && project_value5) {
/* 546 */         final double project_value8 = -1.0;
/* 547 */         project_isNull4 = true;
/* 548 */         project_value4 = project_value8;
/* 549 */       }
/* 550 */
/* 551 */       else {
/* 552 */         boolean project_isNull9 = false;
/* 553 */         double project_value9 = -1.0;
/* 554 */         if (agg_isNull83 || agg_value88 == 0) {
/* 555 */           project_isNull9 = true;
/* 556 */         } else {
/* 557 */           if (agg_isNull67) {
/* 558 */             project_isNull9 = true;
/* 559 */           } else {
/* 560 */             project_value9 = (double)(agg_value72 / agg_value88);
/* 561 */           }
/* 562 */         }
/* 563 */         project_isNull4 = project_isNull9;
/* 564 */         project_value4 = project_value9;
/* 565 */       }
/* 566 */       project_rowWriter.zeroOutNullBytes();
/* 567 */
/* 568 */       if (agg_isNull59) {
/* 569 */         project_rowWriter.setNullAt(0);
/* 570 */       } else {
/* 571 */         project_rowWriter.write(0, agg_value64);
/* 572 */       }
/* 573 */
/* 574 */       if (agg_isNull60) {
/* 575 */         project_rowWriter.setNullAt(1);
/* 576 */       } else {
/* 577 */         project_rowWriter.write(1, agg_value65);
/* 578 */       }
/* 579 */
/* 580 */       if (agg_isNull61) {
/* 581 */         project_rowWriter.setNullAt(2);
/* 582 */       } else {
/* 583 */         project_rowWriter.write(2, agg_value66);
/* 584 */       }
/* 585 */
/* 586 */       if (agg_isNull83) {
/* 587 */         project_rowWriter.setNullAt(3);
/* 588 */       } else {
/* 589 */         project_rowWriter.write(3, agg_value88);
/* 590 */       }
/* 591 */
/* 592 */       if (project_isNull4) {
/* 593 */         project_rowWriter.setNullAt(4);
/* 594 */       } else {
/* 595 */         project_rowWriter.write(4, project_value4);
/* 596 */       }
/* 597 */       append(project_result);
/* 598 */
/* 599 */       if (shouldStop()) return;
/* 600 */     }
/* 601 */
/* 602 */     agg_mapIter.close();
/* 603 */     if (agg_sorter == null) {
/* 604 */       agg_hashMap.free();
/* 605 */     }
/* 606 */   }
/* 607 */ }
