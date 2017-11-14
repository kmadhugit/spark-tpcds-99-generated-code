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
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private long agg_bufValue2;
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
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     agg_initAgg = false;
/* 040 */
/* 041 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 042 */
/* 043 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 044 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 045 */     inputadapter_input = inputs[0];
/* 046 */     agg_result = new UnsafeRow(4);
/* 047 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 048 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 4);
/* 049 */
/* 050 */     agg_result1 = new UnsafeRow(7);
/* 051 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 052 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 7);
/* 053 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 054 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 055 */
/* 056 */   }
/* 057 */
/* 058 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 059 */     agg_hashMap = agg_plan.createHashMap();
/* 060 */
/* 061 */     while (inputadapter_input.hasNext()) {
/* 062 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 063 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 064 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 065 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 066 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 067 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 068 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 069 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 070 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 071 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 072 */       long inputadapter_value4 = inputadapter_isNull4 ? -1L : (inputadapter_row.getLong(4));
/* 073 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 074 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 075 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 076 */       long inputadapter_value6 = inputadapter_isNull6 ? -1L : (inputadapter_row.getLong(6));
/* 077 */
/* 078 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 079 */
/* 080 */       UnsafeRow agg_fastAggBuffer = null;
/* 081 */
/* 082 */       if (agg_fastAggBuffer == null) {
/* 083 */         // generate grouping key
/* 084 */         agg_holder.reset();
/* 085 */
/* 086 */         agg_rowWriter.zeroOutNullBytes();
/* 087 */
/* 088 */         if (inputadapter_isNull) {
/* 089 */           agg_rowWriter.setNullAt(0);
/* 090 */         } else {
/* 091 */           agg_rowWriter.write(0, inputadapter_value);
/* 092 */         }
/* 093 */
/* 094 */         if (inputadapter_isNull1) {
/* 095 */           agg_rowWriter.setNullAt(1);
/* 096 */         } else {
/* 097 */           agg_rowWriter.write(1, inputadapter_value1);
/* 098 */         }
/* 099 */
/* 100 */         if (inputadapter_isNull2) {
/* 101 */           agg_rowWriter.setNullAt(2);
/* 102 */         } else {
/* 103 */           agg_rowWriter.write(2, inputadapter_value2);
/* 104 */         }
/* 105 */
/* 106 */         if (inputadapter_isNull3) {
/* 107 */           agg_rowWriter.setNullAt(3);
/* 108 */         } else {
/* 109 */           agg_rowWriter.write(3, inputadapter_value3);
/* 110 */         }
/* 111 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 112 */         agg_value14 = 42;
/* 113 */
/* 114 */         if (!inputadapter_isNull) {
/* 115 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value14);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull1) {
/* 119 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value14);
/* 120 */         }
/* 121 */
/* 122 */         if (!inputadapter_isNull2) {
/* 123 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value14);
/* 124 */         }
/* 125 */
/* 126 */         if (!inputadapter_isNull3) {
/* 127 */           agg_value14 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value14);
/* 128 */         }
/* 129 */         if (true) {
/* 130 */           // try to get the buffer from hash map
/* 131 */           agg_unsafeRowAggBuffer =
/* 132 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 133 */         }
/* 134 */         if (agg_unsafeRowAggBuffer == null) {
/* 135 */           if (agg_sorter == null) {
/* 136 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 137 */           } else {
/* 138 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 139 */           }
/* 140 */
/* 141 */           // the hash map had be spilled, it should have enough memory now,
/* 142 */           // try  to allocate buffer again.
/* 143 */           agg_unsafeRowAggBuffer =
/* 144 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value14);
/* 145 */           if (agg_unsafeRowAggBuffer == null) {
/* 146 */             // failed to allocate the first page
/* 147 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 148 */           }
/* 149 */         }
/* 150 */       }
/* 151 */
/* 152 */       if (agg_fastAggBuffer != null) {
/* 153 */         // update fast row
/* 154 */
/* 155 */       } else {
/* 156 */         // update unsafe row
/* 157 */
/* 158 */         // common sub-expressions
/* 159 */         boolean agg_isNull16 = false;
/* 160 */         long agg_value19 = -1L;
/* 161 */         if (!false) {
/* 162 */           agg_value19 = (long) 0;
/* 163 */         }
/* 164 */         // evaluate aggregate function
/* 165 */         boolean agg_isNull19 = true;
/* 166 */         long agg_value22 = -1L;
/* 167 */
/* 168 */         boolean agg_isNull21 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 169 */         long agg_value24 = agg_isNull21 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 170 */         boolean agg_isNull20 = agg_isNull21;
/* 171 */         long agg_value23 = agg_value24;
/* 172 */         if (agg_isNull20) {
/* 173 */           if (!agg_isNull16) {
/* 174 */             agg_isNull20 = false;
/* 175 */             agg_value23 = agg_value19;
/* 176 */           }
/* 177 */         }
/* 178 */
/* 179 */         if (!inputadapter_isNull4) {
/* 180 */           agg_isNull19 = false; // resultCode could change nullability.
/* 181 */           agg_value22 = agg_value23 + inputadapter_value4;
/* 182 */
/* 183 */         }
/* 184 */         boolean agg_isNull18 = agg_isNull19;
/* 185 */         long agg_value21 = agg_value22;
/* 186 */         if (agg_isNull18) {
/* 187 */           boolean agg_isNull23 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 188 */           long agg_value26 = agg_isNull23 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 189 */           if (!agg_isNull23) {
/* 190 */             agg_isNull18 = false;
/* 191 */             agg_value21 = agg_value26;
/* 192 */           }
/* 193 */         }
/* 194 */         boolean agg_isNull25 = true;
/* 195 */         long agg_value28 = -1L;
/* 196 */
/* 197 */         boolean agg_isNull27 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 198 */         long agg_value30 = agg_isNull27 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 199 */         boolean agg_isNull26 = agg_isNull27;
/* 200 */         long agg_value29 = agg_value30;
/* 201 */         if (agg_isNull26) {
/* 202 */           if (!agg_isNull16) {
/* 203 */             agg_isNull26 = false;
/* 204 */             agg_value29 = agg_value19;
/* 205 */           }
/* 206 */         }
/* 207 */
/* 208 */         if (!inputadapter_isNull5) {
/* 209 */           agg_isNull25 = false; // resultCode could change nullability.
/* 210 */           agg_value28 = agg_value29 + inputadapter_value5;
/* 211 */
/* 212 */         }
/* 213 */         boolean agg_isNull24 = agg_isNull25;
/* 214 */         long agg_value27 = agg_value28;
/* 215 */         if (agg_isNull24) {
/* 216 */           boolean agg_isNull29 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 217 */           long agg_value32 = agg_isNull29 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 218 */           if (!agg_isNull29) {
/* 219 */             agg_isNull24 = false;
/* 220 */             agg_value27 = agg_value32;
/* 221 */           }
/* 222 */         }
/* 223 */         boolean agg_isNull31 = true;
/* 224 */         long agg_value34 = -1L;
/* 225 */
/* 226 */         boolean agg_isNull33 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 227 */         long agg_value36 = agg_isNull33 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 228 */         boolean agg_isNull32 = agg_isNull33;
/* 229 */         long agg_value35 = agg_value36;
/* 230 */         if (agg_isNull32) {
/* 231 */           if (!agg_isNull16) {
/* 232 */             agg_isNull32 = false;
/* 233 */             agg_value35 = agg_value19;
/* 234 */           }
/* 235 */         }
/* 236 */
/* 237 */         if (!inputadapter_isNull6) {
/* 238 */           agg_isNull31 = false; // resultCode could change nullability.
/* 239 */           agg_value34 = agg_value35 + inputadapter_value6;
/* 240 */
/* 241 */         }
/* 242 */         boolean agg_isNull30 = agg_isNull31;
/* 243 */         long agg_value33 = agg_value34;
/* 244 */         if (agg_isNull30) {
/* 245 */           boolean agg_isNull35 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 246 */           long agg_value38 = agg_isNull35 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 247 */           if (!agg_isNull35) {
/* 248 */             agg_isNull30 = false;
/* 249 */             agg_value33 = agg_value38;
/* 250 */           }
/* 251 */         }
/* 252 */         // update unsafe row buffer
/* 253 */         if (!agg_isNull18) {
/* 254 */           agg_unsafeRowAggBuffer.setLong(0, agg_value21);
/* 255 */         } else {
/* 256 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 257 */         }
/* 258 */
/* 259 */         if (!agg_isNull24) {
/* 260 */           agg_unsafeRowAggBuffer.setLong(1, agg_value27);
/* 261 */         } else {
/* 262 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 263 */         }
/* 264 */
/* 265 */         if (!agg_isNull30) {
/* 266 */           agg_unsafeRowAggBuffer.setLong(2, agg_value33);
/* 267 */         } else {
/* 268 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 269 */         }
/* 270 */
/* 271 */       }
/* 272 */       if (shouldStop()) return;
/* 273 */     }
/* 274 */
/* 275 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 276 */   }
/* 277 */
/* 278 */   protected void processNext() throws java.io.IOException {
/* 279 */     if (!agg_initAgg) {
/* 280 */       agg_initAgg = true;
/* 281 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 282 */       agg_doAggregateWithKeys();
/* 283 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 284 */     }
/* 285 */
/* 286 */     // output the result
/* 287 */
/* 288 */     while (agg_mapIter.next()) {
/* 289 */       wholestagecodegen_numOutputRows.add(1);
/* 290 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 291 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 292 */
/* 293 */       boolean agg_isNull36 = agg_aggKey.isNullAt(0);
/* 294 */       UTF8String agg_value39 = agg_isNull36 ? null : (agg_aggKey.getUTF8String(0));
/* 295 */       boolean agg_isNull37 = agg_aggKey.isNullAt(1);
/* 296 */       UTF8String agg_value40 = agg_isNull37 ? null : (agg_aggKey.getUTF8String(1));
/* 297 */       boolean agg_isNull38 = agg_aggKey.isNullAt(2);
/* 298 */       UTF8String agg_value41 = agg_isNull38 ? null : (agg_aggKey.getUTF8String(2));
/* 299 */       boolean agg_isNull39 = agg_aggKey.isNullAt(3);
/* 300 */       UTF8String agg_value42 = agg_isNull39 ? null : (agg_aggKey.getUTF8String(3));
/* 301 */       boolean agg_isNull40 = agg_aggBuffer.isNullAt(0);
/* 302 */       long agg_value43 = agg_isNull40 ? -1L : (agg_aggBuffer.getLong(0));
/* 303 */       boolean agg_isNull41 = agg_aggBuffer.isNullAt(1);
/* 304 */       long agg_value44 = agg_isNull41 ? -1L : (agg_aggBuffer.getLong(1));
/* 305 */       boolean agg_isNull42 = agg_aggBuffer.isNullAt(2);
/* 306 */       long agg_value45 = agg_isNull42 ? -1L : (agg_aggBuffer.getLong(2));
/* 307 */
/* 308 */       agg_holder1.reset();
/* 309 */
/* 310 */       agg_rowWriter1.zeroOutNullBytes();
/* 311 */
/* 312 */       if (agg_isNull36) {
/* 313 */         agg_rowWriter1.setNullAt(0);
/* 314 */       } else {
/* 315 */         agg_rowWriter1.write(0, agg_value39);
/* 316 */       }
/* 317 */
/* 318 */       if (agg_isNull37) {
/* 319 */         agg_rowWriter1.setNullAt(1);
/* 320 */       } else {
/* 321 */         agg_rowWriter1.write(1, agg_value40);
/* 322 */       }
/* 323 */
/* 324 */       if (agg_isNull38) {
/* 325 */         agg_rowWriter1.setNullAt(2);
/* 326 */       } else {
/* 327 */         agg_rowWriter1.write(2, agg_value41);
/* 328 */       }
/* 329 */
/* 330 */       if (agg_isNull39) {
/* 331 */         agg_rowWriter1.setNullAt(3);
/* 332 */       } else {
/* 333 */         agg_rowWriter1.write(3, agg_value42);
/* 334 */       }
/* 335 */
/* 336 */       if (agg_isNull40) {
/* 337 */         agg_rowWriter1.setNullAt(4);
/* 338 */       } else {
/* 339 */         agg_rowWriter1.write(4, agg_value43);
/* 340 */       }
/* 341 */
/* 342 */       if (agg_isNull41) {
/* 343 */         agg_rowWriter1.setNullAt(5);
/* 344 */       } else {
/* 345 */         agg_rowWriter1.write(5, agg_value44);
/* 346 */       }
/* 347 */
/* 348 */       if (agg_isNull42) {
/* 349 */         agg_rowWriter1.setNullAt(6);
/* 350 */       } else {
/* 351 */         agg_rowWriter1.write(6, agg_value45);
/* 352 */       }
/* 353 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 354 */       append(agg_result1);
/* 355 */
/* 356 */       if (shouldStop()) return;
/* 357 */     }
/* 358 */
/* 359 */     agg_mapIter.close();
/* 360 */     if (agg_sorter == null) {
/* 361 */       agg_hashMap.free();
/* 362 */     }
/* 363 */   }
/* 364 */ }
