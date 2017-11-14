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
/* 060 */     agg_result1 = new UnsafeRow(5);
/* 061 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 062 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 5);
/* 063 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 064 */     filter_result = new UnsafeRow(5);
/* 065 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 066 */
/* 067 */   }
/* 068 */
/* 069 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 070 */     agg_hashMap = agg_plan.createHashMap();
/* 071 */
/* 072 */     while (inputadapter_input.hasNext()) {
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
/* 155 */         boolean agg_isNull13 = false;
/* 156 */         double agg_value16 = -1.0;
/* 157 */         if (!false) {
/* 158 */           agg_value16 = (double) 0;
/* 159 */         }
/* 160 */         // evaluate aggregate function
/* 161 */         boolean agg_isNull16 = true;
/* 162 */         long agg_value19 = -1L;
/* 163 */
/* 164 */         boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 165 */         long agg_value21 = agg_isNull18 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 166 */         boolean agg_isNull17 = agg_isNull18;
/* 167 */         long agg_value20 = agg_value21;
/* 168 */         if (agg_isNull17) {
/* 169 */           boolean agg_isNull19 = false;
/* 170 */           long agg_value22 = -1L;
/* 171 */           if (!false) {
/* 172 */             agg_value22 = (long) 0;
/* 173 */           }
/* 174 */           if (!agg_isNull19) {
/* 175 */             agg_isNull17 = false;
/* 176 */             agg_value20 = agg_value22;
/* 177 */           }
/* 178 */         }
/* 179 */
/* 180 */         if (!inputadapter_isNull3) {
/* 181 */           agg_isNull16 = false; // resultCode could change nullability.
/* 182 */           agg_value19 = agg_value20 + inputadapter_value3;
/* 183 */
/* 184 */         }
/* 185 */         boolean agg_isNull15 = agg_isNull16;
/* 186 */         long agg_value18 = agg_value19;
/* 187 */         if (agg_isNull15) {
/* 188 */           boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 189 */           long agg_value25 = agg_isNull22 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 190 */           if (!agg_isNull22) {
/* 191 */             agg_isNull15 = false;
/* 192 */             agg_value18 = agg_value25;
/* 193 */           }
/* 194 */         }
/* 195 */         boolean agg_isNull24 = true;
/* 196 */         double agg_value27 = -1.0;
/* 197 */
/* 198 */         boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 199 */         double agg_value29 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 200 */         boolean agg_isNull25 = agg_isNull26;
/* 201 */         double agg_value28 = agg_value29;
/* 202 */         if (agg_isNull25) {
/* 203 */           if (!agg_isNull13) {
/* 204 */             agg_isNull25 = false;
/* 205 */             agg_value28 = agg_value16;
/* 206 */           }
/* 207 */         }
/* 208 */
/* 209 */         if (!inputadapter_isNull4) {
/* 210 */           agg_isNull24 = false; // resultCode could change nullability.
/* 211 */           agg_value27 = agg_value28 + inputadapter_value4;
/* 212 */
/* 213 */         }
/* 214 */         boolean agg_isNull23 = agg_isNull24;
/* 215 */         double agg_value26 = agg_value27;
/* 216 */         if (agg_isNull23) {
/* 217 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 218 */           double agg_value31 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 219 */           if (!agg_isNull28) {
/* 220 */             agg_isNull23 = false;
/* 221 */             agg_value26 = agg_value31;
/* 222 */           }
/* 223 */         }
/* 224 */         boolean agg_isNull30 = true;
/* 225 */         double agg_value33 = -1.0;
/* 226 */
/* 227 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 228 */         double agg_value35 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 229 */         boolean agg_isNull31 = agg_isNull32;
/* 230 */         double agg_value34 = agg_value35;
/* 231 */         if (agg_isNull31) {
/* 232 */           if (!agg_isNull13) {
/* 233 */             agg_isNull31 = false;
/* 234 */             agg_value34 = agg_value16;
/* 235 */           }
/* 236 */         }
/* 237 */
/* 238 */         if (!inputadapter_isNull5) {
/* 239 */           agg_isNull30 = false; // resultCode could change nullability.
/* 240 */           agg_value33 = agg_value34 + inputadapter_value5;
/* 241 */
/* 242 */         }
/* 243 */         boolean agg_isNull29 = agg_isNull30;
/* 244 */         double agg_value32 = agg_value33;
/* 245 */         if (agg_isNull29) {
/* 246 */           boolean agg_isNull34 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 247 */           double agg_value37 = agg_isNull34 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 248 */           if (!agg_isNull34) {
/* 249 */             agg_isNull29 = false;
/* 250 */             agg_value32 = agg_value37;
/* 251 */           }
/* 252 */         }
/* 253 */         // update unsafe row buffer
/* 254 */         if (!agg_isNull15) {
/* 255 */           agg_unsafeRowAggBuffer.setLong(0, agg_value18);
/* 256 */         } else {
/* 257 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 258 */         }
/* 259 */
/* 260 */         if (!agg_isNull23) {
/* 261 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value26);
/* 262 */         } else {
/* 263 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 264 */         }
/* 265 */
/* 266 */         if (!agg_isNull29) {
/* 267 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value32);
/* 268 */         } else {
/* 269 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 270 */         }
/* 271 */
/* 272 */       }
/* 273 */       if (shouldStop()) return;
/* 274 */     }
/* 275 */
/* 276 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 277 */   }
/* 278 */
/* 279 */   private void wholestagecodegen_init_1() {
/* 280 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 5);
/* 281 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 282 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 283 */
/* 284 */   }
/* 285 */
/* 286 */   protected void processNext() throws java.io.IOException {
/* 287 */     if (!agg_initAgg) {
/* 288 */       agg_initAgg = true;
/* 289 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 290 */       agg_doAggregateWithKeys();
/* 291 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 292 */     }
/* 293 */
/* 294 */     // output the result
/* 295 */
/* 296 */     while (agg_mapIter.next()) {
/* 297 */       wholestagecodegen_numOutputRows.add(1);
/* 298 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 299 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 300 */
/* 301 */       boolean agg_isNull35 = agg_aggKey.isNullAt(0);
/* 302 */       int agg_value38 = agg_isNull35 ? -1 : (agg_aggKey.getInt(0));
/* 303 */       boolean agg_isNull36 = agg_aggKey.isNullAt(1);
/* 304 */       int agg_value39 = agg_isNull36 ? -1 : (agg_aggKey.getInt(1));
/* 305 */       boolean agg_isNull37 = agg_aggKey.isNullAt(2);
/* 306 */       int agg_value40 = agg_isNull37 ? -1 : (agg_aggKey.getInt(2));
/* 307 */       boolean agg_isNull38 = agg_aggBuffer.isNullAt(0);
/* 308 */       long agg_value41 = agg_isNull38 ? -1L : (agg_aggBuffer.getLong(0));
/* 309 */       boolean agg_isNull39 = agg_aggBuffer.isNullAt(1);
/* 310 */       double agg_value42 = agg_isNull39 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 311 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(2);
/* 312 */       double agg_value43 = agg_isNull40 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 313 */
/* 314 */       boolean filter_isNull = false;
/* 315 */
/* 316 */       boolean filter_isNull1 = agg_isNull38;
/* 317 */       long filter_value1 = agg_value41;
/* 318 */       if (filter_isNull1) {
/* 319 */         if (!false) {
/* 320 */           filter_isNull1 = false;
/* 321 */           filter_value1 = 0L;
/* 322 */         }
/* 323 */       }
/* 324 */
/* 325 */       boolean filter_value = false;
/* 326 */       filter_value = filter_value1 > 0L;
/* 327 */       if (!filter_value) continue;
/* 328 */
/* 329 */       filter_numOutputRows.add(1);
/* 330 */
/* 331 */       filter_rowWriter.zeroOutNullBytes();
/* 332 */
/* 333 */       if (agg_isNull35) {
/* 334 */         filter_rowWriter.setNullAt(0);
/* 335 */       } else {
/* 336 */         filter_rowWriter.write(0, agg_value38);
/* 337 */       }
/* 338 */
/* 339 */       if (agg_isNull37) {
/* 340 */         filter_rowWriter.setNullAt(1);
/* 341 */       } else {
/* 342 */         filter_rowWriter.write(1, agg_value40);
/* 343 */       }
/* 344 */
/* 345 */       if (agg_isNull38) {
/* 346 */         filter_rowWriter.setNullAt(2);
/* 347 */       } else {
/* 348 */         filter_rowWriter.write(2, agg_value41);
/* 349 */       }
/* 350 */
/* 351 */       if (agg_isNull39) {
/* 352 */         filter_rowWriter.setNullAt(3);
/* 353 */       } else {
/* 354 */         filter_rowWriter.write(3, agg_value42);
/* 355 */       }
/* 356 */
/* 357 */       if (agg_isNull40) {
/* 358 */         filter_rowWriter.setNullAt(4);
/* 359 */       } else {
/* 360 */         filter_rowWriter.write(4, agg_value43);
/* 361 */       }
/* 362 */       append(filter_result);
/* 363 */
/* 364 */       if (shouldStop()) return;
/* 365 */     }
/* 366 */
/* 367 */     agg_mapIter.close();
/* 368 */     if (agg_sorter == null) {
/* 369 */       agg_hashMap.free();
/* 370 */     }
/* 371 */   }
/* 372 */ }
