/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private boolean agg_bufIsNull;
/* 010 */   private Decimal agg_bufValue;
/* 011 */   private boolean agg_bufIsNull1;
/* 012 */   private long agg_bufValue1;
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private Decimal agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private long agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private Decimal agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private long agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private Decimal agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private long agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private Decimal agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private long agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private Decimal agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private long agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private Decimal agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private long agg_bufValue13;
/* 037 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 038 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 039 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 040 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 041 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 042 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 043 */   private scala.collection.Iterator inputadapter_input;
/* 044 */   private UnsafeRow agg_result;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 046 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 047 */   private int agg_value45;
/* 048 */   private UnsafeRow agg_result1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 052 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 053 */
/* 054 */   public GeneratedIterator(Object[] references) {
/* 055 */     this.references = references;
/* 056 */   }
/* 057 */
/* 058 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 059 */     partitionIndex = index;
/* 060 */     this.inputs = inputs;
/* 061 */     agg_initAgg = false;
/* 062 */
/* 063 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 064 */
/* 065 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 066 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 067 */     inputadapter_input = inputs[0];
/* 068 */     agg_result = new UnsafeRow(5);
/* 069 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 128);
/* 070 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 5);
/* 071 */
/* 072 */     agg_result1 = new UnsafeRow(11);
/* 073 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 128);
/* 074 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 11);
/* 075 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 076 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 077 */
/* 078 */   }
/* 079 */
/* 080 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 081 */     agg_hashMap = agg_plan.createHashMap();
/* 082 */
/* 083 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 084 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 085 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 086 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 087 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 088 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 089 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 090 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 091 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 092 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 093 */       int inputadapter_value4 = inputadapter_row.getInt(4);
/* 094 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 095 */       Decimal inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getDecimal(5, 22, 2));
/* 096 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 097 */       long inputadapter_value6 = inputadapter_isNull6 ? -1L : (inputadapter_row.getLong(6));
/* 098 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 099 */       Decimal inputadapter_value7 = inputadapter_isNull7 ? null : (inputadapter_row.getDecimal(7, 22, 2));
/* 100 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 101 */       long inputadapter_value8 = inputadapter_isNull8 ? -1L : (inputadapter_row.getLong(8));
/* 102 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 103 */       Decimal inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getDecimal(9, 22, 2));
/* 104 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 105 */       long inputadapter_value10 = inputadapter_isNull10 ? -1L : (inputadapter_row.getLong(10));
/* 106 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 107 */       Decimal inputadapter_value11 = inputadapter_isNull11 ? null : (inputadapter_row.getDecimal(11, 22, 2));
/* 108 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 109 */       long inputadapter_value12 = inputadapter_isNull12 ? -1L : (inputadapter_row.getLong(12));
/* 110 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 111 */       Decimal inputadapter_value13 = inputadapter_isNull13 ? null : (inputadapter_row.getDecimal(13, 22, 2));
/* 112 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 113 */       long inputadapter_value14 = inputadapter_isNull14 ? -1L : (inputadapter_row.getLong(14));
/* 114 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 115 */       Decimal inputadapter_value15 = inputadapter_isNull15 ? null : (inputadapter_row.getDecimal(15, 22, 2));
/* 116 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 117 */       long inputadapter_value16 = inputadapter_isNull16 ? -1L : (inputadapter_row.getLong(16));
/* 118 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 119 */       Decimal inputadapter_value17 = inputadapter_isNull17 ? null : (inputadapter_row.getDecimal(17, 22, 2));
/* 120 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 121 */       long inputadapter_value18 = inputadapter_isNull18 ? -1L : (inputadapter_row.getLong(18));
/* 122 */
/* 123 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 124 */
/* 125 */       UnsafeRow agg_fastAggBuffer = null;
/* 126 */
/* 127 */       if (agg_fastAggBuffer == null) {
/* 128 */         // generate grouping key
/* 129 */         agg_holder.reset();
/* 130 */
/* 131 */         agg_rowWriter.zeroOutNullBytes();
/* 132 */
/* 133 */         if (inputadapter_isNull) {
/* 134 */           agg_rowWriter.setNullAt(0);
/* 135 */         } else {
/* 136 */           agg_rowWriter.write(0, inputadapter_value);
/* 137 */         }
/* 138 */
/* 139 */         if (inputadapter_isNull1) {
/* 140 */           agg_rowWriter.setNullAt(1);
/* 141 */         } else {
/* 142 */           agg_rowWriter.write(1, inputadapter_value1);
/* 143 */         }
/* 144 */
/* 145 */         if (inputadapter_isNull2) {
/* 146 */           agg_rowWriter.setNullAt(2);
/* 147 */         } else {
/* 148 */           agg_rowWriter.write(2, inputadapter_value2);
/* 149 */         }
/* 150 */
/* 151 */         if (inputadapter_isNull3) {
/* 152 */           agg_rowWriter.setNullAt(3);
/* 153 */         } else {
/* 154 */           agg_rowWriter.write(3, inputadapter_value3);
/* 155 */         }
/* 156 */
/* 157 */         agg_rowWriter.write(4, inputadapter_value4);
/* 158 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 159 */         agg_value45 = 42;
/* 160 */
/* 161 */         if (!inputadapter_isNull) {
/* 162 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value45);
/* 163 */         }
/* 164 */
/* 165 */         if (!inputadapter_isNull1) {
/* 166 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value45);
/* 167 */         }
/* 168 */
/* 169 */         if (!inputadapter_isNull2) {
/* 170 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value45);
/* 171 */         }
/* 172 */
/* 173 */         if (!inputadapter_isNull3) {
/* 174 */           agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value45);
/* 175 */         }
/* 176 */
/* 177 */         agg_value45 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value4, agg_value45);
/* 178 */         if (true) {
/* 179 */           // try to get the buffer from hash map
/* 180 */           agg_unsafeRowAggBuffer =
/* 181 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value45);
/* 182 */         }
/* 183 */         if (agg_unsafeRowAggBuffer == null) {
/* 184 */           if (agg_sorter == null) {
/* 185 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 186 */           } else {
/* 187 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 188 */           }
/* 189 */
/* 190 */           // the hash map had be spilled, it should have enough memory now,
/* 191 */           // try  to allocate buffer again.
/* 192 */           agg_unsafeRowAggBuffer =
/* 193 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value45);
/* 194 */           if (agg_unsafeRowAggBuffer == null) {
/* 195 */             // failed to allocate the first page
/* 196 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 197 */           }
/* 198 */         }
/* 199 */       }
/* 200 */
/* 201 */       if (agg_fastAggBuffer != null) {
/* 202 */         // update fast row
/* 203 */
/* 204 */       } else {
/* 205 */         // update unsafe row
/* 206 */
/* 207 */         // common sub-expressions
/* 208 */
/* 209 */         // evaluate aggregate function
/* 210 */         boolean agg_isNull37 = true;
/* 211 */         Decimal agg_value51 = null;
/* 212 */
/* 213 */         boolean agg_isNull38 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 214 */         Decimal agg_value52 = agg_isNull38 ? null : (agg_unsafeRowAggBuffer.getDecimal(0, 22, 2));
/* 215 */         if (!agg_isNull38) {
/* 216 */           if (!inputadapter_isNull5) {
/* 217 */             agg_isNull37 = false; // resultCode could change nullability.
/* 218 */             agg_value51 = agg_value52.$plus(inputadapter_value5);
/* 219 */
/* 220 */           }
/* 221 */
/* 222 */         }
/* 223 */         boolean agg_isNull40 = true;
/* 224 */         long agg_value54 = -1L;
/* 225 */
/* 226 */         boolean agg_isNull41 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 227 */         long agg_value55 = agg_isNull41 ? -1L : (agg_unsafeRowAggBuffer.getLong(1));
/* 228 */         if (!agg_isNull41) {
/* 229 */           if (!inputadapter_isNull6) {
/* 230 */             agg_isNull40 = false; // resultCode could change nullability.
/* 231 */             agg_value54 = agg_value55 + inputadapter_value6;
/* 232 */
/* 233 */           }
/* 234 */
/* 235 */         }
/* 236 */         boolean agg_isNull43 = true;
/* 237 */         Decimal agg_value57 = null;
/* 238 */
/* 239 */         boolean agg_isNull44 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 240 */         Decimal agg_value58 = agg_isNull44 ? null : (agg_unsafeRowAggBuffer.getDecimal(2, 22, 2));
/* 241 */         if (!agg_isNull44) {
/* 242 */           if (!inputadapter_isNull7) {
/* 243 */             agg_isNull43 = false; // resultCode could change nullability.
/* 244 */             agg_value57 = agg_value58.$plus(inputadapter_value7);
/* 245 */
/* 246 */           }
/* 247 */
/* 248 */         }
/* 249 */         boolean agg_isNull46 = true;
/* 250 */         long agg_value60 = -1L;
/* 251 */
/* 252 */         boolean agg_isNull47 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 253 */         long agg_value61 = agg_isNull47 ? -1L : (agg_unsafeRowAggBuffer.getLong(3));
/* 254 */         if (!agg_isNull47) {
/* 255 */           if (!inputadapter_isNull8) {
/* 256 */             agg_isNull46 = false; // resultCode could change nullability.
/* 257 */             agg_value60 = agg_value61 + inputadapter_value8;
/* 258 */
/* 259 */           }
/* 260 */
/* 261 */         }
/* 262 */         boolean agg_isNull49 = true;
/* 263 */         Decimal agg_value63 = null;
/* 264 */
/* 265 */         boolean agg_isNull50 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 266 */         Decimal agg_value64 = agg_isNull50 ? null : (agg_unsafeRowAggBuffer.getDecimal(4, 22, 2));
/* 267 */         if (!agg_isNull50) {
/* 268 */           if (!inputadapter_isNull9) {
/* 269 */             agg_isNull49 = false; // resultCode could change nullability.
/* 270 */             agg_value63 = agg_value64.$plus(inputadapter_value9);
/* 271 */
/* 272 */           }
/* 273 */
/* 274 */         }
/* 275 */         boolean agg_isNull52 = true;
/* 276 */         long agg_value66 = -1L;
/* 277 */
/* 278 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 279 */         long agg_value67 = agg_isNull53 ? -1L : (agg_unsafeRowAggBuffer.getLong(5));
/* 280 */         if (!agg_isNull53) {
/* 281 */           if (!inputadapter_isNull10) {
/* 282 */             agg_isNull52 = false; // resultCode could change nullability.
/* 283 */             agg_value66 = agg_value67 + inputadapter_value10;
/* 284 */
/* 285 */           }
/* 286 */
/* 287 */         }
/* 288 */         boolean agg_isNull55 = true;
/* 289 */         Decimal agg_value69 = null;
/* 290 */
/* 291 */         boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 292 */         Decimal agg_value70 = agg_isNull56 ? null : (agg_unsafeRowAggBuffer.getDecimal(6, 22, 2));
/* 293 */         if (!agg_isNull56) {
/* 294 */           if (!inputadapter_isNull11) {
/* 295 */             agg_isNull55 = false; // resultCode could change nullability.
/* 296 */             agg_value69 = agg_value70.$plus(inputadapter_value11);
/* 297 */
/* 298 */           }
/* 299 */
/* 300 */         }
/* 301 */         boolean agg_isNull58 = true;
/* 302 */         long agg_value72 = -1L;
/* 303 */
/* 304 */         boolean agg_isNull59 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 305 */         long agg_value73 = agg_isNull59 ? -1L : (agg_unsafeRowAggBuffer.getLong(7));
/* 306 */         if (!agg_isNull59) {
/* 307 */           if (!inputadapter_isNull12) {
/* 308 */             agg_isNull58 = false; // resultCode could change nullability.
/* 309 */             agg_value72 = agg_value73 + inputadapter_value12;
/* 310 */
/* 311 */           }
/* 312 */
/* 313 */         }
/* 314 */         boolean agg_isNull61 = true;
/* 315 */         Decimal agg_value75 = null;
/* 316 */
/* 317 */         boolean agg_isNull62 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 318 */         Decimal agg_value76 = agg_isNull62 ? null : (agg_unsafeRowAggBuffer.getDecimal(8, 22, 2));
/* 319 */         if (!agg_isNull62) {
/* 320 */           if (!inputadapter_isNull13) {
/* 321 */             agg_isNull61 = false; // resultCode could change nullability.
/* 322 */             agg_value75 = agg_value76.$plus(inputadapter_value13);
/* 323 */
/* 324 */           }
/* 325 */
/* 326 */         }
/* 327 */         boolean agg_isNull64 = true;
/* 328 */         long agg_value78 = -1L;
/* 329 */
/* 330 */         boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 331 */         long agg_value79 = agg_isNull65 ? -1L : (agg_unsafeRowAggBuffer.getLong(9));
/* 332 */         if (!agg_isNull65) {
/* 333 */           if (!inputadapter_isNull14) {
/* 334 */             agg_isNull64 = false; // resultCode could change nullability.
/* 335 */             agg_value78 = agg_value79 + inputadapter_value14;
/* 336 */
/* 337 */           }
/* 338 */
/* 339 */         }
/* 340 */         boolean agg_isNull67 = true;
/* 341 */         Decimal agg_value81 = null;
/* 342 */
/* 343 */         boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 344 */         Decimal agg_value82 = agg_isNull68 ? null : (agg_unsafeRowAggBuffer.getDecimal(10, 22, 2));
/* 345 */         if (!agg_isNull68) {
/* 346 */           if (!inputadapter_isNull15) {
/* 347 */             agg_isNull67 = false; // resultCode could change nullability.
/* 348 */             agg_value81 = agg_value82.$plus(inputadapter_value15);
/* 349 */
/* 350 */           }
/* 351 */
/* 352 */         }
/* 353 */         boolean agg_isNull70 = true;
/* 354 */         long agg_value84 = -1L;
/* 355 */
/* 356 */         boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 357 */         long agg_value85 = agg_isNull71 ? -1L : (agg_unsafeRowAggBuffer.getLong(11));
/* 358 */         if (!agg_isNull71) {
/* 359 */           if (!inputadapter_isNull16) {
/* 360 */             agg_isNull70 = false; // resultCode could change nullability.
/* 361 */             agg_value84 = agg_value85 + inputadapter_value16;
/* 362 */
/* 363 */           }
/* 364 */
/* 365 */         }
/* 366 */         boolean agg_isNull73 = true;
/* 367 */         Decimal agg_value87 = null;
/* 368 */
/* 369 */         boolean agg_isNull74 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 370 */         Decimal agg_value88 = agg_isNull74 ? null : (agg_unsafeRowAggBuffer.getDecimal(12, 22, 2));
/* 371 */         if (!agg_isNull74) {
/* 372 */           if (!inputadapter_isNull17) {
/* 373 */             agg_isNull73 = false; // resultCode could change nullability.
/* 374 */             agg_value87 = agg_value88.$plus(inputadapter_value17);
/* 375 */
/* 376 */           }
/* 377 */
/* 378 */         }
/* 379 */         boolean agg_isNull76 = true;
/* 380 */         long agg_value90 = -1L;
/* 381 */
/* 382 */         boolean agg_isNull77 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 383 */         long agg_value91 = agg_isNull77 ? -1L : (agg_unsafeRowAggBuffer.getLong(13));
/* 384 */         if (!agg_isNull77) {
/* 385 */           if (!inputadapter_isNull18) {
/* 386 */             agg_isNull76 = false; // resultCode could change nullability.
/* 387 */             agg_value90 = agg_value91 + inputadapter_value18;
/* 388 */
/* 389 */           }
/* 390 */
/* 391 */         }
/* 392 */         // update unsafe row buffer
/* 393 */         if (!agg_isNull37) {
/* 394 */           agg_unsafeRowAggBuffer.setDecimal(0, agg_value51, 22);
/* 395 */         } else {
/* 396 */           agg_unsafeRowAggBuffer.setDecimal(0, null, 22);
/* 397 */         }
/* 398 */
/* 399 */         if (!agg_isNull40) {
/* 400 */           agg_unsafeRowAggBuffer.setLong(1, agg_value54);
/* 401 */         } else {
/* 402 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 403 */         }
/* 404 */
/* 405 */         if (!agg_isNull43) {
/* 406 */           agg_unsafeRowAggBuffer.setDecimal(2, agg_value57, 22);
/* 407 */         } else {
/* 408 */           agg_unsafeRowAggBuffer.setDecimal(2, null, 22);
/* 409 */         }
/* 410 */
/* 411 */         if (!agg_isNull46) {
/* 412 */           agg_unsafeRowAggBuffer.setLong(3, agg_value60);
/* 413 */         } else {
/* 414 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 415 */         }
/* 416 */
/* 417 */         if (!agg_isNull49) {
/* 418 */           agg_unsafeRowAggBuffer.setDecimal(4, agg_value63, 22);
/* 419 */         } else {
/* 420 */           agg_unsafeRowAggBuffer.setDecimal(4, null, 22);
/* 421 */         }
/* 422 */
/* 423 */         if (!agg_isNull52) {
/* 424 */           agg_unsafeRowAggBuffer.setLong(5, agg_value66);
/* 425 */         } else {
/* 426 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 427 */         }
/* 428 */
/* 429 */         if (!agg_isNull55) {
/* 430 */           agg_unsafeRowAggBuffer.setDecimal(6, agg_value69, 22);
/* 431 */         } else {
/* 432 */           agg_unsafeRowAggBuffer.setDecimal(6, null, 22);
/* 433 */         }
/* 434 */
/* 435 */         if (!agg_isNull58) {
/* 436 */           agg_unsafeRowAggBuffer.setLong(7, agg_value72);
/* 437 */         } else {
/* 438 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 439 */         }
/* 440 */
/* 441 */         if (!agg_isNull61) {
/* 442 */           agg_unsafeRowAggBuffer.setDecimal(8, agg_value75, 22);
/* 443 */         } else {
/* 444 */           agg_unsafeRowAggBuffer.setDecimal(8, null, 22);
/* 445 */         }
/* 446 */
/* 447 */         if (!agg_isNull64) {
/* 448 */           agg_unsafeRowAggBuffer.setLong(9, agg_value78);
/* 449 */         } else {
/* 450 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 451 */         }
/* 452 */
/* 453 */         if (!agg_isNull67) {
/* 454 */           agg_unsafeRowAggBuffer.setDecimal(10, agg_value81, 22);
/* 455 */         } else {
/* 456 */           agg_unsafeRowAggBuffer.setDecimal(10, null, 22);
/* 457 */         }
/* 458 */
/* 459 */         if (!agg_isNull70) {
/* 460 */           agg_unsafeRowAggBuffer.setLong(11, agg_value84);
/* 461 */         } else {
/* 462 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 463 */         }
/* 464 */
/* 465 */         if (!agg_isNull73) {
/* 466 */           agg_unsafeRowAggBuffer.setDecimal(12, agg_value87, 22);
/* 467 */         } else {
/* 468 */           agg_unsafeRowAggBuffer.setDecimal(12, null, 22);
/* 469 */         }
/* 470 */
/* 471 */         if (!agg_isNull76) {
/* 472 */           agg_unsafeRowAggBuffer.setLong(13, agg_value90);
/* 473 */         } else {
/* 474 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 475 */         }
/* 476 */
/* 477 */       }
/* 478 */       if (shouldStop()) return;
/* 479 */     }
/* 480 */
/* 481 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 482 */   }
/* 483 */
/* 484 */   protected void processNext() throws java.io.IOException {
/* 485 */     if (!agg_initAgg) {
/* 486 */       agg_initAgg = true;
/* 487 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 488 */       agg_doAggregateWithKeys();
/* 489 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 490 */     }
/* 491 */
/* 492 */     // output the result
/* 493 */
/* 494 */     while (agg_mapIter.next()) {
/* 495 */       wholestagecodegen_numOutputRows.add(1);
/* 496 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 497 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 498 */
/* 499 */       boolean agg_isNull79 = agg_aggKey.isNullAt(0);
/* 500 */       UTF8String agg_value93 = agg_isNull79 ? null : (agg_aggKey.getUTF8String(0));
/* 501 */       boolean agg_isNull80 = agg_aggKey.isNullAt(1);
/* 502 */       UTF8String agg_value94 = agg_isNull80 ? null : (agg_aggKey.getUTF8String(1));
/* 503 */       boolean agg_isNull81 = agg_aggKey.isNullAt(2);
/* 504 */       UTF8String agg_value95 = agg_isNull81 ? null : (agg_aggKey.getUTF8String(2));
/* 505 */       boolean agg_isNull82 = agg_aggKey.isNullAt(3);
/* 506 */       UTF8String agg_value96 = agg_isNull82 ? null : (agg_aggKey.getUTF8String(3));
/* 507 */       int agg_value97 = agg_aggKey.getInt(4);
/* 508 */       boolean agg_isNull84 = agg_aggBuffer.isNullAt(0);
/* 509 */       Decimal agg_value98 = agg_isNull84 ? null : (agg_aggBuffer.getDecimal(0, 22, 2));
/* 510 */       boolean agg_isNull85 = agg_aggBuffer.isNullAt(1);
/* 511 */       long agg_value99 = agg_isNull85 ? -1L : (agg_aggBuffer.getLong(1));
/* 512 */       boolean agg_isNull86 = agg_aggBuffer.isNullAt(2);
/* 513 */       Decimal agg_value100 = agg_isNull86 ? null : (agg_aggBuffer.getDecimal(2, 22, 2));
/* 514 */       boolean agg_isNull87 = agg_aggBuffer.isNullAt(3);
/* 515 */       long agg_value101 = agg_isNull87 ? -1L : (agg_aggBuffer.getLong(3));
/* 516 */       boolean agg_isNull88 = agg_aggBuffer.isNullAt(4);
/* 517 */       Decimal agg_value102 = agg_isNull88 ? null : (agg_aggBuffer.getDecimal(4, 22, 2));
/* 518 */       boolean agg_isNull89 = agg_aggBuffer.isNullAt(5);
/* 519 */       long agg_value103 = agg_isNull89 ? -1L : (agg_aggBuffer.getLong(5));
/* 520 */       boolean agg_isNull90 = agg_aggBuffer.isNullAt(6);
/* 521 */       Decimal agg_value104 = agg_isNull90 ? null : (agg_aggBuffer.getDecimal(6, 22, 2));
/* 522 */       boolean agg_isNull91 = agg_aggBuffer.isNullAt(7);
/* 523 */       long agg_value105 = agg_isNull91 ? -1L : (agg_aggBuffer.getLong(7));
/* 524 */       boolean agg_isNull92 = agg_aggBuffer.isNullAt(8);
/* 525 */       Decimal agg_value106 = agg_isNull92 ? null : (agg_aggBuffer.getDecimal(8, 22, 2));
/* 526 */       boolean agg_isNull93 = agg_aggBuffer.isNullAt(9);
/* 527 */       long agg_value107 = agg_isNull93 ? -1L : (agg_aggBuffer.getLong(9));
/* 528 */       boolean agg_isNull94 = agg_aggBuffer.isNullAt(10);
/* 529 */       Decimal agg_value108 = agg_isNull94 ? null : (agg_aggBuffer.getDecimal(10, 22, 2));
/* 530 */       boolean agg_isNull95 = agg_aggBuffer.isNullAt(11);
/* 531 */       long agg_value109 = agg_isNull95 ? -1L : (agg_aggBuffer.getLong(11));
/* 532 */       boolean agg_isNull96 = agg_aggBuffer.isNullAt(12);
/* 533 */       Decimal agg_value110 = agg_isNull96 ? null : (agg_aggBuffer.getDecimal(12, 22, 2));
/* 534 */       boolean agg_isNull97 = agg_aggBuffer.isNullAt(13);
/* 535 */       long agg_value111 = agg_isNull97 ? -1L : (agg_aggBuffer.getLong(13));
/* 536 */       boolean agg_isNull102 = agg_isNull85;
/* 537 */       Decimal agg_value116 = null;
/* 538 */       if (!agg_isNull85) {
/* 539 */         Decimal agg_tmpDecimal8 = Decimal.apply((long) agg_value99);
/* 540 */
/* 541 */         if (agg_tmpDecimal8.changePrecision(26, 6)) {
/* 542 */           agg_value116 = agg_tmpDecimal8;
/* 543 */         } else {
/* 544 */           agg_isNull102 = true;
/* 545 */         }
/* 546 */
/* 547 */       }
/* 548 */       boolean agg_isNull99 = false;
/* 549 */       Decimal agg_value113 = null;
/* 550 */       if (agg_isNull102 || agg_value116.isZero()) {
/* 551 */         agg_isNull99 = true;
/* 552 */       } else {
/* 553 */         boolean agg_isNull100 = agg_isNull84;
/* 554 */         Decimal agg_value114 = null;
/* 555 */         if (!agg_isNull84) {
/* 556 */           Decimal agg_tmpDecimal7 = agg_value98.clone();
/* 557 */
/* 558 */           if (agg_tmpDecimal7.changePrecision(26, 6)) {
/* 559 */             agg_value114 = agg_tmpDecimal7;
/* 560 */           } else {
/* 561 */             agg_isNull100 = true;
/* 562 */           }
/* 563 */
/* 564 */         }
/* 565 */         if (agg_isNull100) {
/* 566 */           agg_isNull99 = true;
/* 567 */         } else {
/* 568 */           agg_value113 = agg_value114.$div(agg_value116);
/* 569 */         }
/* 570 */       }
/* 571 */       boolean agg_isNull98 = agg_isNull99;
/* 572 */       Decimal agg_value112 = null;
/* 573 */       if (!agg_isNull99) {
/* 574 */         Decimal agg_tmpDecimal9 = agg_value113.clone();
/* 575 */
/* 576 */         if (agg_tmpDecimal9.changePrecision(16, 6)) {
/* 577 */           agg_value112 = agg_tmpDecimal9;
/* 578 */         } else {
/* 579 */           agg_isNull98 = true;
/* 580 */         }
/* 581 */
/* 582 */       }
/* 583 */       boolean agg_isNull108 = agg_isNull87;
/* 584 */       Decimal agg_value122 = null;
/* 585 */       if (!agg_isNull87) {
/* 586 */         Decimal agg_tmpDecimal11 = Decimal.apply((long) agg_value101);
/* 587 */
/* 588 */         if (agg_tmpDecimal11.changePrecision(26, 6)) {
/* 589 */           agg_value122 = agg_tmpDecimal11;
/* 590 */         } else {
/* 591 */           agg_isNull108 = true;
/* 592 */         }
/* 593 */
/* 594 */       }
/* 595 */       boolean agg_isNull105 = false;
/* 596 */       Decimal agg_value119 = null;
/* 597 */       if (agg_isNull108 || agg_value122.isZero()) {
/* 598 */         agg_isNull105 = true;
/* 599 */       } else {
/* 600 */         boolean agg_isNull106 = agg_isNull86;
/* 601 */         Decimal agg_value120 = null;
/* 602 */         if (!agg_isNull86) {
/* 603 */           Decimal agg_tmpDecimal10 = agg_value100.clone();
/* 604 */
/* 605 */           if (agg_tmpDecimal10.changePrecision(26, 6)) {
/* 606 */             agg_value120 = agg_tmpDecimal10;
/* 607 */           } else {
/* 608 */             agg_isNull106 = true;
/* 609 */           }
/* 610 */
/* 611 */         }
/* 612 */         if (agg_isNull106) {
/* 613 */           agg_isNull105 = true;
/* 614 */         } else {
/* 615 */           agg_value119 = agg_value120.$div(agg_value122);
/* 616 */         }
/* 617 */       }
/* 618 */       boolean agg_isNull104 = agg_isNull105;
/* 619 */       Decimal agg_value118 = null;
/* 620 */       if (!agg_isNull105) {
/* 621 */         Decimal agg_tmpDecimal12 = agg_value119.clone();
/* 622 */
/* 623 */         if (agg_tmpDecimal12.changePrecision(16, 6)) {
/* 624 */           agg_value118 = agg_tmpDecimal12;
/* 625 */         } else {
/* 626 */           agg_isNull104 = true;
/* 627 */         }
/* 628 */
/* 629 */       }
/* 630 */       boolean agg_isNull114 = agg_isNull89;
/* 631 */       Decimal agg_value128 = null;
/* 632 */       if (!agg_isNull89) {
/* 633 */         Decimal agg_tmpDecimal14 = Decimal.apply((long) agg_value103);
/* 634 */
/* 635 */         if (agg_tmpDecimal14.changePrecision(26, 6)) {
/* 636 */           agg_value128 = agg_tmpDecimal14;
/* 637 */         } else {
/* 638 */           agg_isNull114 = true;
/* 639 */         }
/* 640 */
/* 641 */       }
/* 642 */       boolean agg_isNull111 = false;
/* 643 */       Decimal agg_value125 = null;
/* 644 */       if (agg_isNull114 || agg_value128.isZero()) {
/* 645 */         agg_isNull111 = true;
/* 646 */       } else {
/* 647 */         boolean agg_isNull112 = agg_isNull88;
/* 648 */         Decimal agg_value126 = null;
/* 649 */         if (!agg_isNull88) {
/* 650 */           Decimal agg_tmpDecimal13 = agg_value102.clone();
/* 651 */
/* 652 */           if (agg_tmpDecimal13.changePrecision(26, 6)) {
/* 653 */             agg_value126 = agg_tmpDecimal13;
/* 654 */           } else {
/* 655 */             agg_isNull112 = true;
/* 656 */           }
/* 657 */
/* 658 */         }
/* 659 */         if (agg_isNull112) {
/* 660 */           agg_isNull111 = true;
/* 661 */         } else {
/* 662 */           agg_value125 = agg_value126.$div(agg_value128);
/* 663 */         }
/* 664 */       }
/* 665 */       boolean agg_isNull110 = agg_isNull111;
/* 666 */       Decimal agg_value124 = null;
/* 667 */       if (!agg_isNull111) {
/* 668 */         Decimal agg_tmpDecimal15 = agg_value125.clone();
/* 669 */
/* 670 */         if (agg_tmpDecimal15.changePrecision(16, 6)) {
/* 671 */           agg_value124 = agg_tmpDecimal15;
/* 672 */         } else {
/* 673 */           agg_isNull110 = true;
/* 674 */         }
/* 675 */
/* 676 */       }
/* 677 */       boolean agg_isNull120 = agg_isNull91;
/* 678 */       Decimal agg_value134 = null;
/* 679 */       if (!agg_isNull91) {
/* 680 */         Decimal agg_tmpDecimal17 = Decimal.apply((long) agg_value105);
/* 681 */
/* 682 */         if (agg_tmpDecimal17.changePrecision(26, 6)) {
/* 683 */           agg_value134 = agg_tmpDecimal17;
/* 684 */         } else {
/* 685 */           agg_isNull120 = true;
/* 686 */         }
/* 687 */
/* 688 */       }
/* 689 */       boolean agg_isNull117 = false;
/* 690 */       Decimal agg_value131 = null;
/* 691 */       if (agg_isNull120 || agg_value134.isZero()) {
/* 692 */         agg_isNull117 = true;
/* 693 */       } else {
/* 694 */         boolean agg_isNull118 = agg_isNull90;
/* 695 */         Decimal agg_value132 = null;
/* 696 */         if (!agg_isNull90) {
/* 697 */           Decimal agg_tmpDecimal16 = agg_value104.clone();
/* 698 */
/* 699 */           if (agg_tmpDecimal16.changePrecision(26, 6)) {
/* 700 */             agg_value132 = agg_tmpDecimal16;
/* 701 */           } else {
/* 702 */             agg_isNull118 = true;
/* 703 */           }
/* 704 */
/* 705 */         }
/* 706 */         if (agg_isNull118) {
/* 707 */           agg_isNull117 = true;
/* 708 */         } else {
/* 709 */           agg_value131 = agg_value132.$div(agg_value134);
/* 710 */         }
/* 711 */       }
/* 712 */       boolean agg_isNull116 = agg_isNull117;
/* 713 */       Decimal agg_value130 = null;
/* 714 */       if (!agg_isNull117) {
/* 715 */         Decimal agg_tmpDecimal18 = agg_value131.clone();
/* 716 */
/* 717 */         if (agg_tmpDecimal18.changePrecision(16, 6)) {
/* 718 */           agg_value130 = agg_tmpDecimal18;
/* 719 */         } else {
/* 720 */           agg_isNull116 = true;
/* 721 */         }
/* 722 */
/* 723 */       }
/* 724 */       boolean agg_isNull126 = agg_isNull93;
/* 725 */       Decimal agg_value140 = null;
/* 726 */       if (!agg_isNull93) {
/* 727 */         Decimal agg_tmpDecimal20 = Decimal.apply((long) agg_value107);
/* 728 */
/* 729 */         if (agg_tmpDecimal20.changePrecision(26, 6)) {
/* 730 */           agg_value140 = agg_tmpDecimal20;
/* 731 */         } else {
/* 732 */           agg_isNull126 = true;
/* 733 */         }
/* 734 */
/* 735 */       }
/* 736 */       boolean agg_isNull123 = false;
/* 737 */       Decimal agg_value137 = null;
/* 738 */       if (agg_isNull126 || agg_value140.isZero()) {
/* 739 */         agg_isNull123 = true;
/* 740 */       } else {
/* 741 */         boolean agg_isNull124 = agg_isNull92;
/* 742 */         Decimal agg_value138 = null;
/* 743 */         if (!agg_isNull92) {
/* 744 */           Decimal agg_tmpDecimal19 = agg_value106.clone();
/* 745 */
/* 746 */           if (agg_tmpDecimal19.changePrecision(26, 6)) {
/* 747 */             agg_value138 = agg_tmpDecimal19;
/* 748 */           } else {
/* 749 */             agg_isNull124 = true;
/* 750 */           }
/* 751 */
/* 752 */         }
/* 753 */         if (agg_isNull124) {
/* 754 */           agg_isNull123 = true;
/* 755 */         } else {
/* 756 */           agg_value137 = agg_value138.$div(agg_value140);
/* 757 */         }
/* 758 */       }
/* 759 */       boolean agg_isNull122 = agg_isNull123;
/* 760 */       Decimal agg_value136 = null;
/* 761 */       if (!agg_isNull123) {
/* 762 */         Decimal agg_tmpDecimal21 = agg_value137.clone();
/* 763 */
/* 764 */         if (agg_tmpDecimal21.changePrecision(16, 6)) {
/* 765 */           agg_value136 = agg_tmpDecimal21;
/* 766 */         } else {
/* 767 */           agg_isNull122 = true;
/* 768 */         }
/* 769 */
/* 770 */       }
/* 771 */       boolean agg_isNull132 = agg_isNull95;
/* 772 */       Decimal agg_value146 = null;
/* 773 */       if (!agg_isNull95) {
/* 774 */         Decimal agg_tmpDecimal23 = Decimal.apply((long) agg_value109);
/* 775 */
/* 776 */         if (agg_tmpDecimal23.changePrecision(26, 6)) {
/* 777 */           agg_value146 = agg_tmpDecimal23;
/* 778 */         } else {
/* 779 */           agg_isNull132 = true;
/* 780 */         }
/* 781 */
/* 782 */       }
/* 783 */       boolean agg_isNull129 = false;
/* 784 */       Decimal agg_value143 = null;
/* 785 */       if (agg_isNull132 || agg_value146.isZero()) {
/* 786 */         agg_isNull129 = true;
/* 787 */       } else {
/* 788 */         boolean agg_isNull130 = agg_isNull94;
/* 789 */         Decimal agg_value144 = null;
/* 790 */         if (!agg_isNull94) {
/* 791 */           Decimal agg_tmpDecimal22 = agg_value108.clone();
/* 792 */
/* 793 */           if (agg_tmpDecimal22.changePrecision(26, 6)) {
/* 794 */             agg_value144 = agg_tmpDecimal22;
/* 795 */           } else {
/* 796 */             agg_isNull130 = true;
/* 797 */           }
/* 798 */
/* 799 */         }
/* 800 */         if (agg_isNull130) {
/* 801 */           agg_isNull129 = true;
/* 802 */         } else {
/* 803 */           agg_value143 = agg_value144.$div(agg_value146);
/* 804 */         }
/* 805 */       }
/* 806 */       boolean agg_isNull128 = agg_isNull129;
/* 807 */       Decimal agg_value142 = null;
/* 808 */       if (!agg_isNull129) {
/* 809 */         Decimal agg_tmpDecimal24 = agg_value143.clone();
/* 810 */
/* 811 */         if (agg_tmpDecimal24.changePrecision(16, 6)) {
/* 812 */           agg_value142 = agg_tmpDecimal24;
/* 813 */         } else {
/* 814 */           agg_isNull128 = true;
/* 815 */         }
/* 816 */
/* 817 */       }
/* 818 */       boolean agg_isNull138 = agg_isNull97;
/* 819 */       Decimal agg_value152 = null;
/* 820 */       if (!agg_isNull97) {
/* 821 */         Decimal agg_tmpDecimal26 = Decimal.apply((long) agg_value111);
/* 822 */
/* 823 */         if (agg_tmpDecimal26.changePrecision(26, 6)) {
/* 824 */           agg_value152 = agg_tmpDecimal26;
/* 825 */         } else {
/* 826 */           agg_isNull138 = true;
/* 827 */         }
/* 828 */
/* 829 */       }
/* 830 */       boolean agg_isNull135 = false;
/* 831 */       Decimal agg_value149 = null;
/* 832 */       if (agg_isNull138 || agg_value152.isZero()) {
/* 833 */         agg_isNull135 = true;
/* 834 */       } else {
/* 835 */         boolean agg_isNull136 = agg_isNull96;
/* 836 */         Decimal agg_value150 = null;
/* 837 */         if (!agg_isNull96) {
/* 838 */           Decimal agg_tmpDecimal25 = agg_value110.clone();
/* 839 */
/* 840 */           if (agg_tmpDecimal25.changePrecision(26, 6)) {
/* 841 */             agg_value150 = agg_tmpDecimal25;
/* 842 */           } else {
/* 843 */             agg_isNull136 = true;
/* 844 */           }
/* 845 */
/* 846 */         }
/* 847 */         if (agg_isNull136) {
/* 848 */           agg_isNull135 = true;
/* 849 */         } else {
/* 850 */           agg_value149 = agg_value150.$div(agg_value152);
/* 851 */         }
/* 852 */       }
/* 853 */       boolean agg_isNull134 = agg_isNull135;
/* 854 */       Decimal agg_value148 = null;
/* 855 */       if (!agg_isNull135) {
/* 856 */         Decimal agg_tmpDecimal27 = agg_value149.clone();
/* 857 */
/* 858 */         if (agg_tmpDecimal27.changePrecision(16, 6)) {
/* 859 */           agg_value148 = agg_tmpDecimal27;
/* 860 */         } else {
/* 861 */           agg_isNull134 = true;
/* 862 */         }
/* 863 */
/* 864 */       }
/* 865 */
/* 866 */       agg_holder1.reset();
/* 867 */
/* 868 */       agg_rowWriter1.zeroOutNullBytes();
/* 869 */
/* 870 */       if (agg_isNull79) {
/* 871 */         agg_rowWriter1.setNullAt(0);
/* 872 */       } else {
/* 873 */         agg_rowWriter1.write(0, agg_value93);
/* 874 */       }
/* 875 */
/* 876 */       if (agg_isNull80) {
/* 877 */         agg_rowWriter1.setNullAt(1);
/* 878 */       } else {
/* 879 */         agg_rowWriter1.write(1, agg_value94);
/* 880 */       }
/* 881 */
/* 882 */       if (agg_isNull81) {
/* 883 */         agg_rowWriter1.setNullAt(2);
/* 884 */       } else {
/* 885 */         agg_rowWriter1.write(2, agg_value95);
/* 886 */       }
/* 887 */
/* 888 */       if (agg_isNull82) {
/* 889 */         agg_rowWriter1.setNullAt(3);
/* 890 */       } else {
/* 891 */         agg_rowWriter1.write(3, agg_value96);
/* 892 */       }
/* 893 */
/* 894 */       if (agg_isNull98) {
/* 895 */         agg_rowWriter1.setNullAt(4);
/* 896 */       } else {
/* 897 */         agg_rowWriter1.write(4, agg_value112, 16, 6);
/* 898 */       }
/* 899 */
/* 900 */       if (agg_isNull104) {
/* 901 */         agg_rowWriter1.setNullAt(5);
/* 902 */       } else {
/* 903 */         agg_rowWriter1.write(5, agg_value118, 16, 6);
/* 904 */       }
/* 905 */
/* 906 */       if (agg_isNull110) {
/* 907 */         agg_rowWriter1.setNullAt(6);
/* 908 */       } else {
/* 909 */         agg_rowWriter1.write(6, agg_value124, 16, 6);
/* 910 */       }
/* 911 */
/* 912 */       if (agg_isNull116) {
/* 913 */         agg_rowWriter1.setNullAt(7);
/* 914 */       } else {
/* 915 */         agg_rowWriter1.write(7, agg_value130, 16, 6);
/* 916 */       }
/* 917 */
/* 918 */       if (agg_isNull122) {
/* 919 */         agg_rowWriter1.setNullAt(8);
/* 920 */       } else {
/* 921 */         agg_rowWriter1.write(8, agg_value136, 16, 6);
/* 922 */       }
/* 923 */
/* 924 */       if (agg_isNull128) {
/* 925 */         agg_rowWriter1.setNullAt(9);
/* 926 */       } else {
/* 927 */         agg_rowWriter1.write(9, agg_value142, 16, 6);
/* 928 */       }
/* 929 */
/* 930 */       if (agg_isNull134) {
/* 931 */         agg_rowWriter1.setNullAt(10);
/* 932 */       } else {
/* 933 */         agg_rowWriter1.write(10, agg_value148, 16, 6);
/* 934 */       }
/* 935 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 936 */       append(agg_result1);
/* 937 */
/* 938 */       if (shouldStop()) return;
/* 939 */     }
/* 940 */
/* 941 */     agg_mapIter.close();
/* 942 */     if (agg_sorter == null) {
/* 943 */       agg_hashMap.free();
/* 944 */     }
/* 945 */   }
/* 946 */ }
