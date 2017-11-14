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
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 018 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 019 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 020 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 021 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 022 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 023 */   private scala.collection.Iterator inputadapter_input;
/* 024 */   private UnsafeRow agg_result;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 027 */   private int agg_value38;
/* 028 */   private UnsafeRow agg_result1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 031 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 032 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 033 */
/* 034 */   public GeneratedIterator(Object[] references) {
/* 035 */     this.references = references;
/* 036 */   }
/* 037 */
/* 038 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 039 */     partitionIndex = index;
/* 040 */     this.inputs = inputs;
/* 041 */     agg_initAgg = false;
/* 042 */
/* 043 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 044 */
/* 045 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 046 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 047 */     inputadapter_input = inputs[0];
/* 048 */     agg_result = new UnsafeRow(15);
/* 049 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 352);
/* 050 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 15);
/* 051 */
/* 052 */     agg_result1 = new UnsafeRow(8);
/* 053 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 64);
/* 054 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 8);
/* 055 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 056 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 057 */
/* 058 */   }
/* 059 */
/* 060 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 061 */     agg_hashMap = agg_plan.createHashMap();
/* 062 */
/* 063 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 064 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 065 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 066 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 067 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 068 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 069 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 070 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 071 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 072 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 073 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 074 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 075 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 076 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 077 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 078 */       UTF8String inputadapter_value6 = inputadapter_isNull6 ? null : (inputadapter_row.getUTF8String(6));
/* 079 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 080 */       UTF8String inputadapter_value7 = inputadapter_isNull7 ? null : (inputadapter_row.getUTF8String(7));
/* 081 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 082 */       UTF8String inputadapter_value8 = inputadapter_isNull8 ? null : (inputadapter_row.getUTF8String(8));
/* 083 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 084 */       UTF8String inputadapter_value9 = inputadapter_isNull9 ? null : (inputadapter_row.getUTF8String(9));
/* 085 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 086 */       UTF8String inputadapter_value10 = inputadapter_isNull10 ? null : (inputadapter_row.getUTF8String(10));
/* 087 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 088 */       UTF8String inputadapter_value11 = inputadapter_isNull11 ? null : (inputadapter_row.getUTF8String(11));
/* 089 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 090 */       int inputadapter_value12 = inputadapter_isNull12 ? -1 : (inputadapter_row.getInt(12));
/* 091 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 092 */       int inputadapter_value13 = inputadapter_isNull13 ? -1 : (inputadapter_row.getInt(13));
/* 093 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 094 */       int inputadapter_value14 = inputadapter_isNull14 ? -1 : (inputadapter_row.getInt(14));
/* 095 */       long inputadapter_value15 = inputadapter_row.getLong(15);
/* 096 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 097 */       double inputadapter_value16 = inputadapter_isNull16 ? -1.0 : (inputadapter_row.getDouble(16));
/* 098 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 099 */       double inputadapter_value17 = inputadapter_isNull17 ? -1.0 : (inputadapter_row.getDouble(17));
/* 100 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 101 */       double inputadapter_value18 = inputadapter_isNull18 ? -1.0 : (inputadapter_row.getDouble(18));
/* 102 */
/* 103 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 104 */
/* 105 */       UnsafeRow agg_fastAggBuffer = null;
/* 106 */
/* 107 */       if (agg_fastAggBuffer == null) {
/* 108 */         // generate grouping key
/* 109 */         agg_holder.reset();
/* 110 */
/* 111 */         agg_rowWriter.zeroOutNullBytes();
/* 112 */
/* 113 */         if (inputadapter_isNull) {
/* 114 */           agg_rowWriter.setNullAt(0);
/* 115 */         } else {
/* 116 */           agg_rowWriter.write(0, inputadapter_value);
/* 117 */         }
/* 118 */
/* 119 */         if (inputadapter_isNull1) {
/* 120 */           agg_rowWriter.setNullAt(1);
/* 121 */         } else {
/* 122 */           agg_rowWriter.write(1, inputadapter_value1);
/* 123 */         }
/* 124 */
/* 125 */         if (inputadapter_isNull2) {
/* 126 */           agg_rowWriter.setNullAt(2);
/* 127 */         } else {
/* 128 */           agg_rowWriter.write(2, inputadapter_value2);
/* 129 */         }
/* 130 */
/* 131 */         if (inputadapter_isNull3) {
/* 132 */           agg_rowWriter.setNullAt(3);
/* 133 */         } else {
/* 134 */           agg_rowWriter.write(3, inputadapter_value3);
/* 135 */         }
/* 136 */
/* 137 */         if (inputadapter_isNull4) {
/* 138 */           agg_rowWriter.setNullAt(4);
/* 139 */         } else {
/* 140 */           agg_rowWriter.write(4, inputadapter_value4);
/* 141 */         }
/* 142 */
/* 143 */         if (inputadapter_isNull5) {
/* 144 */           agg_rowWriter.setNullAt(5);
/* 145 */         } else {
/* 146 */           agg_rowWriter.write(5, inputadapter_value5);
/* 147 */         }
/* 148 */
/* 149 */         if (inputadapter_isNull6) {
/* 150 */           agg_rowWriter.setNullAt(6);
/* 151 */         } else {
/* 152 */           agg_rowWriter.write(6, inputadapter_value6);
/* 153 */         }
/* 154 */
/* 155 */         if (inputadapter_isNull7) {
/* 156 */           agg_rowWriter.setNullAt(7);
/* 157 */         } else {
/* 158 */           agg_rowWriter.write(7, inputadapter_value7);
/* 159 */         }
/* 160 */
/* 161 */         if (inputadapter_isNull8) {
/* 162 */           agg_rowWriter.setNullAt(8);
/* 163 */         } else {
/* 164 */           agg_rowWriter.write(8, inputadapter_value8);
/* 165 */         }
/* 166 */
/* 167 */         if (inputadapter_isNull9) {
/* 168 */           agg_rowWriter.setNullAt(9);
/* 169 */         } else {
/* 170 */           agg_rowWriter.write(9, inputadapter_value9);
/* 171 */         }
/* 172 */
/* 173 */         if (inputadapter_isNull10) {
/* 174 */           agg_rowWriter.setNullAt(10);
/* 175 */         } else {
/* 176 */           agg_rowWriter.write(10, inputadapter_value10);
/* 177 */         }
/* 178 */
/* 179 */         if (inputadapter_isNull11) {
/* 180 */           agg_rowWriter.setNullAt(11);
/* 181 */         } else {
/* 182 */           agg_rowWriter.write(11, inputadapter_value11);
/* 183 */         }
/* 184 */
/* 185 */         if (inputadapter_isNull12) {
/* 186 */           agg_rowWriter.setNullAt(12);
/* 187 */         } else {
/* 188 */           agg_rowWriter.write(12, inputadapter_value12);
/* 189 */         }
/* 190 */
/* 191 */         if (inputadapter_isNull13) {
/* 192 */           agg_rowWriter.setNullAt(13);
/* 193 */         } else {
/* 194 */           agg_rowWriter.write(13, inputadapter_value13);
/* 195 */         }
/* 196 */
/* 197 */         if (inputadapter_isNull14) {
/* 198 */           agg_rowWriter.setNullAt(14);
/* 199 */         } else {
/* 200 */           agg_rowWriter.write(14, inputadapter_value14);
/* 201 */         }
/* 202 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 203 */         agg_value38 = 42;
/* 204 */
/* 205 */         if (!inputadapter_isNull) {
/* 206 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value38);
/* 207 */         }
/* 208 */
/* 209 */         if (!inputadapter_isNull1) {
/* 210 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value38);
/* 211 */         }
/* 212 */
/* 213 */         if (!inputadapter_isNull2) {
/* 214 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value38);
/* 215 */         }
/* 216 */
/* 217 */         if (!inputadapter_isNull3) {
/* 218 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value38);
/* 219 */         }
/* 220 */
/* 221 */         if (!inputadapter_isNull4) {
/* 222 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value38);
/* 223 */         }
/* 224 */
/* 225 */         if (!inputadapter_isNull5) {
/* 226 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value38);
/* 227 */         }
/* 228 */
/* 229 */         if (!inputadapter_isNull6) {
/* 230 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value6.getBaseObject(), inputadapter_value6.getBaseOffset(), inputadapter_value6.numBytes(), agg_value38);
/* 231 */         }
/* 232 */
/* 233 */         if (!inputadapter_isNull7) {
/* 234 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value7.getBaseObject(), inputadapter_value7.getBaseOffset(), inputadapter_value7.numBytes(), agg_value38);
/* 235 */         }
/* 236 */
/* 237 */         if (!inputadapter_isNull8) {
/* 238 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value8.getBaseObject(), inputadapter_value8.getBaseOffset(), inputadapter_value8.numBytes(), agg_value38);
/* 239 */         }
/* 240 */
/* 241 */         if (!inputadapter_isNull9) {
/* 242 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value9.getBaseObject(), inputadapter_value9.getBaseOffset(), inputadapter_value9.numBytes(), agg_value38);
/* 243 */         }
/* 244 */
/* 245 */         if (!inputadapter_isNull10) {
/* 246 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value10.getBaseObject(), inputadapter_value10.getBaseOffset(), inputadapter_value10.numBytes(), agg_value38);
/* 247 */         }
/* 248 */
/* 249 */         if (!inputadapter_isNull11) {
/* 250 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value11.getBaseObject(), inputadapter_value11.getBaseOffset(), inputadapter_value11.numBytes(), agg_value38);
/* 251 */         }
/* 252 */
/* 253 */         if (!inputadapter_isNull12) {
/* 254 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value12, agg_value38);
/* 255 */         }
/* 256 */
/* 257 */         if (!inputadapter_isNull13) {
/* 258 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value13, agg_value38);
/* 259 */         }
/* 260 */
/* 261 */         if (!inputadapter_isNull14) {
/* 262 */           agg_value38 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value14, agg_value38);
/* 263 */         }
/* 264 */         if (true) {
/* 265 */           // try to get the buffer from hash map
/* 266 */           agg_unsafeRowAggBuffer =
/* 267 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value38);
/* 268 */         }
/* 269 */         if (agg_unsafeRowAggBuffer == null) {
/* 270 */           if (agg_sorter == null) {
/* 271 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 272 */           } else {
/* 273 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 274 */           }
/* 275 */
/* 276 */           // the hash map had be spilled, it should have enough memory now,
/* 277 */           // try  to allocate buffer again.
/* 278 */           agg_unsafeRowAggBuffer =
/* 279 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value38);
/* 280 */           if (agg_unsafeRowAggBuffer == null) {
/* 281 */             // failed to allocate the first page
/* 282 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 283 */           }
/* 284 */         }
/* 285 */       }
/* 286 */
/* 287 */       if (agg_fastAggBuffer != null) {
/* 288 */         // update fast row
/* 289 */
/* 290 */       } else {
/* 291 */         // update unsafe row
/* 292 */
/* 293 */         // common sub-expressions
/* 294 */
/* 295 */         // evaluate aggregate function
/* 296 */         boolean agg_isNull50 = false;
/* 297 */
/* 298 */         long agg_value55 = agg_unsafeRowAggBuffer.getLong(0);
/* 299 */
/* 300 */         long agg_value54 = -1L;
/* 301 */         agg_value54 = agg_value55 + inputadapter_value15;
/* 302 */         boolean agg_isNull54 = true;
/* 303 */         double agg_value58 = -1.0;
/* 304 */
/* 305 */         boolean agg_isNull56 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 306 */         double agg_value60 = agg_isNull56 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 307 */         boolean agg_isNull55 = agg_isNull56;
/* 308 */         double agg_value59 = agg_value60;
/* 309 */         if (agg_isNull55) {
/* 310 */           boolean agg_isNull57 = false;
/* 311 */           double agg_value61 = -1.0;
/* 312 */           if (!false) {
/* 313 */             agg_value61 = (double) 0;
/* 314 */           }
/* 315 */           if (!agg_isNull57) {
/* 316 */             agg_isNull55 = false;
/* 317 */             agg_value59 = agg_value61;
/* 318 */           }
/* 319 */         }
/* 320 */
/* 321 */         if (!inputadapter_isNull16) {
/* 322 */           agg_isNull54 = false; // resultCode could change nullability.
/* 323 */           agg_value58 = agg_value59 + inputadapter_value16;
/* 324 */
/* 325 */         }
/* 326 */         boolean agg_isNull53 = agg_isNull54;
/* 327 */         double agg_value57 = agg_value58;
/* 328 */         if (agg_isNull53) {
/* 329 */           boolean agg_isNull60 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 330 */           double agg_value64 = agg_isNull60 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 331 */           if (!agg_isNull60) {
/* 332 */             agg_isNull53 = false;
/* 333 */             agg_value57 = agg_value64;
/* 334 */           }
/* 335 */         }
/* 336 */         boolean agg_isNull62 = true;
/* 337 */         double agg_value66 = -1.0;
/* 338 */
/* 339 */         boolean agg_isNull64 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 340 */         double agg_value68 = agg_isNull64 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 341 */         boolean agg_isNull63 = agg_isNull64;
/* 342 */         double agg_value67 = agg_value68;
/* 343 */         if (agg_isNull63) {
/* 344 */           boolean agg_isNull65 = false;
/* 345 */           double agg_value69 = -1.0;
/* 346 */           if (!false) {
/* 347 */             agg_value69 = (double) 0;
/* 348 */           }
/* 349 */           if (!agg_isNull65) {
/* 350 */             agg_isNull63 = false;
/* 351 */             agg_value67 = agg_value69;
/* 352 */           }
/* 353 */         }
/* 354 */
/* 355 */         if (!inputadapter_isNull17) {
/* 356 */           agg_isNull62 = false; // resultCode could change nullability.
/* 357 */           agg_value66 = agg_value67 + inputadapter_value17;
/* 358 */
/* 359 */         }
/* 360 */         boolean agg_isNull61 = agg_isNull62;
/* 361 */         double agg_value65 = agg_value66;
/* 362 */         if (agg_isNull61) {
/* 363 */           boolean agg_isNull68 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 364 */           double agg_value72 = agg_isNull68 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 365 */           if (!agg_isNull68) {
/* 366 */             agg_isNull61 = false;
/* 367 */             agg_value65 = agg_value72;
/* 368 */           }
/* 369 */         }
/* 370 */         boolean agg_isNull70 = true;
/* 371 */         double agg_value74 = -1.0;
/* 372 */
/* 373 */         boolean agg_isNull72 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 374 */         double agg_value76 = agg_isNull72 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 375 */         boolean agg_isNull71 = agg_isNull72;
/* 376 */         double agg_value75 = agg_value76;
/* 377 */         if (agg_isNull71) {
/* 378 */           boolean agg_isNull73 = false;
/* 379 */           double agg_value77 = -1.0;
/* 380 */           if (!false) {
/* 381 */             agg_value77 = (double) 0;
/* 382 */           }
/* 383 */           if (!agg_isNull73) {
/* 384 */             agg_isNull71 = false;
/* 385 */             agg_value75 = agg_value77;
/* 386 */           }
/* 387 */         }
/* 388 */
/* 389 */         if (!inputadapter_isNull18) {
/* 390 */           agg_isNull70 = false; // resultCode could change nullability.
/* 391 */           agg_value74 = agg_value75 + inputadapter_value18;
/* 392 */
/* 393 */         }
/* 394 */         boolean agg_isNull69 = agg_isNull70;
/* 395 */         double agg_value73 = agg_value74;
/* 396 */         if (agg_isNull69) {
/* 397 */           boolean agg_isNull76 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 398 */           double agg_value80 = agg_isNull76 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 399 */           if (!agg_isNull76) {
/* 400 */             agg_isNull69 = false;
/* 401 */             agg_value73 = agg_value80;
/* 402 */           }
/* 403 */         }
/* 404 */         // update unsafe row buffer
/* 405 */         agg_unsafeRowAggBuffer.setLong(0, agg_value54);
/* 406 */
/* 407 */         if (!agg_isNull53) {
/* 408 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value57);
/* 409 */         } else {
/* 410 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 411 */         }
/* 412 */
/* 413 */         if (!agg_isNull61) {
/* 414 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value65);
/* 415 */         } else {
/* 416 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 417 */         }
/* 418 */
/* 419 */         if (!agg_isNull69) {
/* 420 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value73);
/* 421 */         } else {
/* 422 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 423 */         }
/* 424 */
/* 425 */       }
/* 426 */       if (shouldStop()) return;
/* 427 */     }
/* 428 */
/* 429 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 430 */   }
/* 431 */
/* 432 */   protected void processNext() throws java.io.IOException {
/* 433 */     if (!agg_initAgg) {
/* 434 */       agg_initAgg = true;
/* 435 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 436 */       agg_doAggregateWithKeys();
/* 437 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 438 */     }
/* 439 */
/* 440 */     // output the result
/* 441 */
/* 442 */     while (agg_mapIter.next()) {
/* 443 */       wholestagecodegen_numOutputRows.add(1);
/* 444 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 445 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 446 */
/* 447 */       boolean agg_isNull77 = agg_aggKey.isNullAt(0);
/* 448 */       UTF8String agg_value81 = agg_isNull77 ? null : (agg_aggKey.getUTF8String(0));
/* 449 */       boolean agg_isNull78 = agg_aggKey.isNullAt(1);
/* 450 */       int agg_value82 = agg_isNull78 ? -1 : (agg_aggKey.getInt(1));
/* 451 */       boolean agg_isNull79 = agg_aggKey.isNullAt(2);
/* 452 */       UTF8String agg_value83 = agg_isNull79 ? null : (agg_aggKey.getUTF8String(2));
/* 453 */       boolean agg_isNull80 = agg_aggKey.isNullAt(3);
/* 454 */       UTF8String agg_value84 = agg_isNull80 ? null : (agg_aggKey.getUTF8String(3));
/* 455 */       boolean agg_isNull81 = agg_aggKey.isNullAt(4);
/* 456 */       UTF8String agg_value85 = agg_isNull81 ? null : (agg_aggKey.getUTF8String(4));
/* 457 */       boolean agg_isNull82 = agg_aggKey.isNullAt(5);
/* 458 */       UTF8String agg_value86 = agg_isNull82 ? null : (agg_aggKey.getUTF8String(5));
/* 459 */       boolean agg_isNull83 = agg_aggKey.isNullAt(6);
/* 460 */       UTF8String agg_value87 = agg_isNull83 ? null : (agg_aggKey.getUTF8String(6));
/* 461 */       boolean agg_isNull84 = agg_aggKey.isNullAt(7);
/* 462 */       UTF8String agg_value88 = agg_isNull84 ? null : (agg_aggKey.getUTF8String(7));
/* 463 */       boolean agg_isNull85 = agg_aggKey.isNullAt(8);
/* 464 */       UTF8String agg_value89 = agg_isNull85 ? null : (agg_aggKey.getUTF8String(8));
/* 465 */       boolean agg_isNull86 = agg_aggKey.isNullAt(9);
/* 466 */       UTF8String agg_value90 = agg_isNull86 ? null : (agg_aggKey.getUTF8String(9));
/* 467 */       boolean agg_isNull87 = agg_aggKey.isNullAt(10);
/* 468 */       UTF8String agg_value91 = agg_isNull87 ? null : (agg_aggKey.getUTF8String(10));
/* 469 */       boolean agg_isNull88 = agg_aggKey.isNullAt(11);
/* 470 */       UTF8String agg_value92 = agg_isNull88 ? null : (agg_aggKey.getUTF8String(11));
/* 471 */       boolean agg_isNull89 = agg_aggKey.isNullAt(12);
/* 472 */       int agg_value93 = agg_isNull89 ? -1 : (agg_aggKey.getInt(12));
/* 473 */       boolean agg_isNull90 = agg_aggKey.isNullAt(13);
/* 474 */       int agg_value94 = agg_isNull90 ? -1 : (agg_aggKey.getInt(13));
/* 475 */       boolean agg_isNull91 = agg_aggKey.isNullAt(14);
/* 476 */       int agg_value95 = agg_isNull91 ? -1 : (agg_aggKey.getInt(14));
/* 477 */       long agg_value96 = agg_aggBuffer.getLong(0);
/* 478 */       boolean agg_isNull93 = agg_aggBuffer.isNullAt(1);
/* 479 */       double agg_value97 = agg_isNull93 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 480 */       boolean agg_isNull94 = agg_aggBuffer.isNullAt(2);
/* 481 */       double agg_value98 = agg_isNull94 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 482 */       boolean agg_isNull95 = agg_aggBuffer.isNullAt(3);
/* 483 */       double agg_value99 = agg_isNull95 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 484 */
/* 485 */       agg_holder1.reset();
/* 486 */
/* 487 */       agg_rowWriter1.zeroOutNullBytes();
/* 488 */
/* 489 */       if (agg_isNull78) {
/* 490 */         agg_rowWriter1.setNullAt(0);
/* 491 */       } else {
/* 492 */         agg_rowWriter1.write(0, agg_value82);
/* 493 */       }
/* 494 */
/* 495 */       if (agg_isNull79) {
/* 496 */         agg_rowWriter1.setNullAt(1);
/* 497 */       } else {
/* 498 */         agg_rowWriter1.write(1, agg_value83);
/* 499 */       }
/* 500 */
/* 501 */       if (agg_isNull80) {
/* 502 */         agg_rowWriter1.setNullAt(2);
/* 503 */       } else {
/* 504 */         agg_rowWriter1.write(2, agg_value84);
/* 505 */       }
/* 506 */
/* 507 */       if (agg_isNull89) {
/* 508 */         agg_rowWriter1.setNullAt(3);
/* 509 */       } else {
/* 510 */         agg_rowWriter1.write(3, agg_value93);
/* 511 */       }
/* 512 */
/* 513 */       agg_rowWriter1.write(4, agg_value96);
/* 514 */
/* 515 */       if (agg_isNull93) {
/* 516 */         agg_rowWriter1.setNullAt(5);
/* 517 */       } else {
/* 518 */         agg_rowWriter1.write(5, agg_value97);
/* 519 */       }
/* 520 */
/* 521 */       if (agg_isNull94) {
/* 522 */         agg_rowWriter1.setNullAt(6);
/* 523 */       } else {
/* 524 */         agg_rowWriter1.write(6, agg_value98);
/* 525 */       }
/* 526 */
/* 527 */       if (agg_isNull95) {
/* 528 */         agg_rowWriter1.setNullAt(7);
/* 529 */       } else {
/* 530 */         agg_rowWriter1.write(7, agg_value99);
/* 531 */       }
/* 532 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 533 */       append(agg_result1);
/* 534 */
/* 535 */       if (shouldStop()) return;
/* 536 */     }
/* 537 */
/* 538 */     agg_mapIter.close();
/* 539 */     if (agg_sorter == null) {
/* 540 */       agg_hashMap.free();
/* 541 */     }
/* 542 */   }
/* 543 */ }
