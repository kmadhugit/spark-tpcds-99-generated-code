/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean sort_needToSort;
/* 009 */   private org.apache.spark.sql.execution.SortExec sort_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeExternalRowSorter sort_sorter;
/* 011 */   private org.apache.spark.executor.TaskMetrics sort_metrics;
/* 012 */   private scala.collection.Iterator<UnsafeRow> sort_sortedIter;
/* 013 */   private boolean agg_initAgg;
/* 014 */   private boolean agg_bufIsNull;
/* 015 */   private double agg_bufValue;
/* 016 */   private boolean agg_bufIsNull1;
/* 017 */   private long agg_bufValue1;
/* 018 */   private boolean agg_bufIsNull2;
/* 019 */   private double agg_bufValue2;
/* 020 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 021 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 022 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 023 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 026 */   private scala.collection.Iterator inputadapter_input;
/* 027 */   private UnsafeRow agg_result;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 030 */   private int agg_value12;
/* 031 */   private UnsafeRow agg_result1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 035 */   private UnsafeRow filter_result;
/* 036 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 037 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 038 */   private UnsafeRow project_result;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 040 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_numOutputRows;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_aggTime;
/* 043 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_peakMemory;
/* 044 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_spillSize;
/* 045 */   private org.apache.spark.sql.execution.metric.SQLMetric sort_sortTime;
/* 046 */
/* 047 */   public GeneratedIterator(Object[] references) {
/* 048 */     this.references = references;
/* 049 */   }
/* 050 */
/* 051 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 052 */     partitionIndex = index;
/* 053 */     this.inputs = inputs;
/* 054 */     wholestagecodegen_init_0();
/* 055 */     wholestagecodegen_init_1();
/* 056 */
/* 057 */   }
/* 058 */
/* 059 */   private void wholestagecodegen_init_0() {
/* 060 */     sort_needToSort = true;
/* 061 */     this.sort_plan = (org.apache.spark.sql.execution.SortExec) references[0];
/* 062 */     sort_sorter = sort_plan.createSorter();
/* 063 */     sort_metrics = org.apache.spark.TaskContext.get().taskMetrics();
/* 064 */
/* 065 */     agg_initAgg = false;
/* 066 */
/* 067 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[1];
/* 068 */
/* 069 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 070 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 071 */     inputadapter_input = inputs[0];
/* 072 */     agg_result = new UnsafeRow(3);
/* 073 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 074 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 075 */
/* 076 */     agg_result1 = new UnsafeRow(7);
/* 077 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 078 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 079 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 080 */
/* 081 */   }
/* 082 */
/* 083 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 084 */     agg_hashMap = agg_plan.createHashMap();
/* 085 */
/* 086 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 087 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 088 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 089 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 090 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 091 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 092 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 093 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 094 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 095 */       double inputadapter_value3 = inputadapter_isNull3 ? -1.0 : (inputadapter_row.getDouble(3));
/* 096 */       long inputadapter_value4 = inputadapter_row.getLong(4);
/* 097 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 098 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 099 */
/* 100 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 101 */
/* 102 */       UnsafeRow agg_fastAggBuffer = null;
/* 103 */
/* 104 */       if (agg_fastAggBuffer == null) {
/* 105 */         // generate grouping key
/* 106 */         agg_rowWriter.zeroOutNullBytes();
/* 107 */
/* 108 */         if (inputadapter_isNull) {
/* 109 */           agg_rowWriter.setNullAt(0);
/* 110 */         } else {
/* 111 */           agg_rowWriter.write(0, inputadapter_value);
/* 112 */         }
/* 113 */
/* 114 */         if (inputadapter_isNull1) {
/* 115 */           agg_rowWriter.setNullAt(1);
/* 116 */         } else {
/* 117 */           agg_rowWriter.write(1, inputadapter_value1);
/* 118 */         }
/* 119 */
/* 120 */         if (inputadapter_isNull2) {
/* 121 */           agg_rowWriter.setNullAt(2);
/* 122 */         } else {
/* 123 */           agg_rowWriter.write(2, inputadapter_value2);
/* 124 */         }
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
/* 138 */         if (true) {
/* 139 */           // try to get the buffer from hash map
/* 140 */           agg_unsafeRowAggBuffer =
/* 141 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 142 */         }
/* 143 */         if (agg_unsafeRowAggBuffer == null) {
/* 144 */           if (agg_sorter == null) {
/* 145 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 146 */           } else {
/* 147 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 148 */           }
/* 149 */
/* 150 */           // the hash map had be spilled, it should have enough memory now,
/* 151 */           // try  to allocate buffer again.
/* 152 */           agg_unsafeRowAggBuffer =
/* 153 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 154 */           if (agg_unsafeRowAggBuffer == null) {
/* 155 */             // failed to allocate the first page
/* 156 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 157 */           }
/* 158 */         }
/* 159 */       }
/* 160 */
/* 161 */       if (agg_fastAggBuffer != null) {
/* 162 */         // update fast row
/* 163 */
/* 164 */       } else {
/* 165 */         // update unsafe row
/* 166 */
/* 167 */         // common sub-expressions
/* 168 */
/* 169 */         // evaluate aggregate function
/* 170 */         boolean agg_isNull14 = true;
/* 171 */         double agg_value17 = -1.0;
/* 172 */
/* 173 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 174 */         double agg_value19 = agg_isNull16 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 175 */         boolean agg_isNull15 = agg_isNull16;
/* 176 */         double agg_value18 = agg_value19;
/* 177 */         if (agg_isNull15) {
/* 178 */           boolean agg_isNull17 = false;
/* 179 */           double agg_value20 = -1.0;
/* 180 */           if (!false) {
/* 181 */             agg_value20 = (double) 0;
/* 182 */           }
/* 183 */           if (!agg_isNull17) {
/* 184 */             agg_isNull15 = false;
/* 185 */             agg_value18 = agg_value20;
/* 186 */           }
/* 187 */         }
/* 188 */
/* 189 */         if (!inputadapter_isNull3) {
/* 190 */           agg_isNull14 = false; // resultCode could change nullability.
/* 191 */           agg_value17 = agg_value18 + inputadapter_value3;
/* 192 */
/* 193 */         }
/* 194 */         boolean agg_isNull13 = agg_isNull14;
/* 195 */         double agg_value16 = agg_value17;
/* 196 */         if (agg_isNull13) {
/* 197 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 198 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 199 */           if (!agg_isNull20) {
/* 200 */             agg_isNull13 = false;
/* 201 */             agg_value16 = agg_value23;
/* 202 */           }
/* 203 */         }
/* 204 */         boolean agg_isNull21 = false;
/* 205 */
/* 206 */         long agg_value25 = agg_unsafeRowAggBuffer.getLong(1);
/* 207 */
/* 208 */         long agg_value24 = -1L;
/* 209 */         agg_value24 = agg_value25 + inputadapter_value4;
/* 210 */         boolean agg_isNull25 = true;
/* 211 */         double agg_value28 = -1.0;
/* 212 */
/* 213 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 214 */         double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 215 */         boolean agg_isNull26 = agg_isNull27;
/* 216 */         double agg_value29 = agg_value30;
/* 217 */         if (agg_isNull26) {
/* 218 */           boolean agg_isNull28 = false;
/* 219 */           double agg_value31 = -1.0;
/* 220 */           if (!false) {
/* 221 */             agg_value31 = (double) 0;
/* 222 */           }
/* 223 */           if (!agg_isNull28) {
/* 224 */             agg_isNull26 = false;
/* 225 */             agg_value29 = agg_value31;
/* 226 */           }
/* 227 */         }
/* 228 */
/* 229 */         if (!inputadapter_isNull5) {
/* 230 */           agg_isNull25 = false; // resultCode could change nullability.
/* 231 */           agg_value28 = agg_value29 + inputadapter_value5;
/* 232 */
/* 233 */         }
/* 234 */         boolean agg_isNull24 = agg_isNull25;
/* 235 */         double agg_value27 = agg_value28;
/* 236 */         if (agg_isNull24) {
/* 237 */           boolean agg_isNull31 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 238 */           double agg_value34 = agg_isNull31 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 239 */           if (!agg_isNull31) {
/* 240 */             agg_isNull24 = false;
/* 241 */             agg_value27 = agg_value34;
/* 242 */           }
/* 243 */         }
/* 244 */         // update unsafe row buffer
/* 245 */         if (!agg_isNull13) {
/* 246 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value16);
/* 247 */         } else {
/* 248 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 249 */         }
/* 250 */
/* 251 */         agg_unsafeRowAggBuffer.setLong(1, agg_value24);
/* 252 */
/* 253 */         if (!agg_isNull24) {
/* 254 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value27);
/* 255 */         } else {
/* 256 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 257 */         }
/* 258 */
/* 259 */       }
/* 260 */       if (shouldStop()) return;
/* 261 */     }
/* 262 */
/* 263 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 264 */   }
/* 265 */
/* 266 */   private void wholestagecodegen_init_1() {
/* 267 */     filter_result = new UnsafeRow(7);
/* 268 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 269 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 270 */     project_result = new UnsafeRow(6);
/* 271 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 272 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 273 */     this.sort_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 274 */     this.sort_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 275 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 276 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 277 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 278 */
/* 279 */   }
/* 280 */
/* 281 */   private void sort_addToSorter() throws java.io.IOException {
/* 282 */     if (!agg_initAgg) {
/* 283 */       agg_initAgg = true;
/* 284 */       long sort_beforeAgg = System.nanoTime();
/* 285 */       agg_doAggregateWithKeys();
/* 286 */       sort_aggTime.add((System.nanoTime() - sort_beforeAgg) / 1000000);
/* 287 */     }
/* 288 */
/* 289 */     // output the result
/* 290 */
/* 291 */     while (agg_mapIter.next()) {
/* 292 */       sort_numOutputRows.add(1);
/* 293 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 294 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 295 */
/* 296 */       boolean agg_isNull32 = agg_aggKey.isNullAt(0);
/* 297 */       int agg_value35 = agg_isNull32 ? -1 : (agg_aggKey.getInt(0));
/* 298 */       boolean agg_isNull33 = agg_aggKey.isNullAt(1);
/* 299 */       int agg_value36 = agg_isNull33 ? -1 : (agg_aggKey.getInt(1));
/* 300 */       boolean agg_isNull34 = agg_aggKey.isNullAt(2);
/* 301 */       int agg_value37 = agg_isNull34 ? -1 : (agg_aggKey.getInt(2));
/* 302 */       boolean agg_isNull35 = agg_aggBuffer.isNullAt(0);
/* 303 */       double agg_value38 = agg_isNull35 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 304 */       long agg_value39 = agg_aggBuffer.getLong(1);
/* 305 */       boolean agg_isNull37 = agg_aggBuffer.isNullAt(2);
/* 306 */       double agg_value40 = agg_isNull37 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 307 */
/* 308 */       if (!(!(agg_isNull37))) continue;
/* 309 */
/* 310 */       boolean filter_isNull2 = true;
/* 311 */       boolean filter_value2 = false;
/* 312 */
/* 313 */       if (!false) {
/* 314 */         filter_isNull2 = false; // resultCode could change nullability.
/* 315 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value40, 4394.688530360974D) > 0;
/* 316 */
/* 317 */       }
/* 318 */       if (filter_isNull2 || !filter_value2) continue;
/* 319 */
/* 320 */       filter_numOutputRows.add(1);
/* 321 */
/* 322 */       project_holder.reset();
/* 323 */
/* 324 */       project_rowWriter.zeroOutNullBytes();
/* 325 */
/* 326 */       project_rowWriter.write(0, ((UTF8String) references[4]));
/* 327 */
/* 328 */       if (agg_isNull32) {
/* 329 */         project_rowWriter.setNullAt(1);
/* 330 */       } else {
/* 331 */         project_rowWriter.write(1, agg_value35);
/* 332 */       }
/* 333 */
/* 334 */       if (agg_isNull33) {
/* 335 */         project_rowWriter.setNullAt(2);
/* 336 */       } else {
/* 337 */         project_rowWriter.write(2, agg_value36);
/* 338 */       }
/* 339 */
/* 340 */       if (agg_isNull34) {
/* 341 */         project_rowWriter.setNullAt(3);
/* 342 */       } else {
/* 343 */         project_rowWriter.write(3, agg_value37);
/* 344 */       }
/* 345 */
/* 346 */       if (agg_isNull35) {
/* 347 */         project_rowWriter.setNullAt(4);
/* 348 */       } else {
/* 349 */         project_rowWriter.write(4, agg_value38);
/* 350 */       }
/* 351 */
/* 352 */       project_rowWriter.write(5, agg_value39);
/* 353 */       project_result.setTotalSize(project_holder.totalSize());
/* 354 */       sort_sorter.insertRow((UnsafeRow)project_result);
/* 355 */
/* 356 */       if (shouldStop()) return;
/* 357 */     }
/* 358 */
/* 359 */     agg_mapIter.close();
/* 360 */     if (agg_sorter == null) {
/* 361 */       agg_hashMap.free();
/* 362 */     }
/* 363 */
/* 364 */   }
/* 365 */
/* 366 */   protected void processNext() throws java.io.IOException {
/* 367 */     if (sort_needToSort) {
/* 368 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 369 */       sort_addToSorter();
/* 370 */       sort_sortedIter = sort_sorter.sort();
/* 371 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 372 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 373 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 374 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 375 */       sort_needToSort = false;
/* 376 */     }
/* 377 */
/* 378 */     while (sort_sortedIter.hasNext()) {
/* 379 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 380 */
/* 381 */       append(sort_outputRow);
/* 382 */
/* 383 */       if (shouldStop()) return;
/* 384 */     }
/* 385 */   }
/* 386 */ }
