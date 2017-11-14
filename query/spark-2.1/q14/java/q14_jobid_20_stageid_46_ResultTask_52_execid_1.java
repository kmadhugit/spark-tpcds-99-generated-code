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
/* 086 */     while (inputadapter_input.hasNext()) {
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
/* 168 */         boolean agg_isNull13 = false;
/* 169 */         double agg_value16 = -1.0;
/* 170 */         if (!false) {
/* 171 */           agg_value16 = (double) 0;
/* 172 */         }
/* 173 */         // evaluate aggregate function
/* 174 */         boolean agg_isNull16 = true;
/* 175 */         double agg_value19 = -1.0;
/* 176 */
/* 177 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 178 */         double agg_value21 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 179 */         boolean agg_isNull17 = agg_isNull18;
/* 180 */         double agg_value20 = agg_value21;
/* 181 */         if (agg_isNull17) {
/* 182 */           if (!agg_isNull13) {
/* 183 */             agg_isNull17 = false;
/* 184 */             agg_value20 = agg_value16;
/* 185 */           }
/* 186 */         }
/* 187 */
/* 188 */         if (!inputadapter_isNull3) {
/* 189 */           agg_isNull16 = false; // resultCode could change nullability.
/* 190 */           agg_value19 = agg_value20 + inputadapter_value3;
/* 191 */
/* 192 */         }
/* 193 */         boolean agg_isNull15 = agg_isNull16;
/* 194 */         double agg_value18 = agg_value19;
/* 195 */         if (agg_isNull15) {
/* 196 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 197 */           double agg_value23 = agg_isNull20 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 198 */           if (!agg_isNull20) {
/* 199 */             agg_isNull15 = false;
/* 200 */             agg_value18 = agg_value23;
/* 201 */           }
/* 202 */         }
/* 203 */         boolean agg_isNull21 = false;
/* 204 */
/* 205 */         long agg_value25 = agg_unsafeRowAggBuffer.getLong(1);
/* 206 */
/* 207 */         long agg_value24 = -1L;
/* 208 */         agg_value24 = agg_value25 + inputadapter_value4;
/* 209 */         boolean agg_isNull25 = true;
/* 210 */         double agg_value28 = -1.0;
/* 211 */
/* 212 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 213 */         double agg_value30 = agg_isNull27 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 214 */         boolean agg_isNull26 = agg_isNull27;
/* 215 */         double agg_value29 = agg_value30;
/* 216 */         if (agg_isNull26) {
/* 217 */           if (!agg_isNull13) {
/* 218 */             agg_isNull26 = false;
/* 219 */             agg_value29 = agg_value16;
/* 220 */           }
/* 221 */         }
/* 222 */
/* 223 */         if (!inputadapter_isNull5) {
/* 224 */           agg_isNull25 = false; // resultCode could change nullability.
/* 225 */           agg_value28 = agg_value29 + inputadapter_value5;
/* 226 */
/* 227 */         }
/* 228 */         boolean agg_isNull24 = agg_isNull25;
/* 229 */         double agg_value27 = agg_value28;
/* 230 */         if (agg_isNull24) {
/* 231 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 232 */           double agg_value32 = agg_isNull29 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 233 */           if (!agg_isNull29) {
/* 234 */             agg_isNull24 = false;
/* 235 */             agg_value27 = agg_value32;
/* 236 */           }
/* 237 */         }
/* 238 */         // update unsafe row buffer
/* 239 */         if (!agg_isNull15) {
/* 240 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value18);
/* 241 */         } else {
/* 242 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 243 */         }
/* 244 */
/* 245 */         agg_unsafeRowAggBuffer.setLong(1, agg_value24);
/* 246 */
/* 247 */         if (!agg_isNull24) {
/* 248 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value27);
/* 249 */         } else {
/* 250 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 251 */         }
/* 252 */
/* 253 */       }
/* 254 */       if (shouldStop()) return;
/* 255 */     }
/* 256 */
/* 257 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 258 */   }
/* 259 */
/* 260 */   private void wholestagecodegen_init_1() {
/* 261 */     filter_result = new UnsafeRow(7);
/* 262 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 263 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 7);
/* 264 */     project_result = new UnsafeRow(6);
/* 265 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 266 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 267 */     this.sort_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 268 */     this.sort_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 269 */     this.sort_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 270 */     this.sort_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 271 */     this.sort_sortTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 272 */
/* 273 */   }
/* 274 */
/* 275 */   private void sort_addToSorter() throws java.io.IOException {
/* 276 */     if (!agg_initAgg) {
/* 277 */       agg_initAgg = true;
/* 278 */       long sort_beforeAgg = System.nanoTime();
/* 279 */       agg_doAggregateWithKeys();
/* 280 */       sort_aggTime.add((System.nanoTime() - sort_beforeAgg) / 1000000);
/* 281 */     }
/* 282 */
/* 283 */     // output the result
/* 284 */
/* 285 */     while (agg_mapIter.next()) {
/* 286 */       sort_numOutputRows.add(1);
/* 287 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 288 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 289 */
/* 290 */       boolean agg_isNull30 = agg_aggKey.isNullAt(0);
/* 291 */       int agg_value33 = agg_isNull30 ? -1 : (agg_aggKey.getInt(0));
/* 292 */       boolean agg_isNull31 = agg_aggKey.isNullAt(1);
/* 293 */       int agg_value34 = agg_isNull31 ? -1 : (agg_aggKey.getInt(1));
/* 294 */       boolean agg_isNull32 = agg_aggKey.isNullAt(2);
/* 295 */       int agg_value35 = agg_isNull32 ? -1 : (agg_aggKey.getInt(2));
/* 296 */       boolean agg_isNull33 = agg_aggBuffer.isNullAt(0);
/* 297 */       double agg_value36 = agg_isNull33 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 298 */       long agg_value37 = agg_aggBuffer.getLong(1);
/* 299 */       boolean agg_isNull35 = agg_aggBuffer.isNullAt(2);
/* 300 */       double agg_value38 = agg_isNull35 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 301 */
/* 302 */       if (!(!(agg_isNull35))) continue;
/* 303 */
/* 304 */       boolean filter_isNull2 = true;
/* 305 */       boolean filter_value2 = false;
/* 306 */
/* 307 */       final double filter_value4 = -1.0;
/* 308 */       if (!true) {
/* 309 */         filter_isNull2 = false; // resultCode could change nullability.
/* 310 */         filter_value2 = org.apache.spark.util.Utils.nanSafeCompareDoubles(agg_value38, filter_value4) > 0;
/* 311 */
/* 312 */       }
/* 313 */       if (filter_isNull2 || !filter_value2) continue;
/* 314 */
/* 315 */       filter_numOutputRows.add(1);
/* 316 */
/* 317 */       Object agg_obj = ((Expression) references[4]).eval(null);
/* 318 */       UTF8String agg_value42 = (UTF8String) agg_obj;
/* 319 */       project_holder.reset();
/* 320 */
/* 321 */       project_rowWriter.zeroOutNullBytes();
/* 322 */
/* 323 */       project_rowWriter.write(0, agg_value42);
/* 324 */
/* 325 */       if (agg_isNull30) {
/* 326 */         project_rowWriter.setNullAt(1);
/* 327 */       } else {
/* 328 */         project_rowWriter.write(1, agg_value33);
/* 329 */       }
/* 330 */
/* 331 */       if (agg_isNull31) {
/* 332 */         project_rowWriter.setNullAt(2);
/* 333 */       } else {
/* 334 */         project_rowWriter.write(2, agg_value34);
/* 335 */       }
/* 336 */
/* 337 */       if (agg_isNull32) {
/* 338 */         project_rowWriter.setNullAt(3);
/* 339 */       } else {
/* 340 */         project_rowWriter.write(3, agg_value35);
/* 341 */       }
/* 342 */
/* 343 */       if (agg_isNull33) {
/* 344 */         project_rowWriter.setNullAt(4);
/* 345 */       } else {
/* 346 */         project_rowWriter.write(4, agg_value36);
/* 347 */       }
/* 348 */
/* 349 */       project_rowWriter.write(5, agg_value37);
/* 350 */       project_result.setTotalSize(project_holder.totalSize());
/* 351 */       sort_sorter.insertRow((UnsafeRow)project_result);
/* 352 */
/* 353 */       if (shouldStop()) return;
/* 354 */     }
/* 355 */
/* 356 */     agg_mapIter.close();
/* 357 */     if (agg_sorter == null) {
/* 358 */       agg_hashMap.free();
/* 359 */     }
/* 360 */
/* 361 */   }
/* 362 */
/* 363 */   protected void processNext() throws java.io.IOException {
/* 364 */     if (sort_needToSort) {
/* 365 */       long sort_spillSizeBefore = sort_metrics.memoryBytesSpilled();
/* 366 */       sort_addToSorter();
/* 367 */       sort_sortedIter = sort_sorter.sort();
/* 368 */       sort_sortTime.add(sort_sorter.getSortTimeNanos() / 1000000);
/* 369 */       sort_peakMemory.add(sort_sorter.getPeakMemoryUsage());
/* 370 */       sort_spillSize.add(sort_metrics.memoryBytesSpilled() - sort_spillSizeBefore);
/* 371 */       sort_metrics.incPeakExecutionMemory(sort_sorter.getPeakMemoryUsage());
/* 372 */       sort_needToSort = false;
/* 373 */     }
/* 374 */
/* 375 */     while (sort_sortedIter.hasNext()) {
/* 376 */       UnsafeRow sort_outputRow = (UnsafeRow)sort_sortedIter.next();
/* 377 */
/* 378 */       append(sort_outputRow);
/* 379 */
/* 380 */       if (shouldStop()) return;
/* 381 */     }
/* 382 */   }
/* 383 */ }
