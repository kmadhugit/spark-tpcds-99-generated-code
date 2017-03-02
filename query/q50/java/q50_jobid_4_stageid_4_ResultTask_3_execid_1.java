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
/* 065 */     while (inputadapter_input.hasNext()) {
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
/* 239 */         boolean agg_isNull36 = false;
/* 240 */         long agg_value41 = -1L;
/* 241 */         if (!false) {
/* 242 */           agg_value41 = (long) 0;
/* 243 */         }
/* 244 */         // evaluate aggregate function
/* 245 */         boolean agg_isNull39 = true;
/* 246 */         long agg_value44 = -1L;
/* 247 */
/* 248 */         boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 249 */         long agg_value46 = agg_isNull41 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 250 */         boolean agg_isNull40 = agg_isNull41;
/* 251 */         long agg_value45 = agg_value46;
/* 252 */         if (agg_isNull40) {
/* 253 */           if (!agg_isNull36) {
/* 254 */             agg_isNull40 = false;
/* 255 */             agg_value45 = agg_value41;
/* 256 */           }
/* 257 */         }
/* 258 */
/* 259 */         if (!inputadapter_isNull10) {
/* 260 */           agg_isNull39 = false; // resultCode could change nullability.
/* 261 */           agg_value44 = agg_value45 + inputadapter_value10;
/* 262 */
/* 263 */         }
/* 264 */         boolean agg_isNull38 = agg_isNull39;
/* 265 */         long agg_value43 = agg_value44;
/* 266 */         if (agg_isNull38) {
/* 267 */           boolean agg_isNull43 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 268 */           long agg_value48 = agg_isNull43 ? -1L : (agg_unsafeRowAggBuffer.getLong(0));
/* 269 */           if (!agg_isNull43) {
/* 270 */             agg_isNull38 = false;
/* 271 */             agg_value43 = agg_value48;
/* 272 */           }
/* 273 */         }
/* 274 */         boolean agg_isNull45 = true;
/* 275 */         long agg_value50 = -1L;
/* 276 */
/* 277 */         boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 278 */         long agg_value52 = agg_isNull47 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 279 */         boolean agg_isNull46 = agg_isNull47;
/* 280 */         long agg_value51 = agg_value52;
/* 281 */         if (agg_isNull46) {
/* 282 */           if (!agg_isNull36) {
/* 283 */             agg_isNull46 = false;
/* 284 */             agg_value51 = agg_value41;
/* 285 */           }
/* 286 */         }
/* 287 */
/* 288 */         if (!inputadapter_isNull11) {
/* 289 */           agg_isNull45 = false; // resultCode could change nullability.
/* 290 */           agg_value50 = agg_value51 + inputadapter_value11;
/* 291 */
/* 292 */         }
/* 293 */         boolean agg_isNull44 = agg_isNull45;
/* 294 */         long agg_value49 = agg_value50;
/* 295 */         if (agg_isNull44) {
/* 296 */           boolean agg_isNull49 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 297 */           long agg_value54 = agg_isNull49 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 298 */           if (!agg_isNull49) {
/* 299 */             agg_isNull44 = false;
/* 300 */             agg_value49 = agg_value54;
/* 301 */           }
/* 302 */         }
/* 303 */         boolean agg_isNull51 = true;
/* 304 */         long agg_value56 = -1L;
/* 305 */
/* 306 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 307 */         long agg_value58 = agg_isNull53 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 308 */         boolean agg_isNull52 = agg_isNull53;
/* 309 */         long agg_value57 = agg_value58;
/* 310 */         if (agg_isNull52) {
/* 311 */           if (!agg_isNull36) {
/* 312 */             agg_isNull52 = false;
/* 313 */             agg_value57 = agg_value41;
/* 314 */           }
/* 315 */         }
/* 316 */
/* 317 */         if (!inputadapter_isNull12) {
/* 318 */           agg_isNull51 = false; // resultCode could change nullability.
/* 319 */           agg_value56 = agg_value57 + inputadapter_value12;
/* 320 */
/* 321 */         }
/* 322 */         boolean agg_isNull50 = agg_isNull51;
/* 323 */         long agg_value55 = agg_value56;
/* 324 */         if (agg_isNull50) {
/* 325 */           boolean agg_isNull55 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 326 */           long agg_value60 = agg_isNull55 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 327 */           if (!agg_isNull55) {
/* 328 */             agg_isNull50 = false;
/* 329 */             agg_value55 = agg_value60;
/* 330 */           }
/* 331 */         }
/* 332 */         boolean agg_isNull57 = true;
/* 333 */         long agg_value62 = -1L;
/* 334 */
/* 335 */         boolean agg_isNull59 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 336 */         long agg_value64 = agg_isNull59 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 337 */         boolean agg_isNull58 = agg_isNull59;
/* 338 */         long agg_value63 = agg_value64;
/* 339 */         if (agg_isNull58) {
/* 340 */           if (!agg_isNull36) {
/* 341 */             agg_isNull58 = false;
/* 342 */             agg_value63 = agg_value41;
/* 343 */           }
/* 344 */         }
/* 345 */
/* 346 */         if (!inputadapter_isNull13) {
/* 347 */           agg_isNull57 = false; // resultCode could change nullability.
/* 348 */           agg_value62 = agg_value63 + inputadapter_value13;
/* 349 */
/* 350 */         }
/* 351 */         boolean agg_isNull56 = agg_isNull57;
/* 352 */         long agg_value61 = agg_value62;
/* 353 */         if (agg_isNull56) {
/* 354 */           boolean agg_isNull61 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 355 */           long agg_value66 = agg_isNull61 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 356 */           if (!agg_isNull61) {
/* 357 */             agg_isNull56 = false;
/* 358 */             agg_value61 = agg_value66;
/* 359 */           }
/* 360 */         }
/* 361 */         boolean agg_isNull63 = true;
/* 362 */         long agg_value68 = -1L;
/* 363 */
/* 364 */         boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 365 */         long agg_value70 = agg_isNull65 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 366 */         boolean agg_isNull64 = agg_isNull65;
/* 367 */         long agg_value69 = agg_value70;
/* 368 */         if (agg_isNull64) {
/* 369 */           if (!agg_isNull36) {
/* 370 */             agg_isNull64 = false;
/* 371 */             agg_value69 = agg_value41;
/* 372 */           }
/* 373 */         }
/* 374 */
/* 375 */         if (!inputadapter_isNull14) {
/* 376 */           agg_isNull63 = false; // resultCode could change nullability.
/* 377 */           agg_value68 = agg_value69 + inputadapter_value14;
/* 378 */
/* 379 */         }
/* 380 */         boolean agg_isNull62 = agg_isNull63;
/* 381 */         long agg_value67 = agg_value68;
/* 382 */         if (agg_isNull62) {
/* 383 */           boolean agg_isNull67 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 384 */           long agg_value72 = agg_isNull67 ? -1L : (agg_unsafeRowAggBuffer.getLong(4));
/* 385 */           if (!agg_isNull67) {
/* 386 */             agg_isNull62 = false;
/* 387 */             agg_value67 = agg_value72;
/* 388 */           }
/* 389 */         }
/* 390 */         // update unsafe row buffer
/* 391 */         if (!agg_isNull38) {
/* 392 */           agg_unsafeRowAggBuffer.setLong(0, agg_value43);
/* 393 */         } else {
/* 394 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 395 */         }
/* 396 */
/* 397 */         if (!agg_isNull44) {
/* 398 */           agg_unsafeRowAggBuffer.setLong(1, agg_value49);
/* 399 */         } else {
/* 400 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 401 */         }
/* 402 */
/* 403 */         if (!agg_isNull50) {
/* 404 */           agg_unsafeRowAggBuffer.setLong(2, agg_value55);
/* 405 */         } else {
/* 406 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 407 */         }
/* 408 */
/* 409 */         if (!agg_isNull56) {
/* 410 */           agg_unsafeRowAggBuffer.setLong(3, agg_value61);
/* 411 */         } else {
/* 412 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 413 */         }
/* 414 */
/* 415 */         if (!agg_isNull62) {
/* 416 */           agg_unsafeRowAggBuffer.setLong(4, agg_value67);
/* 417 */         } else {
/* 418 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 419 */         }
/* 420 */
/* 421 */       }
/* 422 */       if (shouldStop()) return;
/* 423 */     }
/* 424 */
/* 425 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 426 */   }
/* 427 */
/* 428 */   protected void processNext() throws java.io.IOException {
/* 429 */     if (!agg_initAgg) {
/* 430 */       agg_initAgg = true;
/* 431 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 432 */       agg_doAggregateWithKeys();
/* 433 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 434 */     }
/* 435 */
/* 436 */     // output the result
/* 437 */
/* 438 */     while (agg_mapIter.next()) {
/* 439 */       wholestagecodegen_numOutputRows.add(1);
/* 440 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 441 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 442 */
/* 443 */       boolean agg_isNull68 = agg_aggKey.isNullAt(0);
/* 444 */       UTF8String agg_value73 = agg_isNull68 ? null : (agg_aggKey.getUTF8String(0));
/* 445 */       boolean agg_isNull69 = agg_aggKey.isNullAt(1);
/* 446 */       int agg_value74 = agg_isNull69 ? -1 : (agg_aggKey.getInt(1));
/* 447 */       boolean agg_isNull70 = agg_aggKey.isNullAt(2);
/* 448 */       UTF8String agg_value75 = agg_isNull70 ? null : (agg_aggKey.getUTF8String(2));
/* 449 */       boolean agg_isNull71 = agg_aggKey.isNullAt(3);
/* 450 */       UTF8String agg_value76 = agg_isNull71 ? null : (agg_aggKey.getUTF8String(3));
/* 451 */       boolean agg_isNull72 = agg_aggKey.isNullAt(4);
/* 452 */       UTF8String agg_value77 = agg_isNull72 ? null : (agg_aggKey.getUTF8String(4));
/* 453 */       boolean agg_isNull73 = agg_aggKey.isNullAt(5);
/* 454 */       UTF8String agg_value78 = agg_isNull73 ? null : (agg_aggKey.getUTF8String(5));
/* 455 */       boolean agg_isNull74 = agg_aggKey.isNullAt(6);
/* 456 */       UTF8String agg_value79 = agg_isNull74 ? null : (agg_aggKey.getUTF8String(6));
/* 457 */       boolean agg_isNull75 = agg_aggKey.isNullAt(7);
/* 458 */       UTF8String agg_value80 = agg_isNull75 ? null : (agg_aggKey.getUTF8String(7));
/* 459 */       boolean agg_isNull76 = agg_aggKey.isNullAt(8);
/* 460 */       UTF8String agg_value81 = agg_isNull76 ? null : (agg_aggKey.getUTF8String(8));
/* 461 */       boolean agg_isNull77 = agg_aggKey.isNullAt(9);
/* 462 */       UTF8String agg_value82 = agg_isNull77 ? null : (agg_aggKey.getUTF8String(9));
/* 463 */       boolean agg_isNull78 = agg_aggBuffer.isNullAt(0);
/* 464 */       long agg_value83 = agg_isNull78 ? -1L : (agg_aggBuffer.getLong(0));
/* 465 */       boolean agg_isNull79 = agg_aggBuffer.isNullAt(1);
/* 466 */       long agg_value84 = agg_isNull79 ? -1L : (agg_aggBuffer.getLong(1));
/* 467 */       boolean agg_isNull80 = agg_aggBuffer.isNullAt(2);
/* 468 */       long agg_value85 = agg_isNull80 ? -1L : (agg_aggBuffer.getLong(2));
/* 469 */       boolean agg_isNull81 = agg_aggBuffer.isNullAt(3);
/* 470 */       long agg_value86 = agg_isNull81 ? -1L : (agg_aggBuffer.getLong(3));
/* 471 */       boolean agg_isNull82 = agg_aggBuffer.isNullAt(4);
/* 472 */       long agg_value87 = agg_isNull82 ? -1L : (agg_aggBuffer.getLong(4));
/* 473 */
/* 474 */       agg_holder1.reset();
/* 475 */
/* 476 */       agg_rowWriter1.zeroOutNullBytes();
/* 477 */
/* 478 */       if (agg_isNull68) {
/* 479 */         agg_rowWriter1.setNullAt(0);
/* 480 */       } else {
/* 481 */         agg_rowWriter1.write(0, agg_value73);
/* 482 */       }
/* 483 */
/* 484 */       if (agg_isNull69) {
/* 485 */         agg_rowWriter1.setNullAt(1);
/* 486 */       } else {
/* 487 */         agg_rowWriter1.write(1, agg_value74);
/* 488 */       }
/* 489 */
/* 490 */       if (agg_isNull70) {
/* 491 */         agg_rowWriter1.setNullAt(2);
/* 492 */       } else {
/* 493 */         agg_rowWriter1.write(2, agg_value75);
/* 494 */       }
/* 495 */
/* 496 */       if (agg_isNull71) {
/* 497 */         agg_rowWriter1.setNullAt(3);
/* 498 */       } else {
/* 499 */         agg_rowWriter1.write(3, agg_value76);
/* 500 */       }
/* 501 */
/* 502 */       if (agg_isNull72) {
/* 503 */         agg_rowWriter1.setNullAt(4);
/* 504 */       } else {
/* 505 */         agg_rowWriter1.write(4, agg_value77);
/* 506 */       }
/* 507 */
/* 508 */       if (agg_isNull73) {
/* 509 */         agg_rowWriter1.setNullAt(5);
/* 510 */       } else {
/* 511 */         agg_rowWriter1.write(5, agg_value78);
/* 512 */       }
/* 513 */
/* 514 */       if (agg_isNull74) {
/* 515 */         agg_rowWriter1.setNullAt(6);
/* 516 */       } else {
/* 517 */         agg_rowWriter1.write(6, agg_value79);
/* 518 */       }
/* 519 */
/* 520 */       if (agg_isNull75) {
/* 521 */         agg_rowWriter1.setNullAt(7);
/* 522 */       } else {
/* 523 */         agg_rowWriter1.write(7, agg_value80);
/* 524 */       }
/* 525 */
/* 526 */       if (agg_isNull76) {
/* 527 */         agg_rowWriter1.setNullAt(8);
/* 528 */       } else {
/* 529 */         agg_rowWriter1.write(8, agg_value81);
/* 530 */       }
/* 531 */
/* 532 */       if (agg_isNull77) {
/* 533 */         agg_rowWriter1.setNullAt(9);
/* 534 */       } else {
/* 535 */         agg_rowWriter1.write(9, agg_value82);
/* 536 */       }
/* 537 */
/* 538 */       if (agg_isNull78) {
/* 539 */         agg_rowWriter1.setNullAt(10);
/* 540 */       } else {
/* 541 */         agg_rowWriter1.write(10, agg_value83);
/* 542 */       }
/* 543 */
/* 544 */       if (agg_isNull79) {
/* 545 */         agg_rowWriter1.setNullAt(11);
/* 546 */       } else {
/* 547 */         agg_rowWriter1.write(11, agg_value84);
/* 548 */       }
/* 549 */
/* 550 */       if (agg_isNull80) {
/* 551 */         agg_rowWriter1.setNullAt(12);
/* 552 */       } else {
/* 553 */         agg_rowWriter1.write(12, agg_value85);
/* 554 */       }
/* 555 */
/* 556 */       if (agg_isNull81) {
/* 557 */         agg_rowWriter1.setNullAt(13);
/* 558 */       } else {
/* 559 */         agg_rowWriter1.write(13, agg_value86);
/* 560 */       }
/* 561 */
/* 562 */       if (agg_isNull82) {
/* 563 */         agg_rowWriter1.setNullAt(14);
/* 564 */       } else {
/* 565 */         agg_rowWriter1.write(14, agg_value87);
/* 566 */       }
/* 567 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 568 */       append(agg_result1);
/* 569 */
/* 570 */       if (shouldStop()) return;
/* 571 */     }
/* 572 */
/* 573 */     agg_mapIter.close();
/* 574 */     if (agg_sorter == null) {
/* 575 */       agg_hashMap.free();
/* 576 */     }
/* 577 */   }
/* 578 */ }
