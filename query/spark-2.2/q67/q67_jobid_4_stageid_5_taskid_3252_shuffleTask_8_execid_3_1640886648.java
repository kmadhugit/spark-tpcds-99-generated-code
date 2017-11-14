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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value20;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */
/* 039 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     agg_result = new UnsafeRow(9);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 160);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 9);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(9);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 160);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 9);
/* 049 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 050 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 055 */     agg_hashMap = agg_plan.createHashMap();
/* 056 */
/* 057 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 058 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 059 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 060 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 061 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 062 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 063 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 064 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 065 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 066 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 067 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 068 */       int inputadapter_value4 = inputadapter_isNull4 ? -1 : (inputadapter_row.getInt(4));
/* 069 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 070 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 071 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 072 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 073 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 074 */       UTF8String inputadapter_value7 = inputadapter_isNull7 ? null : (inputadapter_row.getUTF8String(7));
/* 075 */       int inputadapter_value8 = inputadapter_row.getInt(8);
/* 076 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 077 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 078 */
/* 079 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 080 */
/* 081 */       UnsafeRow agg_fastAggBuffer = null;
/* 082 */
/* 083 */       if (agg_fastAggBuffer == null) {
/* 084 */         // generate grouping key
/* 085 */         agg_holder.reset();
/* 086 */
/* 087 */         agg_rowWriter.zeroOutNullBytes();
/* 088 */
/* 089 */         if (inputadapter_isNull) {
/* 090 */           agg_rowWriter.setNullAt(0);
/* 091 */         } else {
/* 092 */           agg_rowWriter.write(0, inputadapter_value);
/* 093 */         }
/* 094 */
/* 095 */         if (inputadapter_isNull1) {
/* 096 */           agg_rowWriter.setNullAt(1);
/* 097 */         } else {
/* 098 */           agg_rowWriter.write(1, inputadapter_value1);
/* 099 */         }
/* 100 */
/* 101 */         if (inputadapter_isNull2) {
/* 102 */           agg_rowWriter.setNullAt(2);
/* 103 */         } else {
/* 104 */           agg_rowWriter.write(2, inputadapter_value2);
/* 105 */         }
/* 106 */
/* 107 */         if (inputadapter_isNull3) {
/* 108 */           agg_rowWriter.setNullAt(3);
/* 109 */         } else {
/* 110 */           agg_rowWriter.write(3, inputadapter_value3);
/* 111 */         }
/* 112 */
/* 113 */         if (inputadapter_isNull4) {
/* 114 */           agg_rowWriter.setNullAt(4);
/* 115 */         } else {
/* 116 */           agg_rowWriter.write(4, inputadapter_value4);
/* 117 */         }
/* 118 */
/* 119 */         if (inputadapter_isNull5) {
/* 120 */           agg_rowWriter.setNullAt(5);
/* 121 */         } else {
/* 122 */           agg_rowWriter.write(5, inputadapter_value5);
/* 123 */         }
/* 124 */
/* 125 */         if (inputadapter_isNull6) {
/* 126 */           agg_rowWriter.setNullAt(6);
/* 127 */         } else {
/* 128 */           agg_rowWriter.write(6, inputadapter_value6);
/* 129 */         }
/* 130 */
/* 131 */         if (inputadapter_isNull7) {
/* 132 */           agg_rowWriter.setNullAt(7);
/* 133 */         } else {
/* 134 */           agg_rowWriter.write(7, inputadapter_value7);
/* 135 */         }
/* 136 */
/* 137 */         agg_rowWriter.write(8, inputadapter_value8);
/* 138 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 139 */         agg_value20 = 42;
/* 140 */
/* 141 */         if (!inputadapter_isNull) {
/* 142 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value20);
/* 143 */         }
/* 144 */
/* 145 */         if (!inputadapter_isNull1) {
/* 146 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value20);
/* 147 */         }
/* 148 */
/* 149 */         if (!inputadapter_isNull2) {
/* 150 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value20);
/* 151 */         }
/* 152 */
/* 153 */         if (!inputadapter_isNull3) {
/* 154 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value20);
/* 155 */         }
/* 156 */
/* 157 */         if (!inputadapter_isNull4) {
/* 158 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value20);
/* 159 */         }
/* 160 */
/* 161 */         if (!inputadapter_isNull5) {
/* 162 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value5, agg_value20);
/* 163 */         }
/* 164 */
/* 165 */         if (!inputadapter_isNull6) {
/* 166 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value6, agg_value20);
/* 167 */         }
/* 168 */
/* 169 */         if (!inputadapter_isNull7) {
/* 170 */           agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value7.getBaseObject(), inputadapter_value7.getBaseOffset(), inputadapter_value7.numBytes(), agg_value20);
/* 171 */         }
/* 172 */
/* 173 */         agg_value20 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value8, agg_value20);
/* 174 */         if (true) {
/* 175 */           // try to get the buffer from hash map
/* 176 */           agg_unsafeRowAggBuffer =
/* 177 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value20);
/* 178 */         }
/* 179 */         if (agg_unsafeRowAggBuffer == null) {
/* 180 */           if (agg_sorter == null) {
/* 181 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 182 */           } else {
/* 183 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 184 */           }
/* 185 */
/* 186 */           // the hash map had be spilled, it should have enough memory now,
/* 187 */           // try  to allocate buffer again.
/* 188 */           agg_unsafeRowAggBuffer =
/* 189 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value20);
/* 190 */           if (agg_unsafeRowAggBuffer == null) {
/* 191 */             // failed to allocate the first page
/* 192 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 193 */           }
/* 194 */         }
/* 195 */       }
/* 196 */
/* 197 */       if (agg_fastAggBuffer != null) {
/* 198 */         // update fast row
/* 199 */
/* 200 */       } else {
/* 201 */         // update unsafe row
/* 202 */
/* 203 */         // common sub-expressions
/* 204 */
/* 205 */         // evaluate aggregate function
/* 206 */         boolean agg_isNull30 = true;
/* 207 */         double agg_value31 = -1.0;
/* 208 */
/* 209 */         boolean agg_isNull32 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 210 */         double agg_value33 = agg_isNull32 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 211 */         boolean agg_isNull31 = agg_isNull32;
/* 212 */         double agg_value32 = agg_value33;
/* 213 */         if (agg_isNull31) {
/* 214 */           boolean agg_isNull33 = false;
/* 215 */           double agg_value34 = -1.0;
/* 216 */           if (!false) {
/* 217 */             agg_value34 = (double) 0;
/* 218 */           }
/* 219 */           if (!agg_isNull33) {
/* 220 */             agg_isNull31 = false;
/* 221 */             agg_value32 = agg_value34;
/* 222 */           }
/* 223 */         }
/* 224 */
/* 225 */         if (!inputadapter_isNull9) {
/* 226 */           agg_isNull30 = false; // resultCode could change nullability.
/* 227 */           agg_value31 = agg_value32 + inputadapter_value9;
/* 228 */
/* 229 */         }
/* 230 */         boolean agg_isNull29 = agg_isNull30;
/* 231 */         double agg_value30 = agg_value31;
/* 232 */         if (agg_isNull29) {
/* 233 */           boolean agg_isNull36 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 234 */           double agg_value37 = agg_isNull36 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 235 */           if (!agg_isNull36) {
/* 236 */             agg_isNull29 = false;
/* 237 */             agg_value30 = agg_value37;
/* 238 */           }
/* 239 */         }
/* 240 */         // update unsafe row buffer
/* 241 */         if (!agg_isNull29) {
/* 242 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value30);
/* 243 */         } else {
/* 244 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 245 */         }
/* 246 */
/* 247 */       }
/* 248 */       if (shouldStop()) return;
/* 249 */     }
/* 250 */
/* 251 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 252 */   }
/* 253 */
/* 254 */   protected void processNext() throws java.io.IOException {
/* 255 */     if (!agg_initAgg) {
/* 256 */       agg_initAgg = true;
/* 257 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 258 */       agg_doAggregateWithKeys();
/* 259 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 260 */     }
/* 261 */
/* 262 */     // output the result
/* 263 */
/* 264 */     while (agg_mapIter.next()) {
/* 265 */       wholestagecodegen_numOutputRows.add(1);
/* 266 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 267 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 268 */
/* 269 */       boolean agg_isNull37 = agg_aggKey.isNullAt(0);
/* 270 */       UTF8String agg_value38 = agg_isNull37 ? null : (agg_aggKey.getUTF8String(0));
/* 271 */       boolean agg_isNull38 = agg_aggKey.isNullAt(1);
/* 272 */       UTF8String agg_value39 = agg_isNull38 ? null : (agg_aggKey.getUTF8String(1));
/* 273 */       boolean agg_isNull39 = agg_aggKey.isNullAt(2);
/* 274 */       UTF8String agg_value40 = agg_isNull39 ? null : (agg_aggKey.getUTF8String(2));
/* 275 */       boolean agg_isNull40 = agg_aggKey.isNullAt(3);
/* 276 */       UTF8String agg_value41 = agg_isNull40 ? null : (agg_aggKey.getUTF8String(3));
/* 277 */       boolean agg_isNull41 = agg_aggKey.isNullAt(4);
/* 278 */       int agg_value42 = agg_isNull41 ? -1 : (agg_aggKey.getInt(4));
/* 279 */       boolean agg_isNull42 = agg_aggKey.isNullAt(5);
/* 280 */       int agg_value43 = agg_isNull42 ? -1 : (agg_aggKey.getInt(5));
/* 281 */       boolean agg_isNull43 = agg_aggKey.isNullAt(6);
/* 282 */       int agg_value44 = agg_isNull43 ? -1 : (agg_aggKey.getInt(6));
/* 283 */       boolean agg_isNull44 = agg_aggKey.isNullAt(7);
/* 284 */       UTF8String agg_value45 = agg_isNull44 ? null : (agg_aggKey.getUTF8String(7));
/* 285 */       int agg_value46 = agg_aggKey.getInt(8);
/* 286 */       boolean agg_isNull46 = agg_aggBuffer.isNullAt(0);
/* 287 */       double agg_value47 = agg_isNull46 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 288 */
/* 289 */       agg_holder1.reset();
/* 290 */
/* 291 */       agg_rowWriter1.zeroOutNullBytes();
/* 292 */
/* 293 */       if (agg_isNull37) {
/* 294 */         agg_rowWriter1.setNullAt(0);
/* 295 */       } else {
/* 296 */         agg_rowWriter1.write(0, agg_value38);
/* 297 */       }
/* 298 */
/* 299 */       if (agg_isNull38) {
/* 300 */         agg_rowWriter1.setNullAt(1);
/* 301 */       } else {
/* 302 */         agg_rowWriter1.write(1, agg_value39);
/* 303 */       }
/* 304 */
/* 305 */       if (agg_isNull39) {
/* 306 */         agg_rowWriter1.setNullAt(2);
/* 307 */       } else {
/* 308 */         agg_rowWriter1.write(2, agg_value40);
/* 309 */       }
/* 310 */
/* 311 */       if (agg_isNull40) {
/* 312 */         agg_rowWriter1.setNullAt(3);
/* 313 */       } else {
/* 314 */         agg_rowWriter1.write(3, agg_value41);
/* 315 */       }
/* 316 */
/* 317 */       if (agg_isNull41) {
/* 318 */         agg_rowWriter1.setNullAt(4);
/* 319 */       } else {
/* 320 */         agg_rowWriter1.write(4, agg_value42);
/* 321 */       }
/* 322 */
/* 323 */       if (agg_isNull42) {
/* 324 */         agg_rowWriter1.setNullAt(5);
/* 325 */       } else {
/* 326 */         agg_rowWriter1.write(5, agg_value43);
/* 327 */       }
/* 328 */
/* 329 */       if (agg_isNull43) {
/* 330 */         agg_rowWriter1.setNullAt(6);
/* 331 */       } else {
/* 332 */         agg_rowWriter1.write(6, agg_value44);
/* 333 */       }
/* 334 */
/* 335 */       if (agg_isNull44) {
/* 336 */         agg_rowWriter1.setNullAt(7);
/* 337 */       } else {
/* 338 */         agg_rowWriter1.write(7, agg_value45);
/* 339 */       }
/* 340 */
/* 341 */       if (agg_isNull46) {
/* 342 */         agg_rowWriter1.setNullAt(8);
/* 343 */       } else {
/* 344 */         agg_rowWriter1.write(8, agg_value47);
/* 345 */       }
/* 346 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 347 */       append(agg_result1);
/* 348 */
/* 349 */       if (shouldStop()) return;
/* 350 */     }
/* 351 */
/* 352 */     agg_mapIter.close();
/* 353 */     if (agg_sorter == null) {
/* 354 */       agg_hashMap.free();
/* 355 */     }
/* 356 */   }
/* 357 */ }
