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
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 037 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 038 */
/* 039 */   public GeneratedIterator(Object[] references) {
/* 040 */     this.references = references;
/* 041 */   }
/* 042 */
/* 043 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 044 */     partitionIndex = index;
/* 045 */     this.inputs = inputs;
/* 046 */     wholestagecodegen_init_0();
/* 047 */     wholestagecodegen_init_1();
/* 048 */
/* 049 */   }
/* 050 */
/* 051 */   private void wholestagecodegen_init_0() {
/* 052 */     agg_initAgg = false;
/* 053 */
/* 054 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 055 */
/* 056 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 057 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 058 */     inputadapter_input = inputs[0];
/* 059 */     agg_result = new UnsafeRow(4);
/* 060 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 061 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 062 */
/* 063 */     agg_result1 = new UnsafeRow(5);
/* 064 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 065 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 066 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 067 */
/* 068 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 069 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 070 */
/* 071 */   }
/* 072 */
/* 073 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 074 */     agg_hashMap = agg_plan.createHashMap();
/* 075 */
/* 076 */     while (inputadapter_input.hasNext()) {
/* 077 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 078 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 079 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 080 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 081 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 082 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 083 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 084 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 085 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 086 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 087 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 088 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 089 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 090 */
/* 091 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 092 */
/* 093 */       UnsafeRow agg_fastAggBuffer = null;
/* 094 */
/* 095 */       if (agg_fastAggBuffer == null) {
/* 096 */         // generate grouping key
/* 097 */         agg_holder.reset();
/* 098 */
/* 099 */         agg_rowWriter.zeroOutNullBytes();
/* 100 */
/* 101 */         if (inputadapter_isNull) {
/* 102 */           agg_rowWriter.setNullAt(0);
/* 103 */         } else {
/* 104 */           agg_rowWriter.write(0, inputadapter_value);
/* 105 */         }
/* 106 */
/* 107 */         if (inputadapter_isNull1) {
/* 108 */           agg_rowWriter.setNullAt(1);
/* 109 */         } else {
/* 110 */           agg_rowWriter.write(1, inputadapter_value1);
/* 111 */         }
/* 112 */
/* 113 */         if (inputadapter_isNull2) {
/* 114 */           agg_rowWriter.setNullAt(2);
/* 115 */         } else {
/* 116 */           agg_rowWriter.write(2, inputadapter_value2);
/* 117 */         }
/* 118 */
/* 119 */         if (inputadapter_isNull3) {
/* 120 */           agg_rowWriter.setNullAt(3);
/* 121 */         } else {
/* 122 */           agg_rowWriter.write(3, inputadapter_value3);
/* 123 */         }
/* 124 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 125 */         agg_value12 = 42;
/* 126 */
/* 127 */         if (!inputadapter_isNull) {
/* 128 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 129 */         }
/* 130 */
/* 131 */         if (!inputadapter_isNull1) {
/* 132 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 133 */         }
/* 134 */
/* 135 */         if (!inputadapter_isNull2) {
/* 136 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 137 */         }
/* 138 */
/* 139 */         if (!inputadapter_isNull3) {
/* 140 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value12);
/* 141 */         }
/* 142 */         if (true) {
/* 143 */           // try to get the buffer from hash map
/* 144 */           agg_unsafeRowAggBuffer =
/* 145 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 146 */         }
/* 147 */         if (agg_unsafeRowAggBuffer == null) {
/* 148 */           if (agg_sorter == null) {
/* 149 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 150 */           } else {
/* 151 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 152 */           }
/* 153 */
/* 154 */           // the hash map had be spilled, it should have enough memory now,
/* 155 */           // try  to allocate buffer again.
/* 156 */           agg_unsafeRowAggBuffer =
/* 157 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 158 */           if (agg_unsafeRowAggBuffer == null) {
/* 159 */             // failed to allocate the first page
/* 160 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 161 */           }
/* 162 */         }
/* 163 */       }
/* 164 */
/* 165 */       if (agg_fastAggBuffer != null) {
/* 166 */         // update fast row
/* 167 */
/* 168 */       } else {
/* 169 */         // update unsafe row
/* 170 */
/* 171 */         // common sub-expressions
/* 172 */         boolean agg_isNull15 = false;
/* 173 */         double agg_value17 = -1.0;
/* 174 */         if (!false) {
/* 175 */           agg_value17 = (double) 0;
/* 176 */         }
/* 177 */         // evaluate aggregate function
/* 178 */         boolean agg_isNull18 = true;
/* 179 */         double agg_value20 = -1.0;
/* 180 */
/* 181 */         boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 182 */         double agg_value22 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 183 */         boolean agg_isNull19 = agg_isNull20;
/* 184 */         double agg_value21 = agg_value22;
/* 185 */         if (agg_isNull19) {
/* 186 */           if (!agg_isNull15) {
/* 187 */             agg_isNull19 = false;
/* 188 */             agg_value21 = agg_value17;
/* 189 */           }
/* 190 */         }
/* 191 */
/* 192 */         if (!inputadapter_isNull4) {
/* 193 */           agg_isNull18 = false; // resultCode could change nullability.
/* 194 */           agg_value20 = agg_value21 + inputadapter_value4;
/* 195 */
/* 196 */         }
/* 197 */         boolean agg_isNull17 = agg_isNull18;
/* 198 */         double agg_value19 = agg_value20;
/* 199 */         if (agg_isNull17) {
/* 200 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 201 */           double agg_value24 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 202 */           if (!agg_isNull22) {
/* 203 */             agg_isNull17 = false;
/* 204 */             agg_value19 = agg_value24;
/* 205 */           }
/* 206 */         }
/* 207 */         boolean agg_isNull24 = true;
/* 208 */         double agg_value26 = -1.0;
/* 209 */
/* 210 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 211 */         double agg_value28 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 212 */         boolean agg_isNull25 = agg_isNull26;
/* 213 */         double agg_value27 = agg_value28;
/* 214 */         if (agg_isNull25) {
/* 215 */           if (!agg_isNull15) {
/* 216 */             agg_isNull25 = false;
/* 217 */             agg_value27 = agg_value17;
/* 218 */           }
/* 219 */         }
/* 220 */
/* 221 */         if (!inputadapter_isNull5) {
/* 222 */           agg_isNull24 = false; // resultCode could change nullability.
/* 223 */           agg_value26 = agg_value27 + inputadapter_value5;
/* 224 */
/* 225 */         }
/* 226 */         boolean agg_isNull23 = agg_isNull24;
/* 227 */         double agg_value25 = agg_value26;
/* 228 */         if (agg_isNull23) {
/* 229 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 230 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 231 */           if (!agg_isNull28) {
/* 232 */             agg_isNull23 = false;
/* 233 */             agg_value25 = agg_value30;
/* 234 */           }
/* 235 */         }
/* 236 */         // update unsafe row buffer
/* 237 */         if (!agg_isNull17) {
/* 238 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value19);
/* 239 */         } else {
/* 240 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 241 */         }
/* 242 */
/* 243 */         if (!agg_isNull23) {
/* 244 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value25);
/* 245 */         } else {
/* 246 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 247 */         }
/* 248 */
/* 249 */       }
/* 250 */       if (shouldStop()) return;
/* 251 */     }
/* 252 */
/* 253 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 254 */   }
/* 255 */
/* 256 */   private void wholestagecodegen_init_1() {
/* 257 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 258 */     bhj_result = new UnsafeRow(8);
/* 259 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 96);
/* 260 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 8);
/* 261 */     project_result = new UnsafeRow(7);
/* 262 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 128);
/* 263 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 7);
/* 264 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 265 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 266 */
/* 267 */   }
/* 268 */
/* 269 */   protected void processNext() throws java.io.IOException {
/* 270 */     if (!agg_initAgg) {
/* 271 */       agg_initAgg = true;
/* 272 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 273 */       agg_doAggregateWithKeys();
/* 274 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 275 */     }
/* 276 */
/* 277 */     // output the result
/* 278 */
/* 279 */     while (agg_mapIter.next()) {
/* 280 */       wholestagecodegen_numOutputRows.add(1);
/* 281 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 282 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 283 */
/* 284 */       boolean agg_isNull29 = agg_aggKey.isNullAt(0);
/* 285 */       int agg_value31 = agg_isNull29 ? -1 : (agg_aggKey.getInt(0));
/* 286 */       boolean agg_isNull30 = agg_aggKey.isNullAt(1);
/* 287 */       int agg_value32 = agg_isNull30 ? -1 : (agg_aggKey.getInt(1));
/* 288 */       boolean agg_isNull31 = agg_aggKey.isNullAt(2);
/* 289 */       int agg_value33 = agg_isNull31 ? -1 : (agg_aggKey.getInt(2));
/* 290 */       boolean agg_isNull32 = agg_aggKey.isNullAt(3);
/* 291 */       UTF8String agg_value34 = agg_isNull32 ? null : (agg_aggKey.getUTF8String(3));
/* 292 */       boolean agg_isNull33 = agg_aggBuffer.isNullAt(0);
/* 293 */       double agg_value35 = agg_isNull33 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 294 */       boolean agg_isNull34 = agg_aggBuffer.isNullAt(1);
/* 295 */       double agg_value36 = agg_isNull34 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 296 */
/* 297 */       // generate join key for stream side
/* 298 */
/* 299 */       boolean bhj_isNull = agg_isNull30;
/* 300 */       long bhj_value = -1L;
/* 301 */       if (!agg_isNull30) {
/* 302 */         bhj_value = (long) agg_value32;
/* 303 */       }
/* 304 */       // find matches from HashedRelation
/* 305 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 306 */       if (bhj_matched == null) continue;
/* 307 */
/* 308 */       bhj_numOutputRows.add(1);
/* 309 */
/* 310 */       boolean bhj_isNull4 = bhj_matched.isNullAt(2);
/* 311 */       UTF8String bhj_value4 = bhj_isNull4 ? null : (bhj_matched.getUTF8String(2));
/* 312 */       boolean bhj_isNull3 = bhj_matched.isNullAt(1);
/* 313 */       UTF8String bhj_value3 = bhj_isNull3 ? null : (bhj_matched.getUTF8String(1));
/* 314 */       boolean project_isNull2 = true;
/* 315 */       UTF8String project_value2 = null;
/* 316 */
/* 317 */       if (!agg_isNull32) {
/* 318 */         project_isNull2 = false; // resultCode could change nullability.
/* 319 */         project_value2 = agg_value34.substringSQL(1, 30);
/* 320 */
/* 321 */       }
/* 322 */       project_holder.reset();
/* 323 */
/* 324 */       project_rowWriter.zeroOutNullBytes();
/* 325 */
/* 326 */       if (bhj_isNull4) {
/* 327 */         project_rowWriter.setNullAt(0);
/* 328 */       } else {
/* 329 */         project_rowWriter.write(0, bhj_value4);
/* 330 */       }
/* 331 */
/* 332 */       if (bhj_isNull3) {
/* 333 */         project_rowWriter.setNullAt(1);
/* 334 */       } else {
/* 335 */         project_rowWriter.write(1, bhj_value3);
/* 336 */       }
/* 337 */
/* 338 */       if (project_isNull2) {
/* 339 */         project_rowWriter.setNullAt(2);
/* 340 */       } else {
/* 341 */         project_rowWriter.write(2, project_value2);
/* 342 */       }
/* 343 */
/* 344 */       if (agg_isNull29) {
/* 345 */         project_rowWriter.setNullAt(3);
/* 346 */       } else {
/* 347 */         project_rowWriter.write(3, agg_value31);
/* 348 */       }
/* 349 */
/* 350 */       if (agg_isNull33) {
/* 351 */         project_rowWriter.setNullAt(4);
/* 352 */       } else {
/* 353 */         project_rowWriter.write(4, agg_value35);
/* 354 */       }
/* 355 */
/* 356 */       if (agg_isNull34) {
/* 357 */         project_rowWriter.setNullAt(5);
/* 358 */       } else {
/* 359 */         project_rowWriter.write(5, agg_value36);
/* 360 */       }
/* 361 */
/* 362 */       if (agg_isNull32) {
/* 363 */         project_rowWriter.setNullAt(6);
/* 364 */       } else {
/* 365 */         project_rowWriter.write(6, agg_value34);
/* 366 */       }
/* 367 */       project_result.setTotalSize(project_holder.totalSize());
/* 368 */       append(project_result);
/* 369 */
/* 370 */       if (shouldStop()) return;
/* 371 */     }
/* 372 */
/* 373 */     agg_mapIter.close();
/* 374 */     if (agg_sorter == null) {
/* 375 */       agg_hashMap.free();
/* 376 */     }
/* 377 */   }
/* 378 */ }
