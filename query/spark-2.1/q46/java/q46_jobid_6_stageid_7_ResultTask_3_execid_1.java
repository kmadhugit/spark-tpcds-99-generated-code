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
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value12;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 028 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 030 */   private UnsafeRow bhj_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 033 */   private UnsafeRow project_result;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 035 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 036 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 037 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 038 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 039 */   private UnsafeRow bhj_result1;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 042 */   private UnsafeRow project_result1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 046 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 047 */
/* 048 */   public GeneratedIterator(Object[] references) {
/* 049 */     this.references = references;
/* 050 */   }
/* 051 */
/* 052 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 053 */     partitionIndex = index;
/* 054 */     this.inputs = inputs;
/* 055 */     wholestagecodegen_init_0();
/* 056 */     wholestagecodegen_init_1();
/* 057 */     wholestagecodegen_init_2();
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
/* 069 */     agg_result = new UnsafeRow(4);
/* 070 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 071 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 072 */
/* 073 */     agg_result1 = new UnsafeRow(5);
/* 074 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 075 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
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
/* 091 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 092 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 093 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 094 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 095 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 096 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 097 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 098 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 099 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 100 */
/* 101 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 102 */
/* 103 */       UnsafeRow agg_fastAggBuffer = null;
/* 104 */
/* 105 */       if (agg_fastAggBuffer == null) {
/* 106 */         // generate grouping key
/* 107 */         agg_holder.reset();
/* 108 */
/* 109 */         agg_rowWriter.zeroOutNullBytes();
/* 110 */
/* 111 */         if (inputadapter_isNull) {
/* 112 */           agg_rowWriter.setNullAt(0);
/* 113 */         } else {
/* 114 */           agg_rowWriter.write(0, inputadapter_value);
/* 115 */         }
/* 116 */
/* 117 */         if (inputadapter_isNull1) {
/* 118 */           agg_rowWriter.setNullAt(1);
/* 119 */         } else {
/* 120 */           agg_rowWriter.write(1, inputadapter_value1);
/* 121 */         }
/* 122 */
/* 123 */         if (inputadapter_isNull2) {
/* 124 */           agg_rowWriter.setNullAt(2);
/* 125 */         } else {
/* 126 */           agg_rowWriter.write(2, inputadapter_value2);
/* 127 */         }
/* 128 */
/* 129 */         if (inputadapter_isNull3) {
/* 130 */           agg_rowWriter.setNullAt(3);
/* 131 */         } else {
/* 132 */           agg_rowWriter.write(3, inputadapter_value3);
/* 133 */         }
/* 134 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 135 */         agg_value12 = 42;
/* 136 */
/* 137 */         if (!inputadapter_isNull) {
/* 138 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 139 */         }
/* 140 */
/* 141 */         if (!inputadapter_isNull1) {
/* 142 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 143 */         }
/* 144 */
/* 145 */         if (!inputadapter_isNull2) {
/* 146 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 147 */         }
/* 148 */
/* 149 */         if (!inputadapter_isNull3) {
/* 150 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value12);
/* 151 */         }
/* 152 */         if (true) {
/* 153 */           // try to get the buffer from hash map
/* 154 */           agg_unsafeRowAggBuffer =
/* 155 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 156 */         }
/* 157 */         if (agg_unsafeRowAggBuffer == null) {
/* 158 */           if (agg_sorter == null) {
/* 159 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 160 */           } else {
/* 161 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 162 */           }
/* 163 */
/* 164 */           // the hash map had be spilled, it should have enough memory now,
/* 165 */           // try  to allocate buffer again.
/* 166 */           agg_unsafeRowAggBuffer =
/* 167 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 168 */           if (agg_unsafeRowAggBuffer == null) {
/* 169 */             // failed to allocate the first page
/* 170 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 171 */           }
/* 172 */         }
/* 173 */       }
/* 174 */
/* 175 */       if (agg_fastAggBuffer != null) {
/* 176 */         // update fast row
/* 177 */
/* 178 */       } else {
/* 179 */         // update unsafe row
/* 180 */
/* 181 */         // common sub-expressions
/* 182 */         boolean agg_isNull15 = false;
/* 183 */         double agg_value17 = -1.0;
/* 184 */         if (!false) {
/* 185 */           agg_value17 = (double) 0;
/* 186 */         }
/* 187 */         // evaluate aggregate function
/* 188 */         boolean agg_isNull18 = true;
/* 189 */         double agg_value20 = -1.0;
/* 190 */
/* 191 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 192 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 193 */         boolean agg_isNull19 = agg_isNull20;
/* 194 */         double agg_value21 = agg_value22;
/* 195 */         if (agg_isNull19) {
/* 196 */           if (!agg_isNull15) {
/* 197 */             agg_isNull19 = false;
/* 198 */             agg_value21 = agg_value17;
/* 199 */           }
/* 200 */         }
/* 201 */
/* 202 */         if (!inputadapter_isNull4) {
/* 203 */           agg_isNull18 = false; // resultCode could change nullability.
/* 204 */           agg_value20 = agg_value21 + inputadapter_value4;
/* 205 */
/* 206 */         }
/* 207 */         boolean agg_isNull17 = agg_isNull18;
/* 208 */         double agg_value19 = agg_value20;
/* 209 */         if (agg_isNull17) {
/* 210 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 211 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 212 */           if (!agg_isNull22) {
/* 213 */             agg_isNull17 = false;
/* 214 */             agg_value19 = agg_value24;
/* 215 */           }
/* 216 */         }
/* 217 */         boolean agg_isNull24 = true;
/* 218 */         double agg_value26 = -1.0;
/* 219 */
/* 220 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 221 */         double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 222 */         boolean agg_isNull25 = agg_isNull26;
/* 223 */         double agg_value27 = agg_value28;
/* 224 */         if (agg_isNull25) {
/* 225 */           if (!agg_isNull15) {
/* 226 */             agg_isNull25 = false;
/* 227 */             agg_value27 = agg_value17;
/* 228 */           }
/* 229 */         }
/* 230 */
/* 231 */         if (!inputadapter_isNull5) {
/* 232 */           agg_isNull24 = false; // resultCode could change nullability.
/* 233 */           agg_value26 = agg_value27 + inputadapter_value5;
/* 234 */
/* 235 */         }
/* 236 */         boolean agg_isNull23 = agg_isNull24;
/* 237 */         double agg_value25 = agg_value26;
/* 238 */         if (agg_isNull23) {
/* 239 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 240 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 241 */           if (!agg_isNull28) {
/* 242 */             agg_isNull23 = false;
/* 243 */             agg_value25 = agg_value30;
/* 244 */           }
/* 245 */         }
/* 246 */         // update unsafe row buffer
/* 247 */         if (!agg_isNull17) {
/* 248 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value19);
/* 249 */         } else {
/* 250 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 251 */         }
/* 252 */
/* 253 */         if (!agg_isNull23) {
/* 254 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value25);
/* 255 */         } else {
/* 256 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 257 */         }
/* 258 */
/* 259 */       }
/* 260 */       if (shouldStop()) return;
/* 261 */     }
/* 262 */
/* 263 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 264 */   }
/* 265 */
/* 266 */   private void wholestagecodegen_init_2() {
/* 267 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 9);
/* 268 */     project_result1 = new UnsafeRow(7);
/* 269 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 128);
/* 270 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 7);
/* 271 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 272 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 273 */
/* 274 */   }
/* 275 */
/* 276 */   private void wholestagecodegen_init_1() {
/* 277 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 278 */     bhj_result = new UnsafeRow(9);
/* 279 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 280 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 9);
/* 281 */     project_result = new UnsafeRow(7);
/* 282 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 283 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 284 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 285 */
/* 286 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 287 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 288 */
/* 289 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 290 */     bhj_result1 = new UnsafeRow(9);
/* 291 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 128);
/* 292 */
/* 293 */   }
/* 294 */
/* 295 */   protected void processNext() throws java.io.IOException {
/* 296 */     if (!agg_initAgg) {
/* 297 */       agg_initAgg = true;
/* 298 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 299 */       agg_doAggregateWithKeys();
/* 300 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 301 */     }
/* 302 */
/* 303 */     // output the result
/* 304 */
/* 305 */     while (agg_mapIter.next()) {
/* 306 */       wholestagecodegen_numOutputRows.add(1);
/* 307 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 308 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 309 */
/* 310 */       boolean agg_isNull29 = agg_aggKey.isNullAt(0);
/* 311 */       int agg_value31 = agg_isNull29 ? -1 : (agg_aggKey.getInt(0));
/* 312 */       boolean agg_isNull30 = agg_aggKey.isNullAt(1);
/* 313 */       int agg_value32 = agg_isNull30 ? -1 : (agg_aggKey.getInt(1));
/* 314 */       boolean agg_isNull31 = agg_aggKey.isNullAt(2);
/* 315 */       int agg_value33 = agg_isNull31 ? -1 : (agg_aggKey.getInt(2));
/* 316 */       boolean agg_isNull32 = agg_aggKey.isNullAt(3);
/* 317 */       UTF8String agg_value34 = agg_isNull32 ? null : (agg_aggKey.getUTF8String(3));
/* 318 */       boolean agg_isNull33 = agg_aggBuffer.isNullAt(0);
/* 319 */       double agg_value35 = agg_isNull33 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 320 */       boolean agg_isNull34 = agg_aggBuffer.isNullAt(1);
/* 321 */       double agg_value36 = agg_isNull34 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 322 */
/* 323 */       // generate join key for stream side
/* 324 */
/* 325 */       boolean bhj_isNull = agg_isNull30;
/* 326 */       long bhj_value = -1L;
/* 327 */       if (!agg_isNull30) {
/* 328 */         bhj_value = (long) agg_value32;
/* 329 */       }
/* 330 */       // find matches from HashedRelation
/* 331 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 332 */       if (bhj_matched == null) continue;
/* 333 */
/* 334 */       bhj_numOutputRows.add(1);
/* 335 */
/* 336 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 337 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 338 */
/* 339 */       // generate join key for stream side
/* 340 */
/* 341 */       boolean bhj_isNull15 = bhj_isNull3;
/* 342 */       long bhj_value15 = -1L;
/* 343 */       if (!bhj_isNull3) {
/* 344 */         bhj_value15 = (long) bhj_value3;
/* 345 */       }
/* 346 */       // find matches from HashedRelation
/* 347 */       UnsafeRow bhj_matched1 = bhj_isNull15 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value15);
/* 348 */       if (bhj_matched1 == null) continue;
/* 349 */
/* 350 */       boolean bhj_isNull18 = bhj_matched1.isNullAt(1);
/* 351 */       UTF8String bhj_value18 = bhj_isNull18 ? null : (bhj_matched1.getUTF8String(1));
/* 352 */
/* 353 */       boolean bhj_isNull20 = true;
/* 354 */       boolean bhj_value20 = false;
/* 355 */
/* 356 */       if (!bhj_isNull18) {
/* 357 */         if (!agg_isNull32) {
/* 358 */           bhj_isNull20 = false; // resultCode could change nullability.
/* 359 */           bhj_value20 = bhj_value18.equals(agg_value34);
/* 360 */
/* 361 */         }
/* 362 */
/* 363 */       }
/* 364 */       boolean bhj_isNull19 = bhj_isNull20;
/* 365 */       boolean bhj_value19 = false;
/* 366 */
/* 367 */       if (!bhj_isNull20) {
/* 368 */         bhj_value19 = !(bhj_value20);
/* 369 */       }
/* 370 */       if (bhj_isNull19 || !bhj_value19) continue;
/* 371 */
/* 372 */       bhj_numOutputRows1.add(1);
/* 373 */
/* 374 */       boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 375 */       UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 376 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 377 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 378 */       project_holder1.reset();
/* 379 */
/* 380 */       project_rowWriter1.zeroOutNullBytes();
/* 381 */
/* 382 */       if (bhj_isNull5) {
/* 383 */         project_rowWriter1.setNullAt(0);
/* 384 */       } else {
/* 385 */         project_rowWriter1.write(0, bhj_value5);
/* 386 */       }
/* 387 */
/* 388 */       if (bhj_isNull4) {
/* 389 */         project_rowWriter1.setNullAt(1);
/* 390 */       } else {
/* 391 */         project_rowWriter1.write(1, bhj_value4);
/* 392 */       }
/* 393 */
/* 394 */       if (bhj_isNull18) {
/* 395 */         project_rowWriter1.setNullAt(2);
/* 396 */       } else {
/* 397 */         project_rowWriter1.write(2, bhj_value18);
/* 398 */       }
/* 399 */
/* 400 */       if (agg_isNull32) {
/* 401 */         project_rowWriter1.setNullAt(3);
/* 402 */       } else {
/* 403 */         project_rowWriter1.write(3, agg_value34);
/* 404 */       }
/* 405 */
/* 406 */       if (agg_isNull29) {
/* 407 */         project_rowWriter1.setNullAt(4);
/* 408 */       } else {
/* 409 */         project_rowWriter1.write(4, agg_value31);
/* 410 */       }
/* 411 */
/* 412 */       if (agg_isNull33) {
/* 413 */         project_rowWriter1.setNullAt(5);
/* 414 */       } else {
/* 415 */         project_rowWriter1.write(5, agg_value35);
/* 416 */       }
/* 417 */
/* 418 */       if (agg_isNull34) {
/* 419 */         project_rowWriter1.setNullAt(6);
/* 420 */       } else {
/* 421 */         project_rowWriter1.write(6, agg_value36);
/* 422 */       }
/* 423 */       project_result1.setTotalSize(project_holder1.totalSize());
/* 424 */       append(project_result1);
/* 425 */
/* 426 */       if (shouldStop()) return;
/* 427 */     }
/* 428 */
/* 429 */     agg_mapIter.close();
/* 430 */     if (agg_sorter == null) {
/* 431 */       agg_hashMap.free();
/* 432 */     }
/* 433 */   }
/* 434 */ }
