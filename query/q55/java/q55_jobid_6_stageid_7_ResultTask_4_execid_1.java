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
/* 015 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 016 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 017 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 018 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 019 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 020 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 021 */   private scala.collection.Iterator inputadapter_input;
/* 022 */   private UnsafeRow agg_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 025 */   private int agg_value14;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 030 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 032 */   private UnsafeRow bhj_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 035 */   private UnsafeRow project_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 038 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 039 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 041 */   private UnsafeRow bhj_result1;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 044 */   private UnsafeRow project_result1;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 048 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 049 */
/* 050 */   public GeneratedIterator(Object[] references) {
/* 051 */     this.references = references;
/* 052 */   }
/* 053 */
/* 054 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 055 */     partitionIndex = index;
/* 056 */     this.inputs = inputs;
/* 057 */     wholestagecodegen_init_0();
/* 058 */     wholestagecodegen_init_1();
/* 059 */     wholestagecodegen_init_2();
/* 060 */
/* 061 */   }
/* 062 */
/* 063 */   private void wholestagecodegen_init_0() {
/* 064 */     agg_initAgg = false;
/* 065 */
/* 066 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 067 */
/* 068 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 069 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 070 */     inputadapter_input = inputs[0];
/* 071 */     agg_result = new UnsafeRow(4);
/* 072 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 073 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 074 */
/* 075 */     agg_result1 = new UnsafeRow(6);
/* 076 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 077 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
/* 078 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 079 */
/* 080 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 081 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 082 */
/* 083 */   }
/* 084 */
/* 085 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 086 */     agg_hashMap = agg_plan.createHashMap();
/* 087 */
/* 088 */     while (inputadapter_input.hasNext()) {
/* 089 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 090 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 091 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 092 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 093 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 094 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 095 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 096 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 097 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 098 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 099 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 100 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 101 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 102 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 103 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 104 */
/* 105 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 106 */
/* 107 */       UnsafeRow agg_fastAggBuffer = null;
/* 108 */
/* 109 */       if (agg_fastAggBuffer == null) {
/* 110 */         // generate grouping key
/* 111 */         agg_holder.reset();
/* 112 */
/* 113 */         agg_rowWriter.zeroOutNullBytes();
/* 114 */
/* 115 */         if (inputadapter_isNull) {
/* 116 */           agg_rowWriter.setNullAt(0);
/* 117 */         } else {
/* 118 */           agg_rowWriter.write(0, inputadapter_value);
/* 119 */         }
/* 120 */
/* 121 */         if (inputadapter_isNull1) {
/* 122 */           agg_rowWriter.setNullAt(1);
/* 123 */         } else {
/* 124 */           agg_rowWriter.write(1, inputadapter_value1);
/* 125 */         }
/* 126 */
/* 127 */         if (inputadapter_isNull2) {
/* 128 */           agg_rowWriter.setNullAt(2);
/* 129 */         } else {
/* 130 */           agg_rowWriter.write(2, inputadapter_value2);
/* 131 */         }
/* 132 */
/* 133 */         if (inputadapter_isNull3) {
/* 134 */           agg_rowWriter.setNullAt(3);
/* 135 */         } else {
/* 136 */           agg_rowWriter.write(3, inputadapter_value3);
/* 137 */         }
/* 138 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 139 */         agg_value14 = 42;
/* 140 */
/* 141 */         if (!inputadapter_isNull) {
/* 142 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value14);
/* 143 */         }
/* 144 */
/* 145 */         if (!inputadapter_isNull1) {
/* 146 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value14);
/* 147 */         }
/* 148 */
/* 149 */         if (!inputadapter_isNull2) {
/* 150 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value14);
/* 151 */         }
/* 152 */
/* 153 */         if (!inputadapter_isNull3) {
/* 154 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value14);
/* 155 */         }
/* 156 */         if (true) {
/* 157 */           // try to get the buffer from hash map
/* 158 */           agg_unsafeRowAggBuffer =
/* 159 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 160 */         }
/* 161 */         if (agg_unsafeRowAggBuffer == null) {
/* 162 */           if (agg_sorter == null) {
/* 163 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 164 */           } else {
/* 165 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 166 */           }
/* 167 */
/* 168 */           // the hash map had be spilled, it should have enough memory now,
/* 169 */           // try  to allocate buffer again.
/* 170 */           agg_unsafeRowAggBuffer =
/* 171 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 172 */           if (agg_unsafeRowAggBuffer == null) {
/* 173 */             // failed to allocate the first page
/* 174 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 175 */           }
/* 176 */         }
/* 177 */       }
/* 178 */
/* 179 */       if (agg_fastAggBuffer != null) {
/* 180 */         // update fast row
/* 181 */
/* 182 */       } else {
/* 183 */         // update unsafe row
/* 184 */
/* 185 */         // common sub-expressions
/* 186 */         boolean agg_isNull16 = false;
/* 187 */         double agg_value19 = -1.0;
/* 188 */         if (!false) {
/* 189 */           agg_value19 = (double) 0;
/* 190 */         }
/* 191 */         // evaluate aggregate function
/* 192 */         boolean agg_isNull19 = true;
/* 193 */         double agg_value22 = -1.0;
/* 194 */
/* 195 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 196 */         double agg_value24 = agg_isNull21 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 197 */         boolean agg_isNull20 = agg_isNull21;
/* 198 */         double agg_value23 = agg_value24;
/* 199 */         if (agg_isNull20) {
/* 200 */           if (!agg_isNull16) {
/* 201 */             agg_isNull20 = false;
/* 202 */             agg_value23 = agg_value19;
/* 203 */           }
/* 204 */         }
/* 205 */
/* 206 */         if (!inputadapter_isNull4) {
/* 207 */           agg_isNull19 = false; // resultCode could change nullability.
/* 208 */           agg_value22 = agg_value23 + inputadapter_value4;
/* 209 */
/* 210 */         }
/* 211 */         boolean agg_isNull18 = agg_isNull19;
/* 212 */         double agg_value21 = agg_value22;
/* 213 */         if (agg_isNull18) {
/* 214 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 215 */           double agg_value26 = agg_isNull23 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 216 */           if (!agg_isNull23) {
/* 217 */             agg_isNull18 = false;
/* 218 */             agg_value21 = agg_value26;
/* 219 */           }
/* 220 */         }
/* 221 */         boolean agg_isNull25 = true;
/* 222 */         double agg_value28 = -1.0;
/* 223 */
/* 224 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 225 */         double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 226 */         boolean agg_isNull26 = agg_isNull27;
/* 227 */         double agg_value29 = agg_value30;
/* 228 */         if (agg_isNull26) {
/* 229 */           if (!agg_isNull16) {
/* 230 */             agg_isNull26 = false;
/* 231 */             agg_value29 = agg_value19;
/* 232 */           }
/* 233 */         }
/* 234 */
/* 235 */         if (!inputadapter_isNull5) {
/* 236 */           agg_isNull25 = false; // resultCode could change nullability.
/* 237 */           agg_value28 = agg_value29 + inputadapter_value5;
/* 238 */
/* 239 */         }
/* 240 */         boolean agg_isNull24 = agg_isNull25;
/* 241 */         double agg_value27 = agg_value28;
/* 242 */         if (agg_isNull24) {
/* 243 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 244 */           double agg_value32 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 245 */           if (!agg_isNull29) {
/* 246 */             agg_isNull24 = false;
/* 247 */             agg_value27 = agg_value32;
/* 248 */           }
/* 249 */         }
/* 250 */         boolean agg_isNull31 = true;
/* 251 */         double agg_value34 = -1.0;
/* 252 */
/* 253 */         boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 254 */         double agg_value36 = agg_isNull33 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 255 */         boolean agg_isNull32 = agg_isNull33;
/* 256 */         double agg_value35 = agg_value36;
/* 257 */         if (agg_isNull32) {
/* 258 */           if (!agg_isNull16) {
/* 259 */             agg_isNull32 = false;
/* 260 */             agg_value35 = agg_value19;
/* 261 */           }
/* 262 */         }
/* 263 */
/* 264 */         if (!inputadapter_isNull6) {
/* 265 */           agg_isNull31 = false; // resultCode could change nullability.
/* 266 */           agg_value34 = agg_value35 + inputadapter_value6;
/* 267 */
/* 268 */         }
/* 269 */         boolean agg_isNull30 = agg_isNull31;
/* 270 */         double agg_value33 = agg_value34;
/* 271 */         if (agg_isNull30) {
/* 272 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 273 */           double agg_value38 = agg_isNull35 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 274 */           if (!agg_isNull35) {
/* 275 */             agg_isNull30 = false;
/* 276 */             agg_value33 = agg_value38;
/* 277 */           }
/* 278 */         }
/* 279 */         // update unsafe row buffer
/* 280 */         if (!agg_isNull18) {
/* 281 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value21);
/* 282 */         } else {
/* 283 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 284 */         }
/* 285 */
/* 286 */         if (!agg_isNull24) {
/* 287 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value27);
/* 288 */         } else {
/* 289 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 290 */         }
/* 291 */
/* 292 */         if (!agg_isNull30) {
/* 293 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value33);
/* 294 */         } else {
/* 295 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 296 */         }
/* 297 */
/* 298 */       }
/* 299 */       if (shouldStop()) return;
/* 300 */     }
/* 301 */
/* 302 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 303 */   }
/* 304 */
/* 305 */   private void wholestagecodegen_init_2() {
/* 306 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 10);
/* 307 */     project_result1 = new UnsafeRow(8);
/* 308 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 128);
/* 309 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 8);
/* 310 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 311 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 312 */
/* 313 */   }
/* 314 */
/* 315 */   private void wholestagecodegen_init_1() {
/* 316 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 317 */     bhj_result = new UnsafeRow(10);
/* 318 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 319 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 10);
/* 320 */     project_result = new UnsafeRow(8);
/* 321 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 96);
/* 322 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 8);
/* 323 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 324 */
/* 325 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 326 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 327 */
/* 328 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 329 */     bhj_result1 = new UnsafeRow(10);
/* 330 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 128);
/* 331 */
/* 332 */   }
/* 333 */
/* 334 */   protected void processNext() throws java.io.IOException {
/* 335 */     if (!agg_initAgg) {
/* 336 */       agg_initAgg = true;
/* 337 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 338 */       agg_doAggregateWithKeys();
/* 339 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 340 */     }
/* 341 */
/* 342 */     // output the result
/* 343 */
/* 344 */     while (agg_mapIter.next()) {
/* 345 */       wholestagecodegen_numOutputRows.add(1);
/* 346 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 347 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 348 */
/* 349 */       boolean agg_isNull36 = agg_aggKey.isNullAt(0);
/* 350 */       int agg_value39 = agg_isNull36 ? -1 : (agg_aggKey.getInt(0));
/* 351 */       boolean agg_isNull37 = agg_aggKey.isNullAt(1);
/* 352 */       int agg_value40 = agg_isNull37 ? -1 : (agg_aggKey.getInt(1));
/* 353 */       boolean agg_isNull38 = agg_aggKey.isNullAt(2);
/* 354 */       int agg_value41 = agg_isNull38 ? -1 : (agg_aggKey.getInt(2));
/* 355 */       boolean agg_isNull39 = agg_aggKey.isNullAt(3);
/* 356 */       UTF8String agg_value42 = agg_isNull39 ? null : (agg_aggKey.getUTF8String(3));
/* 357 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(0);
/* 358 */       double agg_value43 = agg_isNull40 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 359 */       boolean agg_isNull41 = agg_aggBuffer.isNullAt(1);
/* 360 */       double agg_value44 = agg_isNull41 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 361 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(2);
/* 362 */       double agg_value45 = agg_isNull42 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 363 */
/* 364 */       // generate join key for stream side
/* 365 */
/* 366 */       boolean bhj_isNull = agg_isNull37;
/* 367 */       long bhj_value = -1L;
/* 368 */       if (!agg_isNull37) {
/* 369 */         bhj_value = (long) agg_value40;
/* 370 */       }
/* 371 */       // find matches from HashedRelation
/* 372 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 373 */       if (bhj_matched == null) continue;
/* 374 */
/* 375 */       bhj_numOutputRows.add(1);
/* 376 */
/* 377 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 378 */       int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(1));
/* 379 */
/* 380 */       // generate join key for stream side
/* 381 */
/* 382 */       boolean bhj_isNull16 = bhj_isNull3;
/* 383 */       long bhj_value16 = -1L;
/* 384 */       if (!bhj_isNull3) {
/* 385 */         bhj_value16 = (long) bhj_value3;
/* 386 */       }
/* 387 */       // find matches from HashedRelation
/* 388 */       UnsafeRow bhj_matched1 = bhj_isNull16 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value16);
/* 389 */       if (bhj_matched1 == null) continue;
/* 390 */
/* 391 */       boolean bhj_isNull19 = bhj_matched1.isNullAt(1);
/* 392 */       UTF8String bhj_value19 = bhj_isNull19 ? null : (bhj_matched1.getUTF8String(1));
/* 393 */
/* 394 */       boolean bhj_isNull21 = true;
/* 395 */       boolean bhj_value21 = false;
/* 396 */
/* 397 */       if (!bhj_isNull19) {
/* 398 */         if (!agg_isNull39) {
/* 399 */           bhj_isNull21 = false; // resultCode could change nullability.
/* 400 */           bhj_value21 = bhj_value19.equals(agg_value42);
/* 401 */
/* 402 */         }
/* 403 */
/* 404 */       }
/* 405 */       boolean bhj_isNull20 = bhj_isNull21;
/* 406 */       boolean bhj_value20 = false;
/* 407 */
/* 408 */       if (!bhj_isNull21) {
/* 409 */         bhj_value20 = !(bhj_value21);
/* 410 */       }
/* 411 */       if (bhj_isNull20 || !bhj_value20) continue;
/* 412 */
/* 413 */       bhj_numOutputRows1.add(1);
/* 414 */
/* 415 */       boolean bhj_isNull5 = bhj_matched.isNullAt(3);
/* 416 */       UTF8String bhj_value5 = bhj_isNull5 ? null : (bhj_matched.getUTF8String(3));
/* 417 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 418 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 419 */       project_holder1.reset();
/* 420 */
/* 421 */       project_rowWriter1.zeroOutNullBytes();
/* 422 */
/* 423 */       if (bhj_isNull5) {
/* 424 */         project_rowWriter1.setNullAt(0);
/* 425 */       } else {
/* 426 */         project_rowWriter1.write(0, bhj_value5);
/* 427 */       }
/* 428 */
/* 429 */       if (bhj_isNull4) {
/* 430 */         project_rowWriter1.setNullAt(1);
/* 431 */       } else {
/* 432 */         project_rowWriter1.write(1, bhj_value4);
/* 433 */       }
/* 434 */
/* 435 */       if (bhj_isNull19) {
/* 436 */         project_rowWriter1.setNullAt(2);
/* 437 */       } else {
/* 438 */         project_rowWriter1.write(2, bhj_value19);
/* 439 */       }
/* 440 */
/* 441 */       if (agg_isNull39) {
/* 442 */         project_rowWriter1.setNullAt(3);
/* 443 */       } else {
/* 444 */         project_rowWriter1.write(3, agg_value42);
/* 445 */       }
/* 446 */
/* 447 */       if (agg_isNull36) {
/* 448 */         project_rowWriter1.setNullAt(4);
/* 449 */       } else {
/* 450 */         project_rowWriter1.write(4, agg_value39);
/* 451 */       }
/* 452 */
/* 453 */       if (agg_isNull40) {
/* 454 */         project_rowWriter1.setNullAt(5);
/* 455 */       } else {
/* 456 */         project_rowWriter1.write(5, agg_value43);
/* 457 */       }
/* 458 */
/* 459 */       if (agg_isNull42) {
/* 460 */         project_rowWriter1.setNullAt(6);
/* 461 */       } else {
/* 462 */         project_rowWriter1.write(6, agg_value45);
/* 463 */       }
/* 464 */
/* 465 */       if (agg_isNull41) {
/* 466 */         project_rowWriter1.setNullAt(7);
/* 467 */       } else {
/* 468 */         project_rowWriter1.write(7, agg_value44);
/* 469 */       }
/* 470 */       project_result1.setTotalSize(project_holder1.totalSize());
/* 471 */       append(project_result1);
/* 472 */
/* 473 */       if (shouldStop()) return;
/* 474 */     }
/* 475 */
/* 476 */     agg_mapIter.close();
/* 477 */     if (agg_sorter == null) {
/* 478 */       agg_hashMap.free();
/* 479 */     }
/* 480 */   }
/* 481 */ }
