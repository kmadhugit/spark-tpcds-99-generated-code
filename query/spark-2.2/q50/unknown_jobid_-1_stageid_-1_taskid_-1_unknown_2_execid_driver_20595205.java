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
/* 019 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 020 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 021 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 023 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 024 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 025 */   private scala.collection.Iterator inputadapter_input;
/* 026 */   private UnsafeRow agg_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 029 */   private int agg_value30;
/* 030 */   private UnsafeRow agg_result1;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
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
/* 043 */     agg_initAgg = false;
/* 044 */
/* 045 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 046 */
/* 047 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 048 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 049 */     inputadapter_input = inputs[0];
/* 050 */     agg_result = new UnsafeRow(10);
/* 051 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 288);
/* 052 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 10);
/* 053 */
/* 054 */     agg_result1 = new UnsafeRow(15);
/* 055 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 288);
/* 056 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 15);
/* 057 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 058 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 059 */
/* 060 */   }
/* 061 */
/* 062 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 063 */     agg_hashMap = agg_plan.createHashMap();
/* 064 */
/* 065 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 066 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 067 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 068 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 069 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 070 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 071 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 072 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 073 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 074 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 075 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 076 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 077 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 078 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 079 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 080 */       UTF8String inputadapter_value6 = inputadapter_isNull6 ? null : (inputadapter_row.getUTF8String(6));
/* 081 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 082 */       UTF8String inputadapter_value7 = inputadapter_isNull7 ? null : (inputadapter_row.getUTF8String(7));
/* 083 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 084 */       UTF8String inputadapter_value8 = inputadapter_isNull8 ? null : (inputadapter_row.getUTF8String(8));
/* 085 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 086 */       UTF8String inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getUTF8String(9));
/* 087 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 088 */       long inputadapter_value10 = inputadapter_isNull10 ? -1L : (inputadapter_row.getLong(10));
/* 089 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 090 */       long inputadapter_value11 = inputadapter_isNull11 ? -1L : (inputadapter_row.getLong(11));
/* 091 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 092 */       long inputadapter_value12 = inputadapter_isNull12 ? -1L : (inputadapter_row.getLong(12));
/* 093 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 094 */       long inputadapter_value13 = inputadapter_isNull13 ? -1L : (inputadapter_row.getLong(13));
/* 095 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 096 */       long inputadapter_value14 = inputadapter_isNull14 ? -1L : (inputadapter_row.getLong(14));
/* 097 */
/* 098 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 099 */
/* 100 */       UnsafeRow agg_fastAggBuffer = null;
/* 101 */
/* 102 */       if (agg_fastAggBuffer == null) {
/* 103 */         // generate grouping key
/* 104 */         agg_holder.reset();
/* 105 */
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
/* 125 */
/* 126 */         if (inputadapter_isNull3) {
/* 127 */           agg_rowWriter.setNullAt(3);
/* 128 */         } else {
/* 129 */           agg_rowWriter.write(3, inputadapter_value3);
/* 130 */         }
/* 131 */
/* 132 */         if (inputadapter_isNull4) {
/* 133 */           agg_rowWriter.setNullAt(4);
/* 134 */         } else {
/* 135 */           agg_rowWriter.write(4, inputadapter_value4);
/* 136 */         }
/* 137 */
/* 138 */         if (inputadapter_isNull5) {
/* 139 */           agg_rowWriter.setNullAt(5);
/* 140 */         } else {
/* 141 */           agg_rowWriter.write(5, inputadapter_value5);
/* 142 */         }
/* 143 */
/* 144 */         if (inputadapter_isNull6) {
/* 145 */           agg_rowWriter.setNullAt(6);
/* 146 */         } else {
/* 147 */           agg_rowWriter.write(6, inputadapter_value6);
/* 148 */         }
/* 149 */
/* 150 */         if (inputadapter_isNull7) {
/* 151 */           agg_rowWriter.setNullAt(7);
/* 152 */         } else {
/* 153 */           agg_rowWriter.write(7, inputadapter_value7);
/* 154 */         }
/* 155 */
/* 156 */         if (inputadapter_isNull8) {
/* 157 */           agg_rowWriter.setNullAt(8);
/* 158 */         } else {
/* 159 */           agg_rowWriter.write(8, inputadapter_value8);
/* 160 */         }
/* 161 */
/* 162 */         if (inputadapter_isNull9) {
/* 163 */           agg_rowWriter.setNullAt(9);
/* 164 */         } else {
/* 165 */           agg_rowWriter.write(9, inputadapter_value9);
/* 166 */         }
/* 167 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 168 */         agg_value30 = 42;
/* 169 */
/* 170 */         if (!inputadapter_isNull) {
/* 171 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value30);
/* 172 */         }
/* 173 */
/* 174 */         if (!inputadapter_isNull1) {
/* 175 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value30);
/* 176 */         }
/* 177 */
/* 178 */         if (!inputadapter_isNull2) {
/* 179 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value30);
/* 180 */         }
/* 181 */
/* 182 */         if (!inputadapter_isNull3) {
/* 183 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value30);
/* 184 */         }
/* 185 */
/* 186 */         if (!inputadapter_isNull4) {
/* 187 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value30);
/* 188 */         }
/* 189 */
/* 190 */         if (!inputadapter_isNull5) {
/* 191 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value30);
/* 192 */         }
/* 193 */
/* 194 */         if (!inputadapter_isNull6) {
/* 195 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value30);
/* 196 */         }
/* 197 */
/* 198 */         if (!inputadapter_isNull7) {
/* 199 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value7.getBaseObject(), inputadapter_value7.getBaseOffset(), inputadapter_value7.numBytes(), agg_value30);
/* 200 */         }
/* 201 */
/* 202 */         if (!inputadapter_isNull8) {
/* 203 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value8.getBaseObject(), inputadapter_value8.getBaseOffset(), inputadapter_value8.numBytes(), agg_value30);
/* 204 */         }
/* 205 */
/* 206 */         if (!inputadapter_isNull9) {
/* 207 */           agg_value30 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value9.getBaseObject(), inputadapter_value9.getBaseOffset(), inputadapter_value9.numBytes(), agg_value30);
/* 208 */         }
/* 209 */         if (true) {
/* 210 */           // try to get the buffer from hash map
/* 211 */           agg_unsafeRowAggBuffer =
/* 212 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value30);
/* 213 */         }
/* 214 */         if (agg_unsafeRowAggBuffer == null) {
/* 215 */           if (agg_sorter == null) {
/* 216 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 217 */           } else {
/* 218 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 219 */           }
/* 220 */
/* 221 */           // the hash map had be spilled, it should have enough memory now,
/* 222 */           // try  to allocate buffer again.
/* 223 */           agg_unsafeRowAggBuffer =
/* 224 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value30);
/* 225 */           if (agg_unsafeRowAggBuffer == null) {
/* 226 */             // failed to allocate the first page
/* 227 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 228 */           }
/* 229 */         }
/* 230 */       }
/* 231 */
/* 232 */       if (agg_fastAggBuffer != null) {
/* 233 */         // update fast row
/* 234 */
/* 235 */       } else {
/* 236 */         // update unsafe row
/* 237 */
/* 238 */         // common sub-expressions
/* 239 */
/* 240 */         // evaluate aggregate function
/* 241 */         boolean agg_isNull37 = true;
/* 242 */         long agg_value42 = -1L;
/* 243 */
/* 244 */         boolean agg_isNull39 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 245 */         long agg_value44 = agg_isNull39 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 246 */         boolean agg_isNull38 = agg_isNull39;
/* 247 */         long agg_value43 = agg_value44;
/* 248 */         if (agg_isNull38) {
/* 249 */           boolean agg_isNull40 = false;
/* 250 */           long agg_value45 = -1L;
/* 251 */           if (!false) {
/* 252 */             agg_value45 = (long) 0;
/* 253 */           }
/* 254 */           if (!agg_isNull40) {
/* 255 */             agg_isNull38 = false;
/* 256 */             agg_value43 = agg_value45;
/* 257 */           }
/* 258 */         }
/* 259 */
/* 260 */         if (!inputadapter_isNull10) {
/* 261 */           agg_isNull37 = false; // resultCode could change nullability.
/* 262 */           agg_value42 = agg_value43 + inputadapter_value10;
/* 263 */
/* 264 */         }
/* 265 */         boolean agg_isNull36 = agg_isNull37;
/* 266 */         long agg_value41 = agg_value42;
/* 267 */         if (agg_isNull36) {
/* 268 */           boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 269 */           long agg_value48 = agg_isNull43 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 270 */           if (!agg_isNull43) {
/* 271 */             agg_isNull36 = false;
/* 272 */             agg_value41 = agg_value48;
/* 273 */           }
/* 274 */         }
/* 275 */         boolean agg_isNull45 = true;
/* 276 */         long agg_value50 = -1L;
/* 277 */
/* 278 */         boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 279 */         long agg_value52 = agg_isNull47 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 280 */         boolean agg_isNull46 = agg_isNull47;
/* 281 */         long agg_value51 = agg_value52;
/* 282 */         if (agg_isNull46) {
/* 283 */           boolean agg_isNull48 = false;
/* 284 */           long agg_value53 = -1L;
/* 285 */           if (!false) {
/* 286 */             agg_value53 = (long) 0;
/* 287 */           }
/* 288 */           if (!agg_isNull48) {
/* 289 */             agg_isNull46 = false;
/* 290 */             agg_value51 = agg_value53;
/* 291 */           }
/* 292 */         }
/* 293 */
/* 294 */         if (!inputadapter_isNull11) {
/* 295 */           agg_isNull45 = false; // resultCode could change nullability.
/* 296 */           agg_value50 = agg_value51 + inputadapter_value11;
/* 297 */
/* 298 */         }
/* 299 */         boolean agg_isNull44 = agg_isNull45;
/* 300 */         long agg_value49 = agg_value50;
/* 301 */         if (agg_isNull44) {
/* 302 */           boolean agg_isNull51 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 303 */           long agg_value56 = agg_isNull51 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 304 */           if (!agg_isNull51) {
/* 305 */             agg_isNull44 = false;
/* 306 */             agg_value49 = agg_value56;
/* 307 */           }
/* 308 */         }
/* 309 */         boolean agg_isNull53 = true;
/* 310 */         long agg_value58 = -1L;
/* 311 */
/* 312 */         boolean agg_isNull55 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 313 */         long agg_value60 = agg_isNull55 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 314 */         boolean agg_isNull54 = agg_isNull55;
/* 315 */         long agg_value59 = agg_value60;
/* 316 */         if (agg_isNull54) {
/* 317 */           boolean agg_isNull56 = false;
/* 318 */           long agg_value61 = -1L;
/* 319 */           if (!false) {
/* 320 */             agg_value61 = (long) 0;
/* 321 */           }
/* 322 */           if (!agg_isNull56) {
/* 323 */             agg_isNull54 = false;
/* 324 */             agg_value59 = agg_value61;
/* 325 */           }
/* 326 */         }
/* 327 */
/* 328 */         if (!inputadapter_isNull12) {
/* 329 */           agg_isNull53 = false; // resultCode could change nullability.
/* 330 */           agg_value58 = agg_value59 + inputadapter_value12;
/* 331 */
/* 332 */         }
/* 333 */         boolean agg_isNull52 = agg_isNull53;
/* 334 */         long agg_value57 = agg_value58;
/* 335 */         if (agg_isNull52) {
/* 336 */           boolean agg_isNull59 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 337 */           long agg_value64 = agg_isNull59 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 338 */           if (!agg_isNull59) {
/* 339 */             agg_isNull52 = false;
/* 340 */             agg_value57 = agg_value64;
/* 341 */           }
/* 342 */         }
/* 343 */         boolean agg_isNull61 = true;
/* 344 */         long agg_value66 = -1L;
/* 345 */
/* 346 */         boolean agg_isNull63 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 347 */         long agg_value68 = agg_isNull63 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 348 */         boolean agg_isNull62 = agg_isNull63;
/* 349 */         long agg_value67 = agg_value68;
/* 350 */         if (agg_isNull62) {
/* 351 */           boolean agg_isNull64 = false;
/* 352 */           long agg_value69 = -1L;
/* 353 */           if (!false) {
/* 354 */             agg_value69 = (long) 0;
/* 355 */           }
/* 356 */           if (!agg_isNull64) {
/* 357 */             agg_isNull62 = false;
/* 358 */             agg_value67 = agg_value69;
/* 359 */           }
/* 360 */         }
/* 361 */
/* 362 */         if (!inputadapter_isNull13) {
/* 363 */           agg_isNull61 = false; // resultCode could change nullability.
/* 364 */           agg_value66 = agg_value67 + inputadapter_value13;
/* 365 */
/* 366 */         }
/* 367 */         boolean agg_isNull60 = agg_isNull61;
/* 368 */         long agg_value65 = agg_value66;
/* 369 */         if (agg_isNull60) {
/* 370 */           boolean agg_isNull67 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 371 */           long agg_value72 = agg_isNull67 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 372 */           if (!agg_isNull67) {
/* 373 */             agg_isNull60 = false;
/* 374 */             agg_value65 = agg_value72;
/* 375 */           }
/* 376 */         }
/* 377 */         boolean agg_isNull69 = true;
/* 378 */         long agg_value74 = -1L;
/* 379 */
/* 380 */         boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 381 */         long agg_value76 = agg_isNull71 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 382 */         boolean agg_isNull70 = agg_isNull71;
/* 383 */         long agg_value75 = agg_value76;
/* 384 */         if (agg_isNull70) {
/* 385 */           boolean agg_isNull72 = false;
/* 386 */           long agg_value77 = -1L;
/* 387 */           if (!false) {
/* 388 */             agg_value77 = (long) 0;
/* 389 */           }
/* 390 */           if (!agg_isNull72) {
/* 391 */             agg_isNull70 = false;
/* 392 */             agg_value75 = agg_value77;
/* 393 */           }
/* 394 */         }
/* 395 */
/* 396 */         if (!inputadapter_isNull14) {
/* 397 */           agg_isNull69 = false; // resultCode could change nullability.
/* 398 */           agg_value74 = agg_value75 + inputadapter_value14;
/* 399 */
/* 400 */         }
/* 401 */         boolean agg_isNull68 = agg_isNull69;
/* 402 */         long agg_value73 = agg_value74;
/* 403 */         if (agg_isNull68) {
/* 404 */           boolean agg_isNull75 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 405 */           long agg_value80 = agg_isNull75 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 406 */           if (!agg_isNull75) {
/* 407 */             agg_isNull68 = false;
/* 408 */             agg_value73 = agg_value80;
/* 409 */           }
/* 410 */         }
/* 411 */         // update unsafe row buffer
/* 412 */         if (!agg_isNull36) {
/* 413 */           agg_unsafeRowAggBuffer.setLong(0, agg_value41);
/* 414 */         } else {
/* 415 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 416 */         }
/* 417 */
/* 418 */         if (!agg_isNull44) {
/* 419 */           agg_unsafeRowAggBuffer.setLong(1, agg_value49);
/* 420 */         } else {
/* 421 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 422 */         }
/* 423 */
/* 424 */         if (!agg_isNull52) {
/* 425 */           agg_unsafeRowAggBuffer.setLong(2, agg_value57);
/* 426 */         } else {
/* 427 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 428 */         }
/* 429 */
/* 430 */         if (!agg_isNull60) {
/* 431 */           agg_unsafeRowAggBuffer.setLong(3, agg_value65);
/* 432 */         } else {
/* 433 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 434 */         }
/* 435 */
/* 436 */         if (!agg_isNull68) {
/* 437 */           agg_unsafeRowAggBuffer.setLong(4, agg_value73);
/* 438 */         } else {
/* 439 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 440 */         }
/* 441 */
/* 442 */       }
/* 443 */       if (shouldStop()) return;
/* 444 */     }
/* 445 */
/* 446 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 447 */   }
/* 448 */
/* 449 */   protected void processNext() throws java.io.IOException {
/* 450 */     if (!agg_initAgg) {
/* 451 */       agg_initAgg = true;
/* 452 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 453 */       agg_doAggregateWithKeys();
/* 454 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 455 */     }
/* 456 */
/* 457 */     // output the result
/* 458 */
/* 459 */     while (agg_mapIter.next()) {
/* 460 */       wholestagecodegen_numOutputRows.add(1);
/* 461 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 462 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 463 */
/* 464 */       boolean agg_isNull76 = agg_aggKey.isNullAt(0);
/* 465 */       UTF8String agg_value81 = agg_isNull76 ? null : (agg_aggKey.getUTF8String(0));
/* 466 */       boolean agg_isNull77 = agg_aggKey.isNullAt(1);
/* 467 */       int agg_value82 = agg_isNull77 ? -1 : (agg_aggKey.getInt(1));
/* 468 */       boolean agg_isNull78 = agg_aggKey.isNullAt(2);
/* 469 */       UTF8String agg_value83 = agg_isNull78 ? null : (agg_aggKey.getUTF8String(2));
/* 470 */       boolean agg_isNull79 = agg_aggKey.isNullAt(3);
/* 471 */       UTF8String agg_value84 = agg_isNull79 ? null : (agg_aggKey.getUTF8String(3));
/* 472 */       boolean agg_isNull80 = agg_aggKey.isNullAt(4);
/* 473 */       UTF8String agg_value85 = agg_isNull80 ? null : (agg_aggKey.getUTF8String(4));
/* 474 */       boolean agg_isNull81 = agg_aggKey.isNullAt(5);
/* 475 */       UTF8String agg_value86 = agg_isNull81 ? null : (agg_aggKey.getUTF8String(5));
/* 476 */       boolean agg_isNull82 = agg_aggKey.isNullAt(6);
/* 477 */       UTF8String agg_value87 = agg_isNull82 ? null : (agg_aggKey.getUTF8String(6));
/* 478 */       boolean agg_isNull83 = agg_aggKey.isNullAt(7);
/* 479 */       UTF8String agg_value88 = agg_isNull83 ? null : (agg_aggKey.getUTF8String(7));
/* 480 */       boolean agg_isNull84 = agg_aggKey.isNullAt(8);
/* 481 */       UTF8String agg_value89 = agg_isNull84 ? null : (agg_aggKey.getUTF8String(8));
/* 482 */       boolean agg_isNull85 = agg_aggKey.isNullAt(9);
/* 483 */       UTF8String agg_value90 = agg_isNull85 ? null : (agg_aggKey.getUTF8String(9));
/* 484 */       boolean agg_isNull86 = agg_aggBuffer.isNullAt(0);
/* 485 */       long agg_value91 = agg_isNull86 ? -1L : (agg_aggBuffer.getLong(0));
/* 486 */       boolean agg_isNull87 = agg_aggBuffer.isNullAt(1);
/* 487 */       long agg_value92 = agg_isNull87 ? -1L : (agg_aggBuffer.getLong(1));
/* 488 */       boolean agg_isNull88 = agg_aggBuffer.isNullAt(2);
/* 489 */       long agg_value93 = agg_isNull88 ? -1L : (agg_aggBuffer.getLong(2));
/* 490 */       boolean agg_isNull89 = agg_aggBuffer.isNullAt(3);
/* 491 */       long agg_value94 = agg_isNull89 ? -1L : (agg_aggBuffer.getLong(3));
/* 492 */       boolean agg_isNull90 = agg_aggBuffer.isNullAt(4);
/* 493 */       long agg_value95 = agg_isNull90 ? -1L : (agg_aggBuffer.getLong(4));
/* 494 */
/* 495 */       agg_holder1.reset();
/* 496 */
/* 497 */       agg_rowWriter1.zeroOutNullBytes();
/* 498 */
/* 499 */       if (agg_isNull76) {
/* 500 */         agg_rowWriter1.setNullAt(0);
/* 501 */       } else {
/* 502 */         agg_rowWriter1.write(0, agg_value81);
/* 503 */       }
/* 504 */
/* 505 */       if (agg_isNull77) {
/* 506 */         agg_rowWriter1.setNullAt(1);
/* 507 */       } else {
/* 508 */         agg_rowWriter1.write(1, agg_value82);
/* 509 */       }
/* 510 */
/* 511 */       if (agg_isNull78) {
/* 512 */         agg_rowWriter1.setNullAt(2);
/* 513 */       } else {
/* 514 */         agg_rowWriter1.write(2, agg_value83);
/* 515 */       }
/* 516 */
/* 517 */       if (agg_isNull79) {
/* 518 */         agg_rowWriter1.setNullAt(3);
/* 519 */       } else {
/* 520 */         agg_rowWriter1.write(3, agg_value84);
/* 521 */       }
/* 522 */
/* 523 */       if (agg_isNull80) {
/* 524 */         agg_rowWriter1.setNullAt(4);
/* 525 */       } else {
/* 526 */         agg_rowWriter1.write(4, agg_value85);
/* 527 */       }
/* 528 */
/* 529 */       if (agg_isNull81) {
/* 530 */         agg_rowWriter1.setNullAt(5);
/* 531 */       } else {
/* 532 */         agg_rowWriter1.write(5, agg_value86);
/* 533 */       }
/* 534 */
/* 535 */       if (agg_isNull82) {
/* 536 */         agg_rowWriter1.setNullAt(6);
/* 537 */       } else {
/* 538 */         agg_rowWriter1.write(6, agg_value87);
/* 539 */       }
/* 540 */
/* 541 */       if (agg_isNull83) {
/* 542 */         agg_rowWriter1.setNullAt(7);
/* 543 */       } else {
/* 544 */         agg_rowWriter1.write(7, agg_value88);
/* 545 */       }
/* 546 */
/* 547 */       if (agg_isNull84) {
/* 548 */         agg_rowWriter1.setNullAt(8);
/* 549 */       } else {
/* 550 */         agg_rowWriter1.write(8, agg_value89);
/* 551 */       }
/* 552 */
/* 553 */       if (agg_isNull85) {
/* 554 */         agg_rowWriter1.setNullAt(9);
/* 555 */       } else {
/* 556 */         agg_rowWriter1.write(9, agg_value90);
/* 557 */       }
/* 558 */
/* 559 */       if (agg_isNull86) {
/* 560 */         agg_rowWriter1.setNullAt(10);
/* 561 */       } else {
/* 562 */         agg_rowWriter1.write(10, agg_value91);
/* 563 */       }
/* 564 */
/* 565 */       if (agg_isNull87) {
/* 566 */         agg_rowWriter1.setNullAt(11);
/* 567 */       } else {
/* 568 */         agg_rowWriter1.write(11, agg_value92);
/* 569 */       }
/* 570 */
/* 571 */       if (agg_isNull88) {
/* 572 */         agg_rowWriter1.setNullAt(12);
/* 573 */       } else {
/* 574 */         agg_rowWriter1.write(12, agg_value93);
/* 575 */       }
/* 576 */
/* 577 */       if (agg_isNull89) {
/* 578 */         agg_rowWriter1.setNullAt(13);
/* 579 */       } else {
/* 580 */         agg_rowWriter1.write(13, agg_value94);
/* 581 */       }
/* 582 */
/* 583 */       if (agg_isNull90) {
/* 584 */         agg_rowWriter1.setNullAt(14);
/* 585 */       } else {
/* 586 */         agg_rowWriter1.write(14, agg_value95);
/* 587 */       }
/* 588 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 589 */       append(agg_result1);
/* 590 */
/* 591 */       if (shouldStop()) return;
/* 592 */     }
/* 593 */
/* 594 */     agg_mapIter.close();
/* 595 */     if (agg_sorter == null) {
/* 596 */       agg_hashMap.free();
/* 597 */     }
/* 598 */   }
/* 599 */ }
