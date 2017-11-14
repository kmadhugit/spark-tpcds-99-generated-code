/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private long agg_bufValue;
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
/* 025 */   private int agg_value12;
/* 026 */   private UnsafeRow agg_result1;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 030 */   private UnsafeRow filter_result;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 033 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 035 */
/* 036 */   public GeneratedIterator(Object[] references) {
/* 037 */     this.references = references;
/* 038 */   }
/* 039 */
/* 040 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 041 */     partitionIndex = index;
/* 042 */     this.inputs = inputs;
/* 043 */     wholestagecodegen_init_0();
/* 044 */     wholestagecodegen_init_1();
/* 045 */
/* 046 */   }
/* 047 */
/* 048 */   private void wholestagecodegen_init_0() {
/* 049 */     agg_initAgg = false;
/* 050 */
/* 051 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 052 */
/* 053 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 054 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 055 */     inputadapter_input = inputs[0];
/* 056 */     agg_result = new UnsafeRow(3);
/* 057 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 058 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 059 */
/* 060 */     agg_result1 = new UnsafeRow(6);
/* 061 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 062 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 6);
/* 063 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 064 */     filter_result = new UnsafeRow(6);
/* 065 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 070 */     agg_hashMap = agg_plan.createHashMap();
/* 071 */
/* 072 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 073 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 074 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 075 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 076 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 077 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 078 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 079 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 080 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 081 */       long inputadapter_value3 = inputadapter_isNull3 ? -1L : (inputadapter_row.getLong(3));
/* 082 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 083 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 084 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 085 */       double inputadapter_value5 = inputadapter_isNull5 ? -1.0 : (inputadapter_row.getDouble(5));
/* 086 */
/* 087 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 088 */
/* 089 */       UnsafeRow agg_fastAggBuffer = null;
/* 090 */
/* 091 */       if (agg_fastAggBuffer == null) {
/* 092 */         // generate grouping key
/* 093 */         agg_rowWriter.zeroOutNullBytes();
/* 094 */
/* 095 */         if (inputadapter_isNull) {
/* 096 */           agg_rowWriter.setNullAt(0);
/* 097 */         } else {
/* 098 */           agg_rowWriter.write(0, inputadapter_value);
/* 099 */         }
/* 100 */
/* 101 */         if (inputadapter_isNull1) {
/* 102 */           agg_rowWriter.setNullAt(1);
/* 103 */         } else {
/* 104 */           agg_rowWriter.write(1, inputadapter_value1);
/* 105 */         }
/* 106 */
/* 107 */         if (inputadapter_isNull2) {
/* 108 */           agg_rowWriter.setNullAt(2);
/* 109 */         } else {
/* 110 */           agg_rowWriter.write(2, inputadapter_value2);
/* 111 */         }
/* 112 */         agg_value12 = 42;
/* 113 */
/* 114 */         if (!inputadapter_isNull) {
/* 115 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value12);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull1) {
/* 119 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value12);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull2) {
/* 123 */           agg_value12 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value12);
/* 124 */         }
/* 125 */         if (true) {
/* 126 */           // try to get the buffer from hash map
/* 127 */           agg_unsafeRowAggBuffer =
/* 128 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 129 */         }
/* 130 */         if (agg_unsafeRowAggBuffer == null) {
/* 131 */           if (agg_sorter == null) {
/* 132 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 133 */           } else {
/* 134 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 135 */           }
/* 136 */
/* 137 */           // the hash map had be spilled, it should have enough memory now,
/* 138 */           // try  to allocate buffer again.
/* 139 */           agg_unsafeRowAggBuffer =
/* 140 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value12);
/* 141 */           if (agg_unsafeRowAggBuffer == null) {
/* 142 */             // failed to allocate the first page
/* 143 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 144 */           }
/* 145 */         }
/* 146 */       }
/* 147 */
/* 148 */       if (agg_fastAggBuffer != null) {
/* 149 */         // update fast row
/* 150 */
/* 151 */       } else {
/* 152 */         // update unsafe row
/* 153 */
/* 154 */         // common sub-expressions
/* 155 */
/* 156 */         // evaluate aggregate function
/* 157 */         boolean agg_isNull14 = true;
/* 158 */         long agg_value17 = -1L;
/* 159 */
/* 160 */         boolean agg_isNull16 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 161 */         long agg_value19 = agg_isNull16 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 162 */         boolean agg_isNull15 = agg_isNull16;
/* 163 */         long agg_value18 = agg_value19;
/* 164 */         if (agg_isNull15) {
/* 165 */           boolean agg_isNull17 = false;
/* 166 */           long agg_value20 = -1L;
/* 167 */           if (!false) {
/* 168 */             agg_value20 = (long) 0;
/* 169 */           }
/* 170 */           if (!agg_isNull17) {
/* 171 */             agg_isNull15 = false;
/* 172 */             agg_value18 = agg_value20;
/* 173 */           }
/* 174 */         }
/* 175 */
/* 176 */         if (!inputadapter_isNull3) {
/* 177 */           agg_isNull14 = false; // resultCode could change nullability.
/* 178 */           agg_value17 = agg_value18 + inputadapter_value3;
/* 179 */
/* 180 */         }
/* 181 */         boolean agg_isNull13 = agg_isNull14;
/* 182 */         long agg_value16 = agg_value17;
/* 183 */         if (agg_isNull13) {
/* 184 */           boolean agg_isNull20 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 185 */           long agg_value23 = agg_isNull20 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 186 */           if (!agg_isNull20) {
/* 187 */             agg_isNull13 = false;
/* 188 */             agg_value16 = agg_value23;
/* 189 */           }
/* 190 */         }
/* 191 */         boolean agg_isNull22 = true;
/* 192 */         double agg_value25 = -1.0;
/* 193 */
/* 194 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 195 */         double agg_value27 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 196 */         boolean agg_isNull23 = agg_isNull24;
/* 197 */         double agg_value26 = agg_value27;
/* 198 */         if (agg_isNull23) {
/* 199 */           boolean agg_isNull25 = false;
/* 200 */           double agg_value28 = -1.0;
/* 201 */           if (!false) {
/* 202 */             agg_value28 = (double) 0;
/* 203 */           }
/* 204 */           if (!agg_isNull25) {
/* 205 */             agg_isNull23 = false;
/* 206 */             agg_value26 = agg_value28;
/* 207 */           }
/* 208 */         }
/* 209 */
/* 210 */         if (!inputadapter_isNull4) {
/* 211 */           agg_isNull22 = false; // resultCode could change nullability.
/* 212 */           agg_value25 = agg_value26 + inputadapter_value4;
/* 213 */
/* 214 */         }
/* 215 */         boolean agg_isNull21 = agg_isNull22;
/* 216 */         double agg_value24 = agg_value25;
/* 217 */         if (agg_isNull21) {
/* 218 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 219 */           double agg_value31 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 220 */           if (!agg_isNull28) {
/* 221 */             agg_isNull21 = false;
/* 222 */             agg_value24 = agg_value31;
/* 223 */           }
/* 224 */         }
/* 225 */         boolean agg_isNull30 = true;
/* 226 */         double agg_value33 = -1.0;
/* 227 */
/* 228 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 229 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 230 */         boolean agg_isNull31 = agg_isNull32;
/* 231 */         double agg_value34 = agg_value35;
/* 232 */         if (agg_isNull31) {
/* 233 */           boolean agg_isNull33 = false;
/* 234 */           double agg_value36 = -1.0;
/* 235 */           if (!false) {
/* 236 */             agg_value36 = (double) 0;
/* 237 */           }
/* 238 */           if (!agg_isNull33) {
/* 239 */             agg_isNull31 = false;
/* 240 */             agg_value34 = agg_value36;
/* 241 */           }
/* 242 */         }
/* 243 */
/* 244 */         if (!inputadapter_isNull5) {
/* 245 */           agg_isNull30 = false; // resultCode could change nullability.
/* 246 */           agg_value33 = agg_value34 + inputadapter_value5;
/* 247 */
/* 248 */         }
/* 249 */         boolean agg_isNull29 = agg_isNull30;
/* 250 */         double agg_value32 = agg_value33;
/* 251 */         if (agg_isNull29) {
/* 252 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 253 */           double agg_value39 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 254 */           if (!agg_isNull36) {
/* 255 */             agg_isNull29 = false;
/* 256 */             agg_value32 = agg_value39;
/* 257 */           }
/* 258 */         }
/* 259 */         // update unsafe row buffer
/* 260 */         if (!agg_isNull13) {
/* 261 */           agg_unsafeRowAggBuffer.setLong(0, agg_value16);
/* 262 */         } else {
/* 263 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 264 */         }
/* 265 */
/* 266 */         if (!agg_isNull21) {
/* 267 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value24);
/* 268 */         } else {
/* 269 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 270 */         }
/* 271 */
/* 272 */         if (!agg_isNull29) {
/* 273 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value32);
/* 274 */         } else {
/* 275 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 276 */         }
/* 277 */
/* 278 */       }
/* 279 */       if (shouldStop()) return;
/* 280 */     }
/* 281 */
/* 282 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 283 */   }
/* 284 */
/* 285 */   private void wholestagecodegen_init_1() {
/* 286 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 6);
/* 287 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 288 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 289 */
/* 290 */   }
/* 291 */
/* 292 */   protected void processNext() throws java.io.IOException {
/* 293 */     if (!agg_initAgg) {
/* 294 */       agg_initAgg = true;
/* 295 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 296 */       agg_doAggregateWithKeys();
/* 297 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 298 */     }
/* 299 */
/* 300 */     // output the result
/* 301 */
/* 302 */     while (agg_mapIter.next()) {
/* 303 */       wholestagecodegen_numOutputRows.add(1);
/* 304 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 305 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 306 */
/* 307 */       boolean agg_isNull37 = agg_aggKey.isNullAt(0);
/* 308 */       int agg_value40 = agg_isNull37 ? -1 : (agg_aggKey.getInt(0));
/* 309 */       boolean agg_isNull38 = agg_aggKey.isNullAt(1);
/* 310 */       int agg_value41 = agg_isNull38 ? -1 : (agg_aggKey.getInt(1));
/* 311 */       boolean agg_isNull39 = agg_aggKey.isNullAt(2);
/* 312 */       int agg_value42 = agg_isNull39 ? -1 : (agg_aggKey.getInt(2));
/* 313 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(0);
/* 314 */       long agg_value43 = agg_isNull40 ? -1L : (agg_aggBuffer.getLong(0));
/* 315 */       boolean agg_isNull41 = agg_aggBuffer.isNullAt(1);
/* 316 */       double agg_value44 = agg_isNull41 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 317 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(2);
/* 318 */       double agg_value45 = agg_isNull42 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 319 */
/* 320 */       boolean filter_isNull = false;
/* 321 */
/* 322 */       boolean filter_isNull1 = agg_isNull40;
/* 323 */       long filter_value1 = agg_value43;
/* 324 */       if (filter_isNull1) {
/* 325 */         if (!false) {
/* 326 */           filter_isNull1 = false;
/* 327 */           filter_value1 = 0L;
/* 328 */         }
/* 329 */       }
/* 330 */
/* 331 */       boolean filter_value = false;
/* 332 */       filter_value = filter_value1 > 0L;
/* 333 */       if (!filter_value) continue;
/* 334 */
/* 335 */       filter_numOutputRows.add(1);
/* 336 */
/* 337 */       filter_rowWriter.zeroOutNullBytes();
/* 338 */
/* 339 */       if (agg_isNull37) {
/* 340 */         filter_rowWriter.setNullAt(0);
/* 341 */       } else {
/* 342 */         filter_rowWriter.write(0, agg_value40);
/* 343 */       }
/* 344 */
/* 345 */       if (agg_isNull38) {
/* 346 */         filter_rowWriter.setNullAt(1);
/* 347 */       } else {
/* 348 */         filter_rowWriter.write(1, agg_value41);
/* 349 */       }
/* 350 */
/* 351 */       if (agg_isNull39) {
/* 352 */         filter_rowWriter.setNullAt(2);
/* 353 */       } else {
/* 354 */         filter_rowWriter.write(2, agg_value42);
/* 355 */       }
/* 356 */
/* 357 */       if (agg_isNull40) {
/* 358 */         filter_rowWriter.setNullAt(3);
/* 359 */       } else {
/* 360 */         filter_rowWriter.write(3, agg_value43);
/* 361 */       }
/* 362 */
/* 363 */       if (agg_isNull41) {
/* 364 */         filter_rowWriter.setNullAt(4);
/* 365 */       } else {
/* 366 */         filter_rowWriter.write(4, agg_value44);
/* 367 */       }
/* 368 */
/* 369 */       if (agg_isNull42) {
/* 370 */         filter_rowWriter.setNullAt(5);
/* 371 */       } else {
/* 372 */         filter_rowWriter.write(5, agg_value45);
/* 373 */       }
/* 374 */       append(filter_result);
/* 375 */
/* 376 */       if (shouldStop()) return;
/* 377 */     }
/* 378 */
/* 379 */     agg_mapIter.close();
/* 380 */     if (agg_sorter == null) {
/* 381 */       agg_hashMap.free();
/* 382 */     }
/* 383 */   }
/* 384 */ }
