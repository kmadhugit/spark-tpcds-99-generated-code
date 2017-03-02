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
/* 033 */   private int agg_value16;
/* 034 */   private UnsafeRow agg_result1;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 037 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 038 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 040 */   private UnsafeRow bhj_result;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 043 */   private UnsafeRow project_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 048 */
/* 049 */   public GeneratedIterator(Object[] references) {
/* 050 */     this.references = references;
/* 051 */   }
/* 052 */
/* 053 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 054 */     partitionIndex = index;
/* 055 */     this.inputs = inputs;
/* 056 */     wholestagecodegen_init_0();
/* 057 */     wholestagecodegen_init_1();
/* 058 */
/* 059 */   }
/* 060 */
/* 061 */   private void wholestagecodegen_init_0() {
/* 062 */     agg_initAgg = false;
/* 063 */
/* 064 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 065 */
/* 066 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 067 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 068 */     inputadapter_input = inputs[0];
/* 069 */     agg_result = new UnsafeRow(1);
/* 070 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 071 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 072 */
/* 073 */     agg_result1 = new UnsafeRow(8);
/* 074 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 075 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 8);
/* 076 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 077 */
/* 078 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 079 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 084 */     agg_hashMap = agg_plan.createHashMap();
/* 085 */
/* 086 */     while (inputadapter_input.hasNext()) {
/* 087 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 088 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 089 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 090 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 091 */       double inputadapter_value1 = inputadapter_isNull1 ? -1.0 : (inputadapter_row.getDouble(1));
/* 092 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 093 */       double inputadapter_value2 = inputadapter_isNull2 ? -1.0 : (inputadapter_row.getDouble(2));
/* 094 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 095 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 096 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 097 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 098 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 099 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 100 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 101 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 102 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 103 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 104 */
/* 105 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 106 */
/* 107 */       UnsafeRow agg_fastAggBuffer = null;
/* 108 */
/* 109 */       if (agg_fastAggBuffer == null) {
/* 110 */         // generate grouping key
/* 111 */         agg_rowWriter.zeroOutNullBytes();
/* 112 */
/* 113 */         if (inputadapter_isNull) {
/* 114 */           agg_rowWriter.setNullAt(0);
/* 115 */         } else {
/* 116 */           agg_rowWriter.write(0, inputadapter_value);
/* 117 */         }
/* 118 */         agg_value16 = 42;
/* 119 */
/* 120 */         if (!inputadapter_isNull) {
/* 121 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value16);
/* 122 */         }
/* 123 */         if (true) {
/* 124 */           // try to get the buffer from hash map
/* 125 */           agg_unsafeRowAggBuffer =
/* 126 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 127 */         }
/* 128 */         if (agg_unsafeRowAggBuffer == null) {
/* 129 */           if (agg_sorter == null) {
/* 130 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 131 */           } else {
/* 132 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 133 */           }
/* 134 */
/* 135 */           // the hash map had be spilled, it should have enough memory now,
/* 136 */           // try  to allocate buffer again.
/* 137 */           agg_unsafeRowAggBuffer =
/* 138 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 139 */           if (agg_unsafeRowAggBuffer == null) {
/* 140 */             // failed to allocate the first page
/* 141 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 142 */           }
/* 143 */         }
/* 144 */       }
/* 145 */
/* 146 */       if (agg_fastAggBuffer != null) {
/* 147 */         // update fast row
/* 148 */
/* 149 */       } else {
/* 150 */         // update unsafe row
/* 151 */
/* 152 */         // common sub-expressions
/* 153 */         boolean agg_isNull11 = false;
/* 154 */         double agg_value18 = -1.0;
/* 155 */         if (!false) {
/* 156 */           agg_value18 = (double) 0;
/* 157 */         }
/* 158 */         // evaluate aggregate function
/* 159 */         boolean agg_isNull14 = true;
/* 160 */         double agg_value21 = -1.0;
/* 161 */
/* 162 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 163 */         double agg_value23 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 164 */         boolean agg_isNull15 = agg_isNull16;
/* 165 */         double agg_value22 = agg_value23;
/* 166 */         if (agg_isNull15) {
/* 167 */           if (!agg_isNull11) {
/* 168 */             agg_isNull15 = false;
/* 169 */             agg_value22 = agg_value18;
/* 170 */           }
/* 171 */         }
/* 172 */
/* 173 */         if (!inputadapter_isNull1) {
/* 174 */           agg_isNull14 = false; // resultCode could change nullability.
/* 175 */           agg_value21 = agg_value22 + inputadapter_value1;
/* 176 */
/* 177 */         }
/* 178 */         boolean agg_isNull13 = agg_isNull14;
/* 179 */         double agg_value20 = agg_value21;
/* 180 */         if (agg_isNull13) {
/* 181 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 182 */           double agg_value25 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 183 */           if (!agg_isNull18) {
/* 184 */             agg_isNull13 = false;
/* 185 */             agg_value20 = agg_value25;
/* 186 */           }
/* 187 */         }
/* 188 */         boolean agg_isNull20 = true;
/* 189 */         double agg_value27 = -1.0;
/* 190 */
/* 191 */         boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 192 */         double agg_value29 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 193 */         boolean agg_isNull21 = agg_isNull22;
/* 194 */         double agg_value28 = agg_value29;
/* 195 */         if (agg_isNull21) {
/* 196 */           if (!agg_isNull11) {
/* 197 */             agg_isNull21 = false;
/* 198 */             agg_value28 = agg_value18;
/* 199 */           }
/* 200 */         }
/* 201 */
/* 202 */         if (!inputadapter_isNull2) {
/* 203 */           agg_isNull20 = false; // resultCode could change nullability.
/* 204 */           agg_value27 = agg_value28 + inputadapter_value2;
/* 205 */
/* 206 */         }
/* 207 */         boolean agg_isNull19 = agg_isNull20;
/* 208 */         double agg_value26 = agg_value27;
/* 209 */         if (agg_isNull19) {
/* 210 */           boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 211 */           double agg_value31 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 212 */           if (!agg_isNull24) {
/* 213 */             agg_isNull19 = false;
/* 214 */             agg_value26 = agg_value31;
/* 215 */           }
/* 216 */         }
/* 217 */         boolean agg_isNull26 = true;
/* 218 */         double agg_value33 = -1.0;
/* 219 */
/* 220 */         boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 221 */         double agg_value35 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 222 */         boolean agg_isNull27 = agg_isNull28;
/* 223 */         double agg_value34 = agg_value35;
/* 224 */         if (agg_isNull27) {
/* 225 */           if (!agg_isNull11) {
/* 226 */             agg_isNull27 = false;
/* 227 */             agg_value34 = agg_value18;
/* 228 */           }
/* 229 */         }
/* 230 */
/* 231 */         if (!inputadapter_isNull3) {
/* 232 */           agg_isNull26 = false; // resultCode could change nullability.
/* 233 */           agg_value33 = agg_value34 + inputadapter_value3;
/* 234 */
/* 235 */         }
/* 236 */         boolean agg_isNull25 = agg_isNull26;
/* 237 */         double agg_value32 = agg_value33;
/* 238 */         if (agg_isNull25) {
/* 239 */           boolean agg_isNull30 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 240 */           double agg_value37 = agg_isNull30 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 241 */           if (!agg_isNull30) {
/* 242 */             agg_isNull25 = false;
/* 243 */             agg_value32 = agg_value37;
/* 244 */           }
/* 245 */         }
/* 246 */         boolean agg_isNull32 = true;
/* 247 */         double agg_value39 = -1.0;
/* 248 */
/* 249 */         boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 250 */         double agg_value41 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 251 */         boolean agg_isNull33 = agg_isNull34;
/* 252 */         double agg_value40 = agg_value41;
/* 253 */         if (agg_isNull33) {
/* 254 */           if (!agg_isNull11) {
/* 255 */             agg_isNull33 = false;
/* 256 */             agg_value40 = agg_value18;
/* 257 */           }
/* 258 */         }
/* 259 */
/* 260 */         if (!inputadapter_isNull4) {
/* 261 */           agg_isNull32 = false; // resultCode could change nullability.
/* 262 */           agg_value39 = agg_value40 + inputadapter_value4;
/* 263 */
/* 264 */         }
/* 265 */         boolean agg_isNull31 = agg_isNull32;
/* 266 */         double agg_value38 = agg_value39;
/* 267 */         if (agg_isNull31) {
/* 268 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 269 */           double agg_value43 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 270 */           if (!agg_isNull36) {
/* 271 */             agg_isNull31 = false;
/* 272 */             agg_value38 = agg_value43;
/* 273 */           }
/* 274 */         }
/* 275 */         boolean agg_isNull38 = true;
/* 276 */         double agg_value45 = -1.0;
/* 277 */
/* 278 */         boolean agg_isNull40 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 279 */         double agg_value47 = agg_isNull40 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 280 */         boolean agg_isNull39 = agg_isNull40;
/* 281 */         double agg_value46 = agg_value47;
/* 282 */         if (agg_isNull39) {
/* 283 */           if (!agg_isNull11) {
/* 284 */             agg_isNull39 = false;
/* 285 */             agg_value46 = agg_value18;
/* 286 */           }
/* 287 */         }
/* 288 */
/* 289 */         if (!inputadapter_isNull5) {
/* 290 */           agg_isNull38 = false; // resultCode could change nullability.
/* 291 */           agg_value45 = agg_value46 + inputadapter_value5;
/* 292 */
/* 293 */         }
/* 294 */         boolean agg_isNull37 = agg_isNull38;
/* 295 */         double agg_value44 = agg_value45;
/* 296 */         if (agg_isNull37) {
/* 297 */           boolean agg_isNull42 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 298 */           double agg_value49 = agg_isNull42 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 299 */           if (!agg_isNull42) {
/* 300 */             agg_isNull37 = false;
/* 301 */             agg_value44 = agg_value49;
/* 302 */           }
/* 303 */         }
/* 304 */         boolean agg_isNull44 = true;
/* 305 */         double agg_value51 = -1.0;
/* 306 */
/* 307 */         boolean agg_isNull46 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 308 */         double agg_value53 = agg_isNull46 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 309 */         boolean agg_isNull45 = agg_isNull46;
/* 310 */         double agg_value52 = agg_value53;
/* 311 */         if (agg_isNull45) {
/* 312 */           if (!agg_isNull11) {
/* 313 */             agg_isNull45 = false;
/* 314 */             agg_value52 = agg_value18;
/* 315 */           }
/* 316 */         }
/* 317 */
/* 318 */         if (!inputadapter_isNull6) {
/* 319 */           agg_isNull44 = false; // resultCode could change nullability.
/* 320 */           agg_value51 = agg_value52 + inputadapter_value6;
/* 321 */
/* 322 */         }
/* 323 */         boolean agg_isNull43 = agg_isNull44;
/* 324 */         double agg_value50 = agg_value51;
/* 325 */         if (agg_isNull43) {
/* 326 */           boolean agg_isNull48 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 327 */           double agg_value55 = agg_isNull48 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 328 */           if (!agg_isNull48) {
/* 329 */             agg_isNull43 = false;
/* 330 */             agg_value50 = agg_value55;
/* 331 */           }
/* 332 */         }
/* 333 */         boolean agg_isNull50 = true;
/* 334 */         double agg_value57 = -1.0;
/* 335 */
/* 336 */         boolean agg_isNull52 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 337 */         double agg_value59 = agg_isNull52 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 338 */         boolean agg_isNull51 = agg_isNull52;
/* 339 */         double agg_value58 = agg_value59;
/* 340 */         if (agg_isNull51) {
/* 341 */           if (!agg_isNull11) {
/* 342 */             agg_isNull51 = false;
/* 343 */             agg_value58 = agg_value18;
/* 344 */           }
/* 345 */         }
/* 346 */
/* 347 */         if (!inputadapter_isNull7) {
/* 348 */           agg_isNull50 = false; // resultCode could change nullability.
/* 349 */           agg_value57 = agg_value58 + inputadapter_value7;
/* 350 */
/* 351 */         }
/* 352 */         boolean agg_isNull49 = agg_isNull50;
/* 353 */         double agg_value56 = agg_value57;
/* 354 */         if (agg_isNull49) {
/* 355 */           boolean agg_isNull54 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 356 */           double agg_value61 = agg_isNull54 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 357 */           if (!agg_isNull54) {
/* 358 */             agg_isNull49 = false;
/* 359 */             agg_value56 = agg_value61;
/* 360 */           }
/* 361 */         }
/* 362 */         // update unsafe row buffer
/* 363 */         if (!agg_isNull13) {
/* 364 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value20);
/* 365 */         } else {
/* 366 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 367 */         }
/* 368 */
/* 369 */         if (!agg_isNull19) {
/* 370 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value26);
/* 371 */         } else {
/* 372 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 373 */         }
/* 374 */
/* 375 */         if (!agg_isNull25) {
/* 376 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value32);
/* 377 */         } else {
/* 378 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 379 */         }
/* 380 */
/* 381 */         if (!agg_isNull31) {
/* 382 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value38);
/* 383 */         } else {
/* 384 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 385 */         }
/* 386 */
/* 387 */         if (!agg_isNull37) {
/* 388 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value44);
/* 389 */         } else {
/* 390 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 391 */         }
/* 392 */
/* 393 */         if (!agg_isNull43) {
/* 394 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value50);
/* 395 */         } else {
/* 396 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 397 */         }
/* 398 */
/* 399 */         if (!agg_isNull49) {
/* 400 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value56);
/* 401 */         } else {
/* 402 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 403 */         }
/* 404 */
/* 405 */       }
/* 406 */       if (shouldStop()) return;
/* 407 */     }
/* 408 */
/* 409 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 410 */   }
/* 411 */
/* 412 */   private void wholestagecodegen_init_1() {
/* 413 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 414 */     bhj_result = new UnsafeRow(9);
/* 415 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 416 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 417 */     project_result = new UnsafeRow(8);
/* 418 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 419 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 420 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 421 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 422 */
/* 423 */   }
/* 424 */
/* 425 */   protected void processNext() throws java.io.IOException {
/* 426 */     if (!agg_initAgg) {
/* 427 */       agg_initAgg = true;
/* 428 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 429 */       agg_doAggregateWithKeys();
/* 430 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 431 */     }
/* 432 */
/* 433 */     // output the result
/* 434 */
/* 435 */     while (agg_mapIter.next()) {
/* 436 */       wholestagecodegen_numOutputRows.add(1);
/* 437 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 438 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 439 */
/* 440 */       boolean agg_isNull55 = agg_aggKey.isNullAt(0);
/* 441 */       int agg_value62 = agg_isNull55 ? -1 : (agg_aggKey.getInt(0));
/* 442 */       boolean agg_isNull56 = agg_aggBuffer.isNullAt(0);
/* 443 */       double agg_value63 = agg_isNull56 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 444 */       boolean agg_isNull57 = agg_aggBuffer.isNullAt(1);
/* 445 */       double agg_value64 = agg_isNull57 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 446 */       boolean agg_isNull58 = agg_aggBuffer.isNullAt(2);
/* 447 */       double agg_value65 = agg_isNull58 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 448 */       boolean agg_isNull59 = agg_aggBuffer.isNullAt(3);
/* 449 */       double agg_value66 = agg_isNull59 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 450 */       boolean agg_isNull60 = agg_aggBuffer.isNullAt(4);
/* 451 */       double agg_value67 = agg_isNull60 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 452 */       boolean agg_isNull61 = agg_aggBuffer.isNullAt(5);
/* 453 */       double agg_value68 = agg_isNull61 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 454 */       boolean agg_isNull62 = agg_aggBuffer.isNullAt(6);
/* 455 */       double agg_value69 = agg_isNull62 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 456 */
/* 457 */       // generate join key for stream side
/* 458 */
/* 459 */       boolean bhj_isNull = agg_isNull55;
/* 460 */       long bhj_value = -1L;
/* 461 */       if (!agg_isNull55) {
/* 462 */         bhj_value = (long) agg_value62;
/* 463 */       }
/* 464 */       // find matches from HashRelation
/* 465 */       scala.collection.Iterator bhj_matches = bhj_isNull ? null : (scala.collection.Iterator)bhj_relation.get(bhj_value);
/* 466 */       if (bhj_matches == null) continue;
/* 467 */       while (bhj_matches.hasNext()) {
/* 468 */         UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 469 */
/* 470 */         bhj_numOutputRows.add(1);
/* 471 */
/* 472 */         project_rowWriter.zeroOutNullBytes();
/* 473 */
/* 474 */         if (agg_isNull55) {
/* 475 */           project_rowWriter.setNullAt(0);
/* 476 */         } else {
/* 477 */           project_rowWriter.write(0, agg_value62);
/* 478 */         }
/* 479 */
/* 480 */         if (agg_isNull56) {
/* 481 */           project_rowWriter.setNullAt(1);
/* 482 */         } else {
/* 483 */           project_rowWriter.write(1, agg_value63);
/* 484 */         }
/* 485 */
/* 486 */         if (agg_isNull57) {
/* 487 */           project_rowWriter.setNullAt(2);
/* 488 */         } else {
/* 489 */           project_rowWriter.write(2, agg_value64);
/* 490 */         }
/* 491 */
/* 492 */         if (agg_isNull58) {
/* 493 */           project_rowWriter.setNullAt(3);
/* 494 */         } else {
/* 495 */           project_rowWriter.write(3, agg_value65);
/* 496 */         }
/* 497 */
/* 498 */         if (agg_isNull59) {
/* 499 */           project_rowWriter.setNullAt(4);
/* 500 */         } else {
/* 501 */           project_rowWriter.write(4, agg_value66);
/* 502 */         }
/* 503 */
/* 504 */         if (agg_isNull60) {
/* 505 */           project_rowWriter.setNullAt(5);
/* 506 */         } else {
/* 507 */           project_rowWriter.write(5, agg_value67);
/* 508 */         }
/* 509 */
/* 510 */         if (agg_isNull61) {
/* 511 */           project_rowWriter.setNullAt(6);
/* 512 */         } else {
/* 513 */           project_rowWriter.write(6, agg_value68);
/* 514 */         }
/* 515 */
/* 516 */         if (agg_isNull62) {
/* 517 */           project_rowWriter.setNullAt(7);
/* 518 */         } else {
/* 519 */           project_rowWriter.write(7, agg_value69);
/* 520 */         }
/* 521 */         append(project_result.copy());
/* 522 */
/* 523 */       }
/* 524 */
/* 525 */       if (shouldStop()) return;
/* 526 */     }
/* 527 */
/* 528 */     agg_mapIter.close();
/* 529 */     if (agg_sorter == null) {
/* 530 */       agg_hashMap.free();
/* 531 */     }
/* 532 */   }
/* 533 */ }
