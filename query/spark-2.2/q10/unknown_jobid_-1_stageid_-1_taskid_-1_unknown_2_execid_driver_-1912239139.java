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
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private long agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 022 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 023 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 024 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 027 */   private scala.collection.Iterator inputadapter_input;
/* 028 */   private UnsafeRow agg_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 031 */   private int agg_value28;
/* 032 */   private UnsafeRow agg_result1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 037 */
/* 038 */   public GeneratedIterator(Object[] references) {
/* 039 */     this.references = references;
/* 040 */   }
/* 041 */
/* 042 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 043 */     partitionIndex = index;
/* 044 */     this.inputs = inputs;
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(8);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 8);
/* 055 */
/* 056 */     agg_result1 = new UnsafeRow(14);
/* 057 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 058 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 14);
/* 059 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 061 */
/* 062 */   }
/* 063 */
/* 064 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 065 */     agg_hashMap = agg_plan.createHashMap();
/* 066 */
/* 067 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 068 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 069 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 070 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 071 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 072 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 073 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 074 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 075 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 076 */       int inputadapter_value3 = inputadapter_isNull3 ? -1 : (inputadapter_row.getInt(3));
/* 077 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 078 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 079 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 080 */       int inputadapter_value5 = inputadapter_isNull5 ? -1 : (inputadapter_row.getInt(5));
/* 081 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 082 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 083 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 084 */       int inputadapter_value7 = inputadapter_isNull7 ? -1 : (inputadapter_row.getInt(7));
/* 085 */       long inputadapter_value8 = inputadapter_row.getLong(8);
/* 086 */       long inputadapter_value9 = inputadapter_row.getLong(9);
/* 087 */       long inputadapter_value10 = inputadapter_row.getLong(10);
/* 088 */       long inputadapter_value11 = inputadapter_row.getLong(11);
/* 089 */       long inputadapter_value12 = inputadapter_row.getLong(12);
/* 090 */       long inputadapter_value13 = inputadapter_row.getLong(13);
/* 091 */
/* 092 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 093 */
/* 094 */       UnsafeRow agg_fastAggBuffer = null;
/* 095 */
/* 096 */       if (agg_fastAggBuffer == null) {
/* 097 */         // generate grouping key
/* 098 */         agg_holder.reset();
/* 099 */
/* 100 */         agg_rowWriter.zeroOutNullBytes();
/* 101 */
/* 102 */         if (inputadapter_isNull) {
/* 103 */           agg_rowWriter.setNullAt(0);
/* 104 */         } else {
/* 105 */           agg_rowWriter.write(0, inputadapter_value);
/* 106 */         }
/* 107 */
/* 108 */         if (inputadapter_isNull1) {
/* 109 */           agg_rowWriter.setNullAt(1);
/* 110 */         } else {
/* 111 */           agg_rowWriter.write(1, inputadapter_value1);
/* 112 */         }
/* 113 */
/* 114 */         if (inputadapter_isNull2) {
/* 115 */           agg_rowWriter.setNullAt(2);
/* 116 */         } else {
/* 117 */           agg_rowWriter.write(2, inputadapter_value2);
/* 118 */         }
/* 119 */
/* 120 */         if (inputadapter_isNull3) {
/* 121 */           agg_rowWriter.setNullAt(3);
/* 122 */         } else {
/* 123 */           agg_rowWriter.write(3, inputadapter_value3);
/* 124 */         }
/* 125 */
/* 126 */         if (inputadapter_isNull4) {
/* 127 */           agg_rowWriter.setNullAt(4);
/* 128 */         } else {
/* 129 */           agg_rowWriter.write(4, inputadapter_value4);
/* 130 */         }
/* 131 */
/* 132 */         if (inputadapter_isNull5) {
/* 133 */           agg_rowWriter.setNullAt(5);
/* 134 */         } else {
/* 135 */           agg_rowWriter.write(5, inputadapter_value5);
/* 136 */         }
/* 137 */
/* 138 */         if (inputadapter_isNull6) {
/* 139 */           agg_rowWriter.setNullAt(6);
/* 140 */         } else {
/* 141 */           agg_rowWriter.write(6, inputadapter_value6);
/* 142 */         }
/* 143 */
/* 144 */         if (inputadapter_isNull7) {
/* 145 */           agg_rowWriter.setNullAt(7);
/* 146 */         } else {
/* 147 */           agg_rowWriter.write(7, inputadapter_value7);
/* 148 */         }
/* 149 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 150 */         agg_value28 = 42;
/* 151 */
/* 152 */         if (!inputadapter_isNull) {
/* 153 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value28);
/* 154 */         }
/* 155 */
/* 156 */         if (!inputadapter_isNull1) {
/* 157 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value28);
/* 158 */         }
/* 159 */
/* 160 */         if (!inputadapter_isNull2) {
/* 161 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value28);
/* 162 */         }
/* 163 */
/* 164 */         if (!inputadapter_isNull3) {
/* 165 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value3, agg_value28);
/* 166 */         }
/* 167 */
/* 168 */         if (!inputadapter_isNull4) {
/* 169 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value28);
/* 170 */         }
/* 171 */
/* 172 */         if (!inputadapter_isNull5) {
/* 173 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value5, agg_value28);
/* 174 */         }
/* 175 */
/* 176 */         if (!inputadapter_isNull6) {
/* 177 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value6, agg_value28);
/* 178 */         }
/* 179 */
/* 180 */         if (!inputadapter_isNull7) {
/* 181 */           agg_value28 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value7, agg_value28);
/* 182 */         }
/* 183 */         if (true) {
/* 184 */           // try to get the buffer from hash map
/* 185 */           agg_unsafeRowAggBuffer =
/* 186 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value28);
/* 187 */         }
/* 188 */         if (agg_unsafeRowAggBuffer == null) {
/* 189 */           if (agg_sorter == null) {
/* 190 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 191 */           } else {
/* 192 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 193 */           }
/* 194 */
/* 195 */           // the hash map had be spilled, it should have enough memory now,
/* 196 */           // try  to allocate buffer again.
/* 197 */           agg_unsafeRowAggBuffer =
/* 198 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value28);
/* 199 */           if (agg_unsafeRowAggBuffer == null) {
/* 200 */             // failed to allocate the first page
/* 201 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 202 */           }
/* 203 */         }
/* 204 */       }
/* 205 */
/* 206 */       if (agg_fastAggBuffer != null) {
/* 207 */         // update fast row
/* 208 */
/* 209 */       } else {
/* 210 */         // update unsafe row
/* 211 */
/* 212 */         // common sub-expressions
/* 213 */
/* 214 */         // evaluate aggregate function
/* 215 */         boolean agg_isNull31 = false;
/* 216 */
/* 217 */         long agg_value38 = agg_unsafeRowAggBuffer.getLong(0);
/* 218 */
/* 219 */         long agg_value37 = -1L;
/* 220 */         agg_value37 = agg_value38 + inputadapter_value8;
/* 221 */         boolean agg_isNull34 = false;
/* 222 */
/* 223 */         long agg_value41 = agg_unsafeRowAggBuffer.getLong(1);
/* 224 */
/* 225 */         long agg_value40 = -1L;
/* 226 */         agg_value40 = agg_value41 + inputadapter_value9;
/* 227 */         boolean agg_isNull37 = false;
/* 228 */
/* 229 */         long agg_value44 = agg_unsafeRowAggBuffer.getLong(2);
/* 230 */
/* 231 */         long agg_value43 = -1L;
/* 232 */         agg_value43 = agg_value44 + inputadapter_value10;
/* 233 */         boolean agg_isNull40 = false;
/* 234 */
/* 235 */         long agg_value47 = agg_unsafeRowAggBuffer.getLong(3);
/* 236 */
/* 237 */         long agg_value46 = -1L;
/* 238 */         agg_value46 = agg_value47 + inputadapter_value11;
/* 239 */         boolean agg_isNull43 = false;
/* 240 */
/* 241 */         long agg_value50 = agg_unsafeRowAggBuffer.getLong(4);
/* 242 */
/* 243 */         long agg_value49 = -1L;
/* 244 */         agg_value49 = agg_value50 + inputadapter_value12;
/* 245 */         boolean agg_isNull46 = false;
/* 246 */
/* 247 */         long agg_value53 = agg_unsafeRowAggBuffer.getLong(5);
/* 248 */
/* 249 */         long agg_value52 = -1L;
/* 250 */         agg_value52 = agg_value53 + inputadapter_value13;
/* 251 */         // update unsafe row buffer
/* 252 */         agg_unsafeRowAggBuffer.setLong(0, agg_value37);
/* 253 */         agg_unsafeRowAggBuffer.setLong(1, agg_value40);
/* 254 */         agg_unsafeRowAggBuffer.setLong(2, agg_value43);
/* 255 */         agg_unsafeRowAggBuffer.setLong(3, agg_value46);
/* 256 */         agg_unsafeRowAggBuffer.setLong(4, agg_value49);
/* 257 */         agg_unsafeRowAggBuffer.setLong(5, agg_value52);
/* 258 */
/* 259 */       }
/* 260 */       if (shouldStop()) return;
/* 261 */     }
/* 262 */
/* 263 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 264 */   }
/* 265 */
/* 266 */   protected void processNext() throws java.io.IOException {
/* 267 */     if (!agg_initAgg) {
/* 268 */       agg_initAgg = true;
/* 269 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 270 */       agg_doAggregateWithKeys();
/* 271 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 272 */     }
/* 273 */
/* 274 */     // output the result
/* 275 */
/* 276 */     while (agg_mapIter.next()) {
/* 277 */       wholestagecodegen_numOutputRows.add(1);
/* 278 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 279 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 280 */
/* 281 */       boolean agg_isNull49 = agg_aggKey.isNullAt(0);
/* 282 */       UTF8String agg_value55 = agg_isNull49 ? null : (agg_aggKey.getUTF8String(0));
/* 283 */       boolean agg_isNull50 = agg_aggKey.isNullAt(1);
/* 284 */       UTF8String agg_value56 = agg_isNull50 ? null : (agg_aggKey.getUTF8String(1));
/* 285 */       boolean agg_isNull51 = agg_aggKey.isNullAt(2);
/* 286 */       UTF8String agg_value57 = agg_isNull51 ? null : (agg_aggKey.getUTF8String(2));
/* 287 */       boolean agg_isNull52 = agg_aggKey.isNullAt(3);
/* 288 */       int agg_value58 = agg_isNull52 ? -1 : (agg_aggKey.getInt(3));
/* 289 */       boolean agg_isNull53 = agg_aggKey.isNullAt(4);
/* 290 */       UTF8String agg_value59 = agg_isNull53 ? null : (agg_aggKey.getUTF8String(4));
/* 291 */       boolean agg_isNull54 = agg_aggKey.isNullAt(5);
/* 292 */       int agg_value60 = agg_isNull54 ? -1 : (agg_aggKey.getInt(5));
/* 293 */       boolean agg_isNull55 = agg_aggKey.isNullAt(6);
/* 294 */       int agg_value61 = agg_isNull55 ? -1 : (agg_aggKey.getInt(6));
/* 295 */       boolean agg_isNull56 = agg_aggKey.isNullAt(7);
/* 296 */       int agg_value62 = agg_isNull56 ? -1 : (agg_aggKey.getInt(7));
/* 297 */       long agg_value63 = agg_aggBuffer.getLong(0);
/* 298 */       long agg_value64 = agg_aggBuffer.getLong(1);
/* 299 */       long agg_value65 = agg_aggBuffer.getLong(2);
/* 300 */       long agg_value66 = agg_aggBuffer.getLong(3);
/* 301 */       long agg_value67 = agg_aggBuffer.getLong(4);
/* 302 */       long agg_value68 = agg_aggBuffer.getLong(5);
/* 303 */
/* 304 */       agg_holder1.reset();
/* 305 */
/* 306 */       agg_rowWriter1.zeroOutNullBytes();
/* 307 */
/* 308 */       if (agg_isNull49) {
/* 309 */         agg_rowWriter1.setNullAt(0);
/* 310 */       } else {
/* 311 */         agg_rowWriter1.write(0, agg_value55);
/* 312 */       }
/* 313 */
/* 314 */       if (agg_isNull50) {
/* 315 */         agg_rowWriter1.setNullAt(1);
/* 316 */       } else {
/* 317 */         agg_rowWriter1.write(1, agg_value56);
/* 318 */       }
/* 319 */
/* 320 */       if (agg_isNull51) {
/* 321 */         agg_rowWriter1.setNullAt(2);
/* 322 */       } else {
/* 323 */         agg_rowWriter1.write(2, agg_value57);
/* 324 */       }
/* 325 */
/* 326 */       agg_rowWriter1.write(3, agg_value63);
/* 327 */
/* 328 */       if (agg_isNull52) {
/* 329 */         agg_rowWriter1.setNullAt(4);
/* 330 */       } else {
/* 331 */         agg_rowWriter1.write(4, agg_value58);
/* 332 */       }
/* 333 */
/* 334 */       agg_rowWriter1.write(5, agg_value64);
/* 335 */
/* 336 */       if (agg_isNull53) {
/* 337 */         agg_rowWriter1.setNullAt(6);
/* 338 */       } else {
/* 339 */         agg_rowWriter1.write(6, agg_value59);
/* 340 */       }
/* 341 */
/* 342 */       agg_rowWriter1.write(7, agg_value65);
/* 343 */
/* 344 */       if (agg_isNull54) {
/* 345 */         agg_rowWriter1.setNullAt(8);
/* 346 */       } else {
/* 347 */         agg_rowWriter1.write(8, agg_value60);
/* 348 */       }
/* 349 */
/* 350 */       agg_rowWriter1.write(9, agg_value66);
/* 351 */
/* 352 */       if (agg_isNull55) {
/* 353 */         agg_rowWriter1.setNullAt(10);
/* 354 */       } else {
/* 355 */         agg_rowWriter1.write(10, agg_value61);
/* 356 */       }
/* 357 */
/* 358 */       agg_rowWriter1.write(11, agg_value67);
/* 359 */
/* 360 */       if (agg_isNull56) {
/* 361 */         agg_rowWriter1.setNullAt(12);
/* 362 */       } else {
/* 363 */         agg_rowWriter1.write(12, agg_value62);
/* 364 */       }
/* 365 */
/* 366 */       agg_rowWriter1.write(13, agg_value68);
/* 367 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 368 */       append(agg_result1);
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
