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
/* 023 */   private int agg_value16;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 029 */
/* 030 */   public GeneratedIterator(Object[] references) {
/* 031 */     this.references = references;
/* 032 */   }
/* 033 */
/* 034 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 035 */     partitionIndex = index;
/* 036 */     this.inputs = inputs;
/* 037 */     agg_initAgg = false;
/* 038 */
/* 039 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 040 */
/* 041 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 042 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 043 */     inputadapter_input = inputs[0];
/* 044 */     agg_result = new UnsafeRow(6);
/* 045 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 046 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 6);
/* 047 */
/* 048 */     agg_result1 = new UnsafeRow(8);
/* 049 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 050 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 8);
/* 051 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 052 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 053 */
/* 054 */   }
/* 055 */
/* 056 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 057 */     agg_hashMap = agg_plan.createHashMap();
/* 058 */
/* 059 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 060 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 061 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 062 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 063 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 064 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 065 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 066 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 067 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 068 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 069 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 070 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 071 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 072 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 073 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 074 */       double inputadapter_value6 = inputadapter_isNull6 ? -1.0 : (inputadapter_row.getDouble(6));
/* 075 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 076 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
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
/* 111 */
/* 112 */         if (inputadapter_isNull4) {
/* 113 */           agg_rowWriter.setNullAt(4);
/* 114 */         } else {
/* 115 */           agg_rowWriter.write(4, inputadapter_value4);
/* 116 */         }
/* 117 */
/* 118 */         if (inputadapter_isNull5) {
/* 119 */           agg_rowWriter.setNullAt(5);
/* 120 */         } else {
/* 121 */           agg_rowWriter.write(5, inputadapter_value5);
/* 122 */         }
/* 123 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 124 */         agg_value16 = 42;
/* 125 */
/* 126 */         if (!inputadapter_isNull) {
/* 127 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value16);
/* 128 */         }
/* 129 */
/* 130 */         if (!inputadapter_isNull1) {
/* 131 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value16);
/* 132 */         }
/* 133 */
/* 134 */         if (!inputadapter_isNull2) {
/* 135 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value16);
/* 136 */         }
/* 137 */
/* 138 */         if (!inputadapter_isNull3) {
/* 139 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value16);
/* 140 */         }
/* 141 */
/* 142 */         if (!inputadapter_isNull4) {
/* 143 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value16);
/* 144 */         }
/* 145 */
/* 146 */         if (!inputadapter_isNull5) {
/* 147 */           agg_value16 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value5, agg_value16);
/* 148 */         }
/* 149 */         if (true) {
/* 150 */           // try to get the buffer from hash map
/* 151 */           agg_unsafeRowAggBuffer =
/* 152 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 153 */         }
/* 154 */         if (agg_unsafeRowAggBuffer == null) {
/* 155 */           if (agg_sorter == null) {
/* 156 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 157 */           } else {
/* 158 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 159 */           }
/* 160 */
/* 161 */           // the hash map had be spilled, it should have enough memory now,
/* 162 */           // try  to allocate buffer again.
/* 163 */           agg_unsafeRowAggBuffer =
/* 164 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value16);
/* 165 */           if (agg_unsafeRowAggBuffer == null) {
/* 166 */             // failed to allocate the first page
/* 167 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 168 */           }
/* 169 */         }
/* 170 */       }
/* 171 */
/* 172 */       if (agg_fastAggBuffer != null) {
/* 173 */         // update fast row
/* 174 */
/* 175 */       } else {
/* 176 */         // update unsafe row
/* 177 */
/* 178 */         // common sub-expressions
/* 179 */
/* 180 */         // evaluate aggregate function
/* 181 */         boolean agg_isNull22 = true;
/* 182 */         double agg_value24 = -1.0;
/* 183 */
/* 184 */         boolean agg_isNull24 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 185 */         double agg_value26 = agg_isNull24 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 186 */         boolean agg_isNull23 = agg_isNull24;
/* 187 */         double agg_value25 = agg_value26;
/* 188 */         if (agg_isNull23) {
/* 189 */           boolean agg_isNull25 = false;
/* 190 */           double agg_value27 = -1.0;
/* 191 */           if (!false) {
/* 192 */             agg_value27 = (double) 0;
/* 193 */           }
/* 194 */           if (!agg_isNull25) {
/* 195 */             agg_isNull23 = false;
/* 196 */             agg_value25 = agg_value27;
/* 197 */           }
/* 198 */         }
/* 199 */
/* 200 */         if (!inputadapter_isNull6) {
/* 201 */           agg_isNull22 = false; // resultCode could change nullability.
/* 202 */           agg_value24 = agg_value25 + inputadapter_value6;
/* 203 */
/* 204 */         }
/* 205 */         boolean agg_isNull21 = agg_isNull22;
/* 206 */         double agg_value23 = agg_value24;
/* 207 */         if (agg_isNull21) {
/* 208 */           boolean agg_isNull28 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 209 */           double agg_value30 = agg_isNull28 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 210 */           if (!agg_isNull28) {
/* 211 */             agg_isNull21 = false;
/* 212 */             agg_value23 = agg_value30;
/* 213 */           }
/* 214 */         }
/* 215 */         boolean agg_isNull30 = true;
/* 216 */         double agg_value32 = -1.0;
/* 217 */
/* 218 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 219 */         double agg_value34 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 220 */         boolean agg_isNull31 = agg_isNull32;
/* 221 */         double agg_value33 = agg_value34;
/* 222 */         if (agg_isNull31) {
/* 223 */           boolean agg_isNull33 = false;
/* 224 */           double agg_value35 = -1.0;
/* 225 */           if (!false) {
/* 226 */             agg_value35 = (double) 0;
/* 227 */           }
/* 228 */           if (!agg_isNull33) {
/* 229 */             agg_isNull31 = false;
/* 230 */             agg_value33 = agg_value35;
/* 231 */           }
/* 232 */         }
/* 233 */
/* 234 */         if (!inputadapter_isNull7) {
/* 235 */           agg_isNull30 = false; // resultCode could change nullability.
/* 236 */           agg_value32 = agg_value33 + inputadapter_value7;
/* 237 */
/* 238 */         }
/* 239 */         boolean agg_isNull29 = agg_isNull30;
/* 240 */         double agg_value31 = agg_value32;
/* 241 */         if (agg_isNull29) {
/* 242 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 243 */           double agg_value38 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 244 */           if (!agg_isNull36) {
/* 245 */             agg_isNull29 = false;
/* 246 */             agg_value31 = agg_value38;
/* 247 */           }
/* 248 */         }
/* 249 */         // update unsafe row buffer
/* 250 */         if (!agg_isNull21) {
/* 251 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value23);
/* 252 */         } else {
/* 253 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 254 */         }
/* 255 */
/* 256 */         if (!agg_isNull29) {
/* 257 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value31);
/* 258 */         } else {
/* 259 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 260 */         }
/* 261 */
/* 262 */       }
/* 263 */       if (shouldStop()) return;
/* 264 */     }
/* 265 */
/* 266 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
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
/* 284 */       boolean agg_isNull37 = agg_aggKey.isNullAt(0);
/* 285 */       UTF8String agg_value39 = agg_isNull37 ? null : (agg_aggKey.getUTF8String(0));
/* 286 */       boolean agg_isNull38 = agg_aggKey.isNullAt(1);
/* 287 */       UTF8String agg_value40 = agg_isNull38 ? null : (agg_aggKey.getUTF8String(1));
/* 288 */       boolean agg_isNull39 = agg_aggKey.isNullAt(2);
/* 289 */       UTF8String agg_value41 = agg_isNull39 ? null : (agg_aggKey.getUTF8String(2));
/* 290 */       boolean agg_isNull40 = agg_aggKey.isNullAt(3);
/* 291 */       UTF8String agg_value42 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(3));
/* 292 */       boolean agg_isNull41 = agg_aggKey.isNullAt(4);
/* 293 */       int agg_value43 = agg_isNull41 ? -1 : (agg_aggKey.getInt(4));
/* 294 */       boolean agg_isNull42 = agg_aggKey.isNullAt(5);
/* 295 */       int agg_value44 = agg_isNull42 ? -1 : (agg_aggKey.getInt(5));
/* 296 */       boolean agg_isNull43 = agg_aggBuffer.isNullAt(0);
/* 297 */       double agg_value45 = agg_isNull43 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 298 */       boolean agg_isNull44 = agg_aggBuffer.isNullAt(1);
/* 299 */       double agg_value46 = agg_isNull44 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 300 */
/* 301 */       agg_holder1.reset();
/* 302 */
/* 303 */       agg_rowWriter1.zeroOutNullBytes();
/* 304 */
/* 305 */       if (agg_isNull37) {
/* 306 */         agg_rowWriter1.setNullAt(0);
/* 307 */       } else {
/* 308 */         agg_rowWriter1.write(0, agg_value39);
/* 309 */       }
/* 310 */
/* 311 */       if (agg_isNull38) {
/* 312 */         agg_rowWriter1.setNullAt(1);
/* 313 */       } else {
/* 314 */         agg_rowWriter1.write(1, agg_value40);
/* 315 */       }
/* 316 */
/* 317 */       if (agg_isNull39) {
/* 318 */         agg_rowWriter1.setNullAt(2);
/* 319 */       } else {
/* 320 */         agg_rowWriter1.write(2, agg_value41);
/* 321 */       }
/* 322 */
/* 323 */       if (agg_isNull40) {
/* 324 */         agg_rowWriter1.setNullAt(3);
/* 325 */       } else {
/* 326 */         agg_rowWriter1.write(3, agg_value42);
/* 327 */       }
/* 328 */
/* 329 */       if (agg_isNull41) {
/* 330 */         agg_rowWriter1.setNullAt(4);
/* 331 */       } else {
/* 332 */         agg_rowWriter1.write(4, agg_value43);
/* 333 */       }
/* 334 */
/* 335 */       if (agg_isNull42) {
/* 336 */         agg_rowWriter1.setNullAt(5);
/* 337 */       } else {
/* 338 */         agg_rowWriter1.write(5, agg_value44);
/* 339 */       }
/* 340 */
/* 341 */       if (agg_isNull43) {
/* 342 */         agg_rowWriter1.setNullAt(6);
/* 343 */       } else {
/* 344 */         agg_rowWriter1.write(6, agg_value45);
/* 345 */       }
/* 346 */
/* 347 */       if (agg_isNull44) {
/* 348 */         agg_rowWriter1.setNullAt(7);
/* 349 */       } else {
/* 350 */         agg_rowWriter1.write(7, agg_value46);
/* 351 */       }
/* 352 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 353 */       append(agg_result1);
/* 354 */
/* 355 */       if (shouldStop()) return;
/* 356 */     }
/* 357 */
/* 358 */     agg_mapIter.close();
/* 359 */     if (agg_sorter == null) {
/* 360 */       agg_hashMap.free();
/* 361 */     }
/* 362 */   }
/* 363 */ }
