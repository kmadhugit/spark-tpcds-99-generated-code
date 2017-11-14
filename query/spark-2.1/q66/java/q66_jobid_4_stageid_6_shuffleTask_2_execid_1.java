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
/* 013 */   private boolean agg_bufIsNull2;
/* 014 */   private double agg_bufValue2;
/* 015 */   private boolean agg_bufIsNull3;
/* 016 */   private double agg_bufValue3;
/* 017 */   private boolean agg_bufIsNull4;
/* 018 */   private double agg_bufValue4;
/* 019 */   private boolean agg_bufIsNull5;
/* 020 */   private double agg_bufValue5;
/* 021 */   private boolean agg_bufIsNull6;
/* 022 */   private double agg_bufValue6;
/* 023 */   private boolean agg_bufIsNull7;
/* 024 */   private double agg_bufValue7;
/* 025 */   private boolean agg_bufIsNull8;
/* 026 */   private double agg_bufValue8;
/* 027 */   private boolean agg_bufIsNull9;
/* 028 */   private double agg_bufValue9;
/* 029 */   private boolean agg_bufIsNull10;
/* 030 */   private double agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private double agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private double agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private double agg_bufValue13;
/* 037 */   private boolean agg_bufIsNull14;
/* 038 */   private double agg_bufValue14;
/* 039 */   private boolean agg_bufIsNull15;
/* 040 */   private double agg_bufValue15;
/* 041 */   private boolean agg_bufIsNull16;
/* 042 */   private double agg_bufValue16;
/* 043 */   private boolean agg_bufIsNull17;
/* 044 */   private double agg_bufValue17;
/* 045 */   private boolean agg_bufIsNull18;
/* 046 */   private double agg_bufValue18;
/* 047 */   private boolean agg_bufIsNull19;
/* 048 */   private double agg_bufValue19;
/* 049 */   private boolean agg_bufIsNull20;
/* 050 */   private double agg_bufValue20;
/* 051 */   private boolean agg_bufIsNull21;
/* 052 */   private double agg_bufValue21;
/* 053 */   private boolean agg_bufIsNull22;
/* 054 */   private double agg_bufValue22;
/* 055 */   private boolean agg_bufIsNull23;
/* 056 */   private double agg_bufValue23;
/* 057 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 058 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 059 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 060 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 061 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 062 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 063 */   private scala.collection.Iterator inputadapter_input;
/* 064 */   private UnsafeRow agg_result;
/* 065 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 066 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 067 */   private int agg_value62;
/* 068 */   private UnsafeRow agg_result1;
/* 069 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 071 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 072 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 073 */
/* 074 */   public GeneratedIterator(Object[] references) {
/* 075 */     this.references = references;
/* 076 */   }
/* 077 */
/* 078 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 079 */     partitionIndex = index;
/* 080 */     this.inputs = inputs;
/* 081 */     agg_initAgg = false;
/* 082 */
/* 083 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 084 */
/* 085 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 086 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 087 */     inputadapter_input = inputs[0];
/* 088 */     agg_result = new UnsafeRow(7);
/* 089 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 160);
/* 090 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 7);
/* 091 */
/* 092 */     agg_result1 = new UnsafeRow(32);
/* 093 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 192);
/* 094 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 32);
/* 095 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 096 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 097 */
/* 098 */   }
/* 099 */
/* 100 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 101 */     agg_hashMap = agg_plan.createHashMap();
/* 102 */
/* 103 */     while (inputadapter_input.hasNext()) {
/* 104 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 105 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 106 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 107 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 108 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 109 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 110 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 111 */       boolean inputadapter_isNull3 = inputadapter_row.isNullAt(3);
/* 112 */       UTF8String inputadapter_value3 = inputadapter_isNull3 ? null : (inputadapter_row.getUTF8String(3));
/* 113 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 114 */       UTF8String inputadapter_value4 = inputadapter_isNull4 ? null : (inputadapter_row.getUTF8String(4));
/* 115 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 116 */       UTF8String inputadapter_value5 = inputadapter_isNull5 ? null : (inputadapter_row.getUTF8String(5));
/* 117 */       boolean inputadapter_isNull6 = inputadapter_row.isNullAt(6);
/* 118 */       int inputadapter_value6 = inputadapter_isNull6 ? -1 : (inputadapter_row.getInt(6));
/* 119 */       boolean inputadapter_isNull7 = inputadapter_row.isNullAt(7);
/* 120 */       double inputadapter_value7 = inputadapter_isNull7 ? -1.0 : (inputadapter_row.getDouble(7));
/* 121 */       boolean inputadapter_isNull8 = inputadapter_row.isNullAt(8);
/* 122 */       double inputadapter_value8 = inputadapter_isNull8 ? -1.0 : (inputadapter_row.getDouble(8));
/* 123 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 124 */       double inputadapter_value9 = inputadapter_isNull9 ? -1.0 : (inputadapter_row.getDouble(9));
/* 125 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 126 */       double inputadapter_value10 = inputadapter_isNull10 ? -1.0 : (inputadapter_row.getDouble(10));
/* 127 */       boolean inputadapter_isNull11 = inputadapter_row.isNullAt(11);
/* 128 */       double inputadapter_value11 = inputadapter_isNull11 ? -1.0 : (inputadapter_row.getDouble(11));
/* 129 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 130 */       double inputadapter_value12 = inputadapter_isNull12 ? -1.0 : (inputadapter_row.getDouble(12));
/* 131 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 132 */       double inputadapter_value13 = inputadapter_isNull13 ? -1.0 : (inputadapter_row.getDouble(13));
/* 133 */       boolean inputadapter_isNull14 = inputadapter_row.isNullAt(14);
/* 134 */       double inputadapter_value14 = inputadapter_isNull14 ? -1.0 : (inputadapter_row.getDouble(14));
/* 135 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 136 */       double inputadapter_value15 = inputadapter_isNull15 ? -1.0 : (inputadapter_row.getDouble(15));
/* 137 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 138 */       double inputadapter_value16 = inputadapter_isNull16 ? -1.0 : (inputadapter_row.getDouble(16));
/* 139 */       boolean inputadapter_isNull17 = inputadapter_row.isNullAt(17);
/* 140 */       double inputadapter_value17 = inputadapter_isNull17 ? -1.0 : (inputadapter_row.getDouble(17));
/* 141 */       boolean inputadapter_isNull18 = inputadapter_row.isNullAt(18);
/* 142 */       double inputadapter_value18 = inputadapter_isNull18 ? -1.0 : (inputadapter_row.getDouble(18));
/* 143 */       boolean inputadapter_isNull19 = inputadapter_row.isNullAt(19);
/* 144 */       double inputadapter_value19 = inputadapter_isNull19 ? -1.0 : (inputadapter_row.getDouble(19));
/* 145 */       boolean inputadapter_isNull20 = inputadapter_row.isNullAt(20);
/* 146 */       double inputadapter_value20 = inputadapter_isNull20 ? -1.0 : (inputadapter_row.getDouble(20));
/* 147 */       boolean inputadapter_isNull21 = inputadapter_row.isNullAt(21);
/* 148 */       double inputadapter_value21 = inputadapter_isNull21 ? -1.0 : (inputadapter_row.getDouble(21));
/* 149 */       boolean inputadapter_isNull22 = inputadapter_row.isNullAt(22);
/* 150 */       double inputadapter_value22 = inputadapter_isNull22 ? -1.0 : (inputadapter_row.getDouble(22));
/* 151 */       boolean inputadapter_isNull23 = inputadapter_row.isNullAt(23);
/* 152 */       double inputadapter_value23 = inputadapter_isNull23 ? -1.0 : (inputadapter_row.getDouble(23));
/* 153 */       boolean inputadapter_isNull24 = inputadapter_row.isNullAt(24);
/* 154 */       double inputadapter_value24 = inputadapter_isNull24 ? -1.0 : (inputadapter_row.getDouble(24));
/* 155 */       boolean inputadapter_isNull25 = inputadapter_row.isNullAt(25);
/* 156 */       double inputadapter_value25 = inputadapter_isNull25 ? -1.0 : (inputadapter_row.getDouble(25));
/* 157 */       boolean inputadapter_isNull26 = inputadapter_row.isNullAt(26);
/* 158 */       double inputadapter_value26 = inputadapter_isNull26 ? -1.0 : (inputadapter_row.getDouble(26));
/* 159 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 160 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 161 */       boolean inputadapter_isNull28 = inputadapter_row.isNullAt(28);
/* 162 */       double inputadapter_value28 = inputadapter_isNull28 ? -1.0 : (inputadapter_row.getDouble(28));
/* 163 */       boolean inputadapter_isNull29 = inputadapter_row.isNullAt(29);
/* 164 */       double inputadapter_value29 = inputadapter_isNull29 ? -1.0 : (inputadapter_row.getDouble(29));
/* 165 */       boolean inputadapter_isNull30 = inputadapter_row.isNullAt(30);
/* 166 */       double inputadapter_value30 = inputadapter_isNull30 ? -1.0 : (inputadapter_row.getDouble(30));
/* 167 */
/* 168 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 169 */
/* 170 */       UnsafeRow agg_fastAggBuffer = null;
/* 171 */
/* 172 */       if (agg_fastAggBuffer == null) {
/* 173 */         // generate grouping key
/* 174 */         agg_holder.reset();
/* 175 */
/* 176 */         agg_rowWriter.zeroOutNullBytes();
/* 177 */
/* 178 */         if (inputadapter_isNull) {
/* 179 */           agg_rowWriter.setNullAt(0);
/* 180 */         } else {
/* 181 */           agg_rowWriter.write(0, inputadapter_value);
/* 182 */         }
/* 183 */
/* 184 */         if (inputadapter_isNull1) {
/* 185 */           agg_rowWriter.setNullAt(1);
/* 186 */         } else {
/* 187 */           agg_rowWriter.write(1, inputadapter_value1);
/* 188 */         }
/* 189 */
/* 190 */         if (inputadapter_isNull2) {
/* 191 */           agg_rowWriter.setNullAt(2);
/* 192 */         } else {
/* 193 */           agg_rowWriter.write(2, inputadapter_value2);
/* 194 */         }
/* 195 */
/* 196 */         if (inputadapter_isNull3) {
/* 197 */           agg_rowWriter.setNullAt(3);
/* 198 */         } else {
/* 199 */           agg_rowWriter.write(3, inputadapter_value3);
/* 200 */         }
/* 201 */
/* 202 */         if (inputadapter_isNull4) {
/* 203 */           agg_rowWriter.setNullAt(4);
/* 204 */         } else {
/* 205 */           agg_rowWriter.write(4, inputadapter_value4);
/* 206 */         }
/* 207 */
/* 208 */         if (inputadapter_isNull5) {
/* 209 */           agg_rowWriter.setNullAt(5);
/* 210 */         } else {
/* 211 */           agg_rowWriter.write(5, inputadapter_value5);
/* 212 */         }
/* 213 */
/* 214 */         if (inputadapter_isNull6) {
/* 215 */           agg_rowWriter.setNullAt(6);
/* 216 */         } else {
/* 217 */           agg_rowWriter.write(6, inputadapter_value6);
/* 218 */         }
/* 219 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 220 */         agg_value62 = 42;
/* 221 */
/* 222 */         if (!inputadapter_isNull) {
/* 223 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value62);
/* 224 */         }
/* 225 */
/* 226 */         if (!inputadapter_isNull1) {
/* 227 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value62);
/* 228 */         }
/* 229 */
/* 230 */         if (!inputadapter_isNull2) {
/* 231 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value62);
/* 232 */         }
/* 233 */
/* 234 */         if (!inputadapter_isNull3) {
/* 235 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value3.getBaseObject(), inputadapter_value3.getBaseOffset(), inputadapter_value3.numBytes(), agg_value62);
/* 236 */         }
/* 237 */
/* 238 */         if (!inputadapter_isNull4) {
/* 239 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value4.getBaseObject(), inputadapter_value4.getBaseOffset(), inputadapter_value4.numBytes(), agg_value62);
/* 240 */         }
/* 241 */
/* 242 */         if (!inputadapter_isNull5) {
/* 243 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value5.getBaseObject(), inputadapter_value5.getBaseOffset(), inputadapter_value5.numBytes(), agg_value62);
/* 244 */         }
/* 245 */
/* 246 */         if (!inputadapter_isNull6) {
/* 247 */           agg_value62 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value6, agg_value62);
/* 248 */         }
/* 249 */         if (true) {
/* 250 */           // try to get the buffer from hash map
/* 251 */           agg_unsafeRowAggBuffer =
/* 252 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value62);
/* 253 */         }
/* 254 */         if (agg_unsafeRowAggBuffer == null) {
/* 255 */           if (agg_sorter == null) {
/* 256 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 257 */           } else {
/* 258 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 259 */           }
/* 260 */
/* 261 */           // the hash map had be spilled, it should have enough memory now,
/* 262 */           // try  to allocate buffer again.
/* 263 */           agg_unsafeRowAggBuffer =
/* 264 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value62);
/* 265 */           if (agg_unsafeRowAggBuffer == null) {
/* 266 */             // failed to allocate the first page
/* 267 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 268 */           }
/* 269 */         }
/* 270 */       }
/* 271 */
/* 272 */       if (agg_fastAggBuffer != null) {
/* 273 */         // update fast row
/* 274 */
/* 275 */       } else {
/* 276 */         // update unsafe row
/* 277 */
/* 278 */         // common sub-expressions
/* 279 */         boolean agg_isNull46 = false;
/* 280 */         double agg_value70 = -1.0;
/* 281 */         if (!false) {
/* 282 */           agg_value70 = (double) 0;
/* 283 */         }
/* 284 */         // evaluate aggregate function
/* 285 */         boolean agg_isNull49 = true;
/* 286 */         double agg_value73 = -1.0;
/* 287 */
/* 288 */         boolean agg_isNull51 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 289 */         double agg_value75 = agg_isNull51 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 290 */         boolean agg_isNull50 = agg_isNull51;
/* 291 */         double agg_value74 = agg_value75;
/* 292 */         if (agg_isNull50) {
/* 293 */           if (!agg_isNull46) {
/* 294 */             agg_isNull50 = false;
/* 295 */             agg_value74 = agg_value70;
/* 296 */           }
/* 297 */         }
/* 298 */
/* 299 */         if (!inputadapter_isNull7) {
/* 300 */           agg_isNull49 = false; // resultCode could change nullability.
/* 301 */           agg_value73 = agg_value74 + inputadapter_value7;
/* 302 */
/* 303 */         }
/* 304 */         boolean agg_isNull48 = agg_isNull49;
/* 305 */         double agg_value72 = agg_value73;
/* 306 */         if (agg_isNull48) {
/* 307 */           boolean agg_isNull53 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 308 */           double agg_value77 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 309 */           if (!agg_isNull53) {
/* 310 */             agg_isNull48 = false;
/* 311 */             agg_value72 = agg_value77;
/* 312 */           }
/* 313 */         }
/* 314 */         boolean agg_isNull55 = true;
/* 315 */         double agg_value79 = -1.0;
/* 316 */
/* 317 */         boolean agg_isNull57 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 318 */         double agg_value81 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 319 */         boolean agg_isNull56 = agg_isNull57;
/* 320 */         double agg_value80 = agg_value81;
/* 321 */         if (agg_isNull56) {
/* 322 */           if (!agg_isNull46) {
/* 323 */             agg_isNull56 = false;
/* 324 */             agg_value80 = agg_value70;
/* 325 */           }
/* 326 */         }
/* 327 */
/* 328 */         if (!inputadapter_isNull8) {
/* 329 */           agg_isNull55 = false; // resultCode could change nullability.
/* 330 */           agg_value79 = agg_value80 + inputadapter_value8;
/* 331 */
/* 332 */         }
/* 333 */         boolean agg_isNull54 = agg_isNull55;
/* 334 */         double agg_value78 = agg_value79;
/* 335 */         if (agg_isNull54) {
/* 336 */           boolean agg_isNull59 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 337 */           double agg_value83 = agg_isNull59 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 338 */           if (!agg_isNull59) {
/* 339 */             agg_isNull54 = false;
/* 340 */             agg_value78 = agg_value83;
/* 341 */           }
/* 342 */         }
/* 343 */         boolean agg_isNull61 = true;
/* 344 */         double agg_value85 = -1.0;
/* 345 */
/* 346 */         boolean agg_isNull63 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 347 */         double agg_value87 = agg_isNull63 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 348 */         boolean agg_isNull62 = agg_isNull63;
/* 349 */         double agg_value86 = agg_value87;
/* 350 */         if (agg_isNull62) {
/* 351 */           if (!agg_isNull46) {
/* 352 */             agg_isNull62 = false;
/* 353 */             agg_value86 = agg_value70;
/* 354 */           }
/* 355 */         }
/* 356 */
/* 357 */         if (!inputadapter_isNull9) {
/* 358 */           agg_isNull61 = false; // resultCode could change nullability.
/* 359 */           agg_value85 = agg_value86 + inputadapter_value9;
/* 360 */
/* 361 */         }
/* 362 */         boolean agg_isNull60 = agg_isNull61;
/* 363 */         double agg_value84 = agg_value85;
/* 364 */         if (agg_isNull60) {
/* 365 */           boolean agg_isNull65 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 366 */           double agg_value89 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(2));
/* 367 */           if (!agg_isNull65) {
/* 368 */             agg_isNull60 = false;
/* 369 */             agg_value84 = agg_value89;
/* 370 */           }
/* 371 */         }
/* 372 */         boolean agg_isNull67 = true;
/* 373 */         double agg_value91 = -1.0;
/* 374 */
/* 375 */         boolean agg_isNull69 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 376 */         double agg_value93 = agg_isNull69 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 377 */         boolean agg_isNull68 = agg_isNull69;
/* 378 */         double agg_value92 = agg_value93;
/* 379 */         if (agg_isNull68) {
/* 380 */           if (!agg_isNull46) {
/* 381 */             agg_isNull68 = false;
/* 382 */             agg_value92 = agg_value70;
/* 383 */           }
/* 384 */         }
/* 385 */
/* 386 */         if (!inputadapter_isNull10) {
/* 387 */           agg_isNull67 = false; // resultCode could change nullability.
/* 388 */           agg_value91 = agg_value92 + inputadapter_value10;
/* 389 */
/* 390 */         }
/* 391 */         boolean agg_isNull66 = agg_isNull67;
/* 392 */         double agg_value90 = agg_value91;
/* 393 */         if (agg_isNull66) {
/* 394 */           boolean agg_isNull71 = agg_unsafeRowAggBuffer.isNullAt(3);
/* 395 */           double agg_value95 = agg_isNull71 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(3));
/* 396 */           if (!agg_isNull71) {
/* 397 */             agg_isNull66 = false;
/* 398 */             agg_value90 = agg_value95;
/* 399 */           }
/* 400 */         }
/* 401 */         boolean agg_isNull73 = true;
/* 402 */         double agg_value97 = -1.0;
/* 403 */
/* 404 */         boolean agg_isNull75 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 405 */         double agg_value99 = agg_isNull75 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 406 */         boolean agg_isNull74 = agg_isNull75;
/* 407 */         double agg_value98 = agg_value99;
/* 408 */         if (agg_isNull74) {
/* 409 */           if (!agg_isNull46) {
/* 410 */             agg_isNull74 = false;
/* 411 */             agg_value98 = agg_value70;
/* 412 */           }
/* 413 */         }
/* 414 */
/* 415 */         if (!inputadapter_isNull11) {
/* 416 */           agg_isNull73 = false; // resultCode could change nullability.
/* 417 */           agg_value97 = agg_value98 + inputadapter_value11;
/* 418 */
/* 419 */         }
/* 420 */         boolean agg_isNull72 = agg_isNull73;
/* 421 */         double agg_value96 = agg_value97;
/* 422 */         if (agg_isNull72) {
/* 423 */           boolean agg_isNull77 = agg_unsafeRowAggBuffer.isNullAt(4);
/* 424 */           double agg_value101 = agg_isNull77 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(4));
/* 425 */           if (!agg_isNull77) {
/* 426 */             agg_isNull72 = false;
/* 427 */             agg_value96 = agg_value101;
/* 428 */           }
/* 429 */         }
/* 430 */         boolean agg_isNull79 = true;
/* 431 */         double agg_value103 = -1.0;
/* 432 */
/* 433 */         boolean agg_isNull81 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 434 */         double agg_value105 = agg_isNull81 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 435 */         boolean agg_isNull80 = agg_isNull81;
/* 436 */         double agg_value104 = agg_value105;
/* 437 */         if (agg_isNull80) {
/* 438 */           if (!agg_isNull46) {
/* 439 */             agg_isNull80 = false;
/* 440 */             agg_value104 = agg_value70;
/* 441 */           }
/* 442 */         }
/* 443 */
/* 444 */         if (!inputadapter_isNull12) {
/* 445 */           agg_isNull79 = false; // resultCode could change nullability.
/* 446 */           agg_value103 = agg_value104 + inputadapter_value12;
/* 447 */
/* 448 */         }
/* 449 */         boolean agg_isNull78 = agg_isNull79;
/* 450 */         double agg_value102 = agg_value103;
/* 451 */         if (agg_isNull78) {
/* 452 */           boolean agg_isNull83 = agg_unsafeRowAggBuffer.isNullAt(5);
/* 453 */           double agg_value107 = agg_isNull83 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(5));
/* 454 */           if (!agg_isNull83) {
/* 455 */             agg_isNull78 = false;
/* 456 */             agg_value102 = agg_value107;
/* 457 */           }
/* 458 */         }
/* 459 */         boolean agg_isNull85 = true;
/* 460 */         double agg_value109 = -1.0;
/* 461 */
/* 462 */         boolean agg_isNull87 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 463 */         double agg_value111 = agg_isNull87 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 464 */         boolean agg_isNull86 = agg_isNull87;
/* 465 */         double agg_value110 = agg_value111;
/* 466 */         if (agg_isNull86) {
/* 467 */           if (!agg_isNull46) {
/* 468 */             agg_isNull86 = false;
/* 469 */             agg_value110 = agg_value70;
/* 470 */           }
/* 471 */         }
/* 472 */
/* 473 */         if (!inputadapter_isNull13) {
/* 474 */           agg_isNull85 = false; // resultCode could change nullability.
/* 475 */           agg_value109 = agg_value110 + inputadapter_value13;
/* 476 */
/* 477 */         }
/* 478 */         boolean agg_isNull84 = agg_isNull85;
/* 479 */         double agg_value108 = agg_value109;
/* 480 */         if (agg_isNull84) {
/* 481 */           boolean agg_isNull89 = agg_unsafeRowAggBuffer.isNullAt(6);
/* 482 */           double agg_value113 = agg_isNull89 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(6));
/* 483 */           if (!agg_isNull89) {
/* 484 */             agg_isNull84 = false;
/* 485 */             agg_value108 = agg_value113;
/* 486 */           }
/* 487 */         }
/* 488 */         boolean agg_isNull91 = true;
/* 489 */         double agg_value115 = -1.0;
/* 490 */
/* 491 */         boolean agg_isNull93 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 492 */         double agg_value117 = agg_isNull93 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 493 */         boolean agg_isNull92 = agg_isNull93;
/* 494 */         double agg_value116 = agg_value117;
/* 495 */         if (agg_isNull92) {
/* 496 */           if (!agg_isNull46) {
/* 497 */             agg_isNull92 = false;
/* 498 */             agg_value116 = agg_value70;
/* 499 */           }
/* 500 */         }
/* 501 */
/* 502 */         if (!inputadapter_isNull14) {
/* 503 */           agg_isNull91 = false; // resultCode could change nullability.
/* 504 */           agg_value115 = agg_value116 + inputadapter_value14;
/* 505 */
/* 506 */         }
/* 507 */         boolean agg_isNull90 = agg_isNull91;
/* 508 */         double agg_value114 = agg_value115;
/* 509 */         if (agg_isNull90) {
/* 510 */           boolean agg_isNull95 = agg_unsafeRowAggBuffer.isNullAt(7);
/* 511 */           double agg_value119 = agg_isNull95 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(7));
/* 512 */           if (!agg_isNull95) {
/* 513 */             agg_isNull90 = false;
/* 514 */             agg_value114 = agg_value119;
/* 515 */           }
/* 516 */         }
/* 517 */         boolean agg_isNull97 = true;
/* 518 */         double agg_value121 = -1.0;
/* 519 */
/* 520 */         boolean agg_isNull99 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 521 */         double agg_value123 = agg_isNull99 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 522 */         boolean agg_isNull98 = agg_isNull99;
/* 523 */         double agg_value122 = agg_value123;
/* 524 */         if (agg_isNull98) {
/* 525 */           if (!agg_isNull46) {
/* 526 */             agg_isNull98 = false;
/* 527 */             agg_value122 = agg_value70;
/* 528 */           }
/* 529 */         }
/* 530 */
/* 531 */         if (!inputadapter_isNull15) {
/* 532 */           agg_isNull97 = false; // resultCode could change nullability.
/* 533 */           agg_value121 = agg_value122 + inputadapter_value15;
/* 534 */
/* 535 */         }
/* 536 */         boolean agg_isNull96 = agg_isNull97;
/* 537 */         double agg_value120 = agg_value121;
/* 538 */         if (agg_isNull96) {
/* 539 */           boolean agg_isNull101 = agg_unsafeRowAggBuffer.isNullAt(8);
/* 540 */           double agg_value125 = agg_isNull101 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(8));
/* 541 */           if (!agg_isNull101) {
/* 542 */             agg_isNull96 = false;
/* 543 */             agg_value120 = agg_value125;
/* 544 */           }
/* 545 */         }
/* 546 */         boolean agg_isNull103 = true;
/* 547 */         double agg_value127 = -1.0;
/* 548 */
/* 549 */         boolean agg_isNull105 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 550 */         double agg_value129 = agg_isNull105 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 551 */         boolean agg_isNull104 = agg_isNull105;
/* 552 */         double agg_value128 = agg_value129;
/* 553 */         if (agg_isNull104) {
/* 554 */           if (!agg_isNull46) {
/* 555 */             agg_isNull104 = false;
/* 556 */             agg_value128 = agg_value70;
/* 557 */           }
/* 558 */         }
/* 559 */
/* 560 */         if (!inputadapter_isNull16) {
/* 561 */           agg_isNull103 = false; // resultCode could change nullability.
/* 562 */           agg_value127 = agg_value128 + inputadapter_value16;
/* 563 */
/* 564 */         }
/* 565 */         boolean agg_isNull102 = agg_isNull103;
/* 566 */         double agg_value126 = agg_value127;
/* 567 */         if (agg_isNull102) {
/* 568 */           boolean agg_isNull107 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 569 */           double agg_value131 = agg_isNull107 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 570 */           if (!agg_isNull107) {
/* 571 */             agg_isNull102 = false;
/* 572 */             agg_value126 = agg_value131;
/* 573 */           }
/* 574 */         }
/* 575 */         boolean agg_isNull109 = true;
/* 576 */         double agg_value133 = -1.0;
/* 577 */
/* 578 */         boolean agg_isNull111 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 579 */         double agg_value135 = agg_isNull111 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 580 */         boolean agg_isNull110 = agg_isNull111;
/* 581 */         double agg_value134 = agg_value135;
/* 582 */         if (agg_isNull110) {
/* 583 */           if (!agg_isNull46) {
/* 584 */             agg_isNull110 = false;
/* 585 */             agg_value134 = agg_value70;
/* 586 */           }
/* 587 */         }
/* 588 */
/* 589 */         if (!inputadapter_isNull17) {
/* 590 */           agg_isNull109 = false; // resultCode could change nullability.
/* 591 */           agg_value133 = agg_value134 + inputadapter_value17;
/* 592 */
/* 593 */         }
/* 594 */         boolean agg_isNull108 = agg_isNull109;
/* 595 */         double agg_value132 = agg_value133;
/* 596 */         if (agg_isNull108) {
/* 597 */           boolean agg_isNull113 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 598 */           double agg_value137 = agg_isNull113 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(10));
/* 599 */           if (!agg_isNull113) {
/* 600 */             agg_isNull108 = false;
/* 601 */             agg_value132 = agg_value137;
/* 602 */           }
/* 603 */         }
/* 604 */         boolean agg_isNull115 = true;
/* 605 */         double agg_value139 = -1.0;
/* 606 */
/* 607 */         boolean agg_isNull117 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 608 */         double agg_value141 = agg_isNull117 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 609 */         boolean agg_isNull116 = agg_isNull117;
/* 610 */         double agg_value140 = agg_value141;
/* 611 */         if (agg_isNull116) {
/* 612 */           if (!agg_isNull46) {
/* 613 */             agg_isNull116 = false;
/* 614 */             agg_value140 = agg_value70;
/* 615 */           }
/* 616 */         }
/* 617 */
/* 618 */         if (!inputadapter_isNull18) {
/* 619 */           agg_isNull115 = false; // resultCode could change nullability.
/* 620 */           agg_value139 = agg_value140 + inputadapter_value18;
/* 621 */
/* 622 */         }
/* 623 */         boolean agg_isNull114 = agg_isNull115;
/* 624 */         double agg_value138 = agg_value139;
/* 625 */         if (agg_isNull114) {
/* 626 */           boolean agg_isNull119 = agg_unsafeRowAggBuffer.isNullAt(11);
/* 627 */           double agg_value143 = agg_isNull119 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(11));
/* 628 */           if (!agg_isNull119) {
/* 629 */             agg_isNull114 = false;
/* 630 */             agg_value138 = agg_value143;
/* 631 */           }
/* 632 */         }
/* 633 */         boolean agg_isNull121 = true;
/* 634 */         double agg_value145 = -1.0;
/* 635 */
/* 636 */         boolean agg_isNull123 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 637 */         double agg_value147 = agg_isNull123 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 638 */         boolean agg_isNull122 = agg_isNull123;
/* 639 */         double agg_value146 = agg_value147;
/* 640 */         if (agg_isNull122) {
/* 641 */           if (!agg_isNull46) {
/* 642 */             agg_isNull122 = false;
/* 643 */             agg_value146 = agg_value70;
/* 644 */           }
/* 645 */         }
/* 646 */
/* 647 */         if (!inputadapter_isNull19) {
/* 648 */           agg_isNull121 = false; // resultCode could change nullability.
/* 649 */           agg_value145 = agg_value146 + inputadapter_value19;
/* 650 */
/* 651 */         }
/* 652 */         boolean agg_isNull120 = agg_isNull121;
/* 653 */         double agg_value144 = agg_value145;
/* 654 */         if (agg_isNull120) {
/* 655 */           boolean agg_isNull125 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 656 */           double agg_value149 = agg_isNull125 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 657 */           if (!agg_isNull125) {
/* 658 */             agg_isNull120 = false;
/* 659 */             agg_value144 = agg_value149;
/* 660 */           }
/* 661 */         }
/* 662 */         boolean agg_isNull127 = true;
/* 663 */         double agg_value151 = -1.0;
/* 664 */
/* 665 */         boolean agg_isNull129 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 666 */         double agg_value153 = agg_isNull129 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 667 */         boolean agg_isNull128 = agg_isNull129;
/* 668 */         double agg_value152 = agg_value153;
/* 669 */         if (agg_isNull128) {
/* 670 */           if (!agg_isNull46) {
/* 671 */             agg_isNull128 = false;
/* 672 */             agg_value152 = agg_value70;
/* 673 */           }
/* 674 */         }
/* 675 */
/* 676 */         if (!inputadapter_isNull20) {
/* 677 */           agg_isNull127 = false; // resultCode could change nullability.
/* 678 */           agg_value151 = agg_value152 + inputadapter_value20;
/* 679 */
/* 680 */         }
/* 681 */         boolean agg_isNull126 = agg_isNull127;
/* 682 */         double agg_value150 = agg_value151;
/* 683 */         if (agg_isNull126) {
/* 684 */           boolean agg_isNull131 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 685 */           double agg_value155 = agg_isNull131 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(13));
/* 686 */           if (!agg_isNull131) {
/* 687 */             agg_isNull126 = false;
/* 688 */             agg_value150 = agg_value155;
/* 689 */           }
/* 690 */         }
/* 691 */         boolean agg_isNull133 = true;
/* 692 */         double agg_value157 = -1.0;
/* 693 */
/* 694 */         boolean agg_isNull135 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 695 */         double agg_value159 = agg_isNull135 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 696 */         boolean agg_isNull134 = agg_isNull135;
/* 697 */         double agg_value158 = agg_value159;
/* 698 */         if (agg_isNull134) {
/* 699 */           if (!agg_isNull46) {
/* 700 */             agg_isNull134 = false;
/* 701 */             agg_value158 = agg_value70;
/* 702 */           }
/* 703 */         }
/* 704 */
/* 705 */         if (!inputadapter_isNull21) {
/* 706 */           agg_isNull133 = false; // resultCode could change nullability.
/* 707 */           agg_value157 = agg_value158 + inputadapter_value21;
/* 708 */
/* 709 */         }
/* 710 */         boolean agg_isNull132 = agg_isNull133;
/* 711 */         double agg_value156 = agg_value157;
/* 712 */         if (agg_isNull132) {
/* 713 */           boolean agg_isNull137 = agg_unsafeRowAggBuffer.isNullAt(14);
/* 714 */           double agg_value161 = agg_isNull137 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(14));
/* 715 */           if (!agg_isNull137) {
/* 716 */             agg_isNull132 = false;
/* 717 */             agg_value156 = agg_value161;
/* 718 */           }
/* 719 */         }
/* 720 */         boolean agg_isNull139 = true;
/* 721 */         double agg_value163 = -1.0;
/* 722 */
/* 723 */         boolean agg_isNull141 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 724 */         double agg_value165 = agg_isNull141 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 725 */         boolean agg_isNull140 = agg_isNull141;
/* 726 */         double agg_value164 = agg_value165;
/* 727 */         if (agg_isNull140) {
/* 728 */           if (!agg_isNull46) {
/* 729 */             agg_isNull140 = false;
/* 730 */             agg_value164 = agg_value70;
/* 731 */           }
/* 732 */         }
/* 733 */
/* 734 */         if (!inputadapter_isNull22) {
/* 735 */           agg_isNull139 = false; // resultCode could change nullability.
/* 736 */           agg_value163 = agg_value164 + inputadapter_value22;
/* 737 */
/* 738 */         }
/* 739 */         boolean agg_isNull138 = agg_isNull139;
/* 740 */         double agg_value162 = agg_value163;
/* 741 */         if (agg_isNull138) {
/* 742 */           boolean agg_isNull143 = agg_unsafeRowAggBuffer.isNullAt(15);
/* 743 */           double agg_value167 = agg_isNull143 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(15));
/* 744 */           if (!agg_isNull143) {
/* 745 */             agg_isNull138 = false;
/* 746 */             agg_value162 = agg_value167;
/* 747 */           }
/* 748 */         }
/* 749 */         boolean agg_isNull145 = true;
/* 750 */         double agg_value169 = -1.0;
/* 751 */
/* 752 */         boolean agg_isNull147 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 753 */         double agg_value171 = agg_isNull147 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 754 */         boolean agg_isNull146 = agg_isNull147;
/* 755 */         double agg_value170 = agg_value171;
/* 756 */         if (agg_isNull146) {
/* 757 */           if (!agg_isNull46) {
/* 758 */             agg_isNull146 = false;
/* 759 */             agg_value170 = agg_value70;
/* 760 */           }
/* 761 */         }
/* 762 */
/* 763 */         if (!inputadapter_isNull23) {
/* 764 */           agg_isNull145 = false; // resultCode could change nullability.
/* 765 */           agg_value169 = agg_value170 + inputadapter_value23;
/* 766 */
/* 767 */         }
/* 768 */         boolean agg_isNull144 = agg_isNull145;
/* 769 */         double agg_value168 = agg_value169;
/* 770 */         if (agg_isNull144) {
/* 771 */           boolean agg_isNull149 = agg_unsafeRowAggBuffer.isNullAt(16);
/* 772 */           double agg_value173 = agg_isNull149 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(16));
/* 773 */           if (!agg_isNull149) {
/* 774 */             agg_isNull144 = false;
/* 775 */             agg_value168 = agg_value173;
/* 776 */           }
/* 777 */         }
/* 778 */         boolean agg_isNull151 = true;
/* 779 */         double agg_value175 = -1.0;
/* 780 */
/* 781 */         boolean agg_isNull153 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 782 */         double agg_value177 = agg_isNull153 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 783 */         boolean agg_isNull152 = agg_isNull153;
/* 784 */         double agg_value176 = agg_value177;
/* 785 */         if (agg_isNull152) {
/* 786 */           if (!agg_isNull46) {
/* 787 */             agg_isNull152 = false;
/* 788 */             agg_value176 = agg_value70;
/* 789 */           }
/* 790 */         }
/* 791 */
/* 792 */         if (!inputadapter_isNull24) {
/* 793 */           agg_isNull151 = false; // resultCode could change nullability.
/* 794 */           agg_value175 = agg_value176 + inputadapter_value24;
/* 795 */
/* 796 */         }
/* 797 */         boolean agg_isNull150 = agg_isNull151;
/* 798 */         double agg_value174 = agg_value175;
/* 799 */         if (agg_isNull150) {
/* 800 */           boolean agg_isNull155 = agg_unsafeRowAggBuffer.isNullAt(17);
/* 801 */           double agg_value179 = agg_isNull155 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(17));
/* 802 */           if (!agg_isNull155) {
/* 803 */             agg_isNull150 = false;
/* 804 */             agg_value174 = agg_value179;
/* 805 */           }
/* 806 */         }
/* 807 */         boolean agg_isNull157 = true;
/* 808 */         double agg_value181 = -1.0;
/* 809 */
/* 810 */         boolean agg_isNull159 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 811 */         double agg_value183 = agg_isNull159 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 812 */         boolean agg_isNull158 = agg_isNull159;
/* 813 */         double agg_value182 = agg_value183;
/* 814 */         if (agg_isNull158) {
/* 815 */           if (!agg_isNull46) {
/* 816 */             agg_isNull158 = false;
/* 817 */             agg_value182 = agg_value70;
/* 818 */           }
/* 819 */         }
/* 820 */
/* 821 */         if (!inputadapter_isNull25) {
/* 822 */           agg_isNull157 = false; // resultCode could change nullability.
/* 823 */           agg_value181 = agg_value182 + inputadapter_value25;
/* 824 */
/* 825 */         }
/* 826 */         boolean agg_isNull156 = agg_isNull157;
/* 827 */         double agg_value180 = agg_value181;
/* 828 */         if (agg_isNull156) {
/* 829 */           boolean agg_isNull161 = agg_unsafeRowAggBuffer.isNullAt(18);
/* 830 */           double agg_value185 = agg_isNull161 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(18));
/* 831 */           if (!agg_isNull161) {
/* 832 */             agg_isNull156 = false;
/* 833 */             agg_value180 = agg_value185;
/* 834 */           }
/* 835 */         }
/* 836 */         boolean agg_isNull163 = true;
/* 837 */         double agg_value187 = -1.0;
/* 838 */
/* 839 */         boolean agg_isNull165 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 840 */         double agg_value189 = agg_isNull165 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 841 */         boolean agg_isNull164 = agg_isNull165;
/* 842 */         double agg_value188 = agg_value189;
/* 843 */         if (agg_isNull164) {
/* 844 */           if (!agg_isNull46) {
/* 845 */             agg_isNull164 = false;
/* 846 */             agg_value188 = agg_value70;
/* 847 */           }
/* 848 */         }
/* 849 */
/* 850 */         if (!inputadapter_isNull26) {
/* 851 */           agg_isNull163 = false; // resultCode could change nullability.
/* 852 */           agg_value187 = agg_value188 + inputadapter_value26;
/* 853 */
/* 854 */         }
/* 855 */         boolean agg_isNull162 = agg_isNull163;
/* 856 */         double agg_value186 = agg_value187;
/* 857 */         if (agg_isNull162) {
/* 858 */           boolean agg_isNull167 = agg_unsafeRowAggBuffer.isNullAt(19);
/* 859 */           double agg_value191 = agg_isNull167 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(19));
/* 860 */           if (!agg_isNull167) {
/* 861 */             agg_isNull162 = false;
/* 862 */             agg_value186 = agg_value191;
/* 863 */           }
/* 864 */         }
/* 865 */         boolean agg_isNull169 = true;
/* 866 */         double agg_value193 = -1.0;
/* 867 */
/* 868 */         boolean agg_isNull171 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 869 */         double agg_value195 = agg_isNull171 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 870 */         boolean agg_isNull170 = agg_isNull171;
/* 871 */         double agg_value194 = agg_value195;
/* 872 */         if (agg_isNull170) {
/* 873 */           if (!agg_isNull46) {
/* 874 */             agg_isNull170 = false;
/* 875 */             agg_value194 = agg_value70;
/* 876 */           }
/* 877 */         }
/* 878 */
/* 879 */         if (!inputadapter_isNull27) {
/* 880 */           agg_isNull169 = false; // resultCode could change nullability.
/* 881 */           agg_value193 = agg_value194 + inputadapter_value27;
/* 882 */
/* 883 */         }
/* 884 */         boolean agg_isNull168 = agg_isNull169;
/* 885 */         double agg_value192 = agg_value193;
/* 886 */         if (agg_isNull168) {
/* 887 */           boolean agg_isNull173 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 888 */           double agg_value197 = agg_isNull173 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 889 */           if (!agg_isNull173) {
/* 890 */             agg_isNull168 = false;
/* 891 */             agg_value192 = agg_value197;
/* 892 */           }
/* 893 */         }
/* 894 */         boolean agg_isNull175 = true;
/* 895 */         double agg_value199 = -1.0;
/* 896 */
/* 897 */         boolean agg_isNull177 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 898 */         double agg_value201 = agg_isNull177 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 899 */         boolean agg_isNull176 = agg_isNull177;
/* 900 */         double agg_value200 = agg_value201;
/* 901 */         if (agg_isNull176) {
/* 902 */           if (!agg_isNull46) {
/* 903 */             agg_isNull176 = false;
/* 904 */             agg_value200 = agg_value70;
/* 905 */           }
/* 906 */         }
/* 907 */
/* 908 */         if (!inputadapter_isNull28) {
/* 909 */           agg_isNull175 = false; // resultCode could change nullability.
/* 910 */           agg_value199 = agg_value200 + inputadapter_value28;
/* 911 */
/* 912 */         }
/* 913 */         boolean agg_isNull174 = agg_isNull175;
/* 914 */         double agg_value198 = agg_value199;
/* 915 */         if (agg_isNull174) {
/* 916 */           boolean agg_isNull179 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 917 */           double agg_value203 = agg_isNull179 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(21));
/* 918 */           if (!agg_isNull179) {
/* 919 */             agg_isNull174 = false;
/* 920 */             agg_value198 = agg_value203;
/* 921 */           }
/* 922 */         }
/* 923 */         boolean agg_isNull181 = true;
/* 924 */         double agg_value205 = -1.0;
/* 925 */
/* 926 */         boolean agg_isNull183 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 927 */         double agg_value207 = agg_isNull183 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 928 */         boolean agg_isNull182 = agg_isNull183;
/* 929 */         double agg_value206 = agg_value207;
/* 930 */         if (agg_isNull182) {
/* 931 */           if (!agg_isNull46) {
/* 932 */             agg_isNull182 = false;
/* 933 */             agg_value206 = agg_value70;
/* 934 */           }
/* 935 */         }
/* 936 */
/* 937 */         if (!inputadapter_isNull29) {
/* 938 */           agg_isNull181 = false; // resultCode could change nullability.
/* 939 */           agg_value205 = agg_value206 + inputadapter_value29;
/* 940 */
/* 941 */         }
/* 942 */         boolean agg_isNull180 = agg_isNull181;
/* 943 */         double agg_value204 = agg_value205;
/* 944 */         if (agg_isNull180) {
/* 945 */           boolean agg_isNull185 = agg_unsafeRowAggBuffer.isNullAt(22);
/* 946 */           double agg_value209 = agg_isNull185 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(22));
/* 947 */           if (!agg_isNull185) {
/* 948 */             agg_isNull180 = false;
/* 949 */             agg_value204 = agg_value209;
/* 950 */           }
/* 951 */         }
/* 952 */         boolean agg_isNull187 = true;
/* 953 */         double agg_value211 = -1.0;
/* 954 */
/* 955 */         boolean agg_isNull189 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 956 */         double agg_value213 = agg_isNull189 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 957 */         boolean agg_isNull188 = agg_isNull189;
/* 958 */         double agg_value212 = agg_value213;
/* 959 */         if (agg_isNull188) {
/* 960 */           if (!agg_isNull46) {
/* 961 */             agg_isNull188 = false;
/* 962 */             agg_value212 = agg_value70;
/* 963 */           }
/* 964 */         }
/* 965 */
/* 966 */         if (!inputadapter_isNull30) {
/* 967 */           agg_isNull187 = false; // resultCode could change nullability.
/* 968 */           agg_value211 = agg_value212 + inputadapter_value30;
/* 969 */
/* 970 */         }
/* 971 */         boolean agg_isNull186 = agg_isNull187;
/* 972 */         double agg_value210 = agg_value211;
/* 973 */         if (agg_isNull186) {
/* 974 */           boolean agg_isNull191 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 975 */           double agg_value215 = agg_isNull191 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 976 */           if (!agg_isNull191) {
/* 977 */             agg_isNull186 = false;
/* 978 */             agg_value210 = agg_value215;
/* 979 */           }
/* 980 */         }
/* 981 */         // update unsafe row buffer
/* 982 */         if (!agg_isNull48) {
/* 983 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value72);
/* 984 */         } else {
/* 985 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 986 */         }
/* 987 */
/* 988 */         if (!agg_isNull54) {
/* 989 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value78);
/* 990 */         } else {
/* 991 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 992 */         }
/* 993 */
/* 994 */         if (!agg_isNull60) {
/* 995 */           agg_unsafeRowAggBuffer.setDouble(2, agg_value84);
/* 996 */         } else {
/* 997 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 998 */         }
/* 999 */
/* 1000 */         if (!agg_isNull66) {
/* 1001 */           agg_unsafeRowAggBuffer.setDouble(3, agg_value90);
/* 1002 */         } else {
/* 1003 */           agg_unsafeRowAggBuffer.setNullAt(3);
/* 1004 */         }
/* 1005 */
/* 1006 */         if (!agg_isNull72) {
/* 1007 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value96);
/* 1008 */         } else {
/* 1009 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1010 */         }
/* 1011 */
/* 1012 */         if (!agg_isNull78) {
/* 1013 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value102);
/* 1014 */         } else {
/* 1015 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 1016 */         }
/* 1017 */
/* 1018 */         if (!agg_isNull84) {
/* 1019 */           agg_unsafeRowAggBuffer.setDouble(6, agg_value108);
/* 1020 */         } else {
/* 1021 */           agg_unsafeRowAggBuffer.setNullAt(6);
/* 1022 */         }
/* 1023 */
/* 1024 */         if (!agg_isNull90) {
/* 1025 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value114);
/* 1026 */         } else {
/* 1027 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1028 */         }
/* 1029 */
/* 1030 */         if (!agg_isNull96) {
/* 1031 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value120);
/* 1032 */         } else {
/* 1033 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1034 */         }
/* 1035 */
/* 1036 */         if (!agg_isNull102) {
/* 1037 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value126);
/* 1038 */         } else {
/* 1039 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1040 */         }
/* 1041 */
/* 1042 */         if (!agg_isNull108) {
/* 1043 */           agg_unsafeRowAggBuffer.setDouble(10, agg_value132);
/* 1044 */         } else {
/* 1045 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 1046 */         }
/* 1047 */
/* 1048 */         if (!agg_isNull114) {
/* 1049 */           agg_unsafeRowAggBuffer.setDouble(11, agg_value138);
/* 1050 */         } else {
/* 1051 */           agg_unsafeRowAggBuffer.setNullAt(11);
/* 1052 */         }
/* 1053 */
/* 1054 */         if (!agg_isNull120) {
/* 1055 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value144);
/* 1056 */         } else {
/* 1057 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 1058 */         }
/* 1059 */
/* 1060 */         if (!agg_isNull126) {
/* 1061 */           agg_unsafeRowAggBuffer.setDouble(13, agg_value150);
/* 1062 */         } else {
/* 1063 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 1064 */         }
/* 1065 */
/* 1066 */         if (!agg_isNull132) {
/* 1067 */           agg_unsafeRowAggBuffer.setDouble(14, agg_value156);
/* 1068 */         } else {
/* 1069 */           agg_unsafeRowAggBuffer.setNullAt(14);
/* 1070 */         }
/* 1071 */
/* 1072 */         if (!agg_isNull138) {
/* 1073 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value162);
/* 1074 */         } else {
/* 1075 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 1076 */         }
/* 1077 */
/* 1078 */         if (!agg_isNull144) {
/* 1079 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value168);
/* 1080 */         } else {
/* 1081 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 1082 */         }
/* 1083 */
/* 1084 */         if (!agg_isNull150) {
/* 1085 */           agg_unsafeRowAggBuffer.setDouble(17, agg_value174);
/* 1086 */         } else {
/* 1087 */           agg_unsafeRowAggBuffer.setNullAt(17);
/* 1088 */         }
/* 1089 */
/* 1090 */         if (!agg_isNull156) {
/* 1091 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value180);
/* 1092 */         } else {
/* 1093 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 1094 */         }
/* 1095 */
/* 1096 */         if (!agg_isNull162) {
/* 1097 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value186);
/* 1098 */         } else {
/* 1099 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 1100 */         }
/* 1101 */
/* 1102 */         if (!agg_isNull168) {
/* 1103 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value192);
/* 1104 */         } else {
/* 1105 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 1106 */         }
/* 1107 */
/* 1108 */         if (!agg_isNull174) {
/* 1109 */           agg_unsafeRowAggBuffer.setDouble(21, agg_value198);
/* 1110 */         } else {
/* 1111 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 1112 */         }
/* 1113 */
/* 1114 */         if (!agg_isNull180) {
/* 1115 */           agg_unsafeRowAggBuffer.setDouble(22, agg_value204);
/* 1116 */         } else {
/* 1117 */           agg_unsafeRowAggBuffer.setNullAt(22);
/* 1118 */         }
/* 1119 */
/* 1120 */         if (!agg_isNull186) {
/* 1121 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value210);
/* 1122 */         } else {
/* 1123 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 1124 */         }
/* 1125 */
/* 1126 */       }
/* 1127 */       if (shouldStop()) return;
/* 1128 */     }
/* 1129 */
/* 1130 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1131 */   }
/* 1132 */
/* 1133 */   protected void processNext() throws java.io.IOException {
/* 1134 */     if (!agg_initAgg) {
/* 1135 */       agg_initAgg = true;
/* 1136 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1137 */       agg_doAggregateWithKeys();
/* 1138 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1139 */     }
/* 1140 */
/* 1141 */     // output the result
/* 1142 */
/* 1143 */     while (agg_mapIter.next()) {
/* 1144 */       wholestagecodegen_numOutputRows.add(1);
/* 1145 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1146 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1147 */
/* 1148 */       boolean agg_isNull192 = agg_aggKey.isNullAt(0);
/* 1149 */       UTF8String agg_value216 = agg_isNull192 ? null : (agg_aggKey.getUTF8String(0));
/* 1150 */       boolean agg_isNull193 = agg_aggKey.isNullAt(1);
/* 1151 */       int agg_value217 = agg_isNull193 ? -1 : (agg_aggKey.getInt(1));
/* 1152 */       boolean agg_isNull194 = agg_aggKey.isNullAt(2);
/* 1153 */       UTF8String agg_value218 = agg_isNull194 ? null : (agg_aggKey.getUTF8String(2));
/* 1154 */       boolean agg_isNull195 = agg_aggKey.isNullAt(3);
/* 1155 */       UTF8String agg_value219 = agg_isNull195 ? null : (agg_aggKey.getUTF8String(3));
/* 1156 */       boolean agg_isNull196 = agg_aggKey.isNullAt(4);
/* 1157 */       UTF8String agg_value220 = agg_isNull196 ? null : (agg_aggKey.getUTF8String(4));
/* 1158 */       boolean agg_isNull197 = agg_aggKey.isNullAt(5);
/* 1159 */       UTF8String agg_value221 = agg_isNull197 ? null : (agg_aggKey.getUTF8String(5));
/* 1160 */       boolean agg_isNull198 = agg_aggKey.isNullAt(6);
/* 1161 */       int agg_value222 = agg_isNull198 ? -1 : (agg_aggKey.getInt(6));
/* 1162 */       boolean agg_isNull199 = agg_aggBuffer.isNullAt(0);
/* 1163 */       double agg_value223 = agg_isNull199 ? -1.0 : (agg_aggBuffer.getDouble(0));
/* 1164 */       boolean agg_isNull200 = agg_aggBuffer.isNullAt(1);
/* 1165 */       double agg_value224 = agg_isNull200 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 1166 */       boolean agg_isNull201 = agg_aggBuffer.isNullAt(2);
/* 1167 */       double agg_value225 = agg_isNull201 ? -1.0 : (agg_aggBuffer.getDouble(2));
/* 1168 */       boolean agg_isNull202 = agg_aggBuffer.isNullAt(3);
/* 1169 */       double agg_value226 = agg_isNull202 ? -1.0 : (agg_aggBuffer.getDouble(3));
/* 1170 */       boolean agg_isNull203 = agg_aggBuffer.isNullAt(4);
/* 1171 */       double agg_value227 = agg_isNull203 ? -1.0 : (agg_aggBuffer.getDouble(4));
/* 1172 */       boolean agg_isNull204 = agg_aggBuffer.isNullAt(5);
/* 1173 */       double agg_value228 = agg_isNull204 ? -1.0 : (agg_aggBuffer.getDouble(5));
/* 1174 */       boolean agg_isNull205 = agg_aggBuffer.isNullAt(6);
/* 1175 */       double agg_value229 = agg_isNull205 ? -1.0 : (agg_aggBuffer.getDouble(6));
/* 1176 */       boolean agg_isNull206 = agg_aggBuffer.isNullAt(7);
/* 1177 */       double agg_value230 = agg_isNull206 ? -1.0 : (agg_aggBuffer.getDouble(7));
/* 1178 */       boolean agg_isNull207 = agg_aggBuffer.isNullAt(8);
/* 1179 */       double agg_value231 = agg_isNull207 ? -1.0 : (agg_aggBuffer.getDouble(8));
/* 1180 */       boolean agg_isNull208 = agg_aggBuffer.isNullAt(9);
/* 1181 */       double agg_value232 = agg_isNull208 ? -1.0 : (agg_aggBuffer.getDouble(9));
/* 1182 */       boolean agg_isNull209 = agg_aggBuffer.isNullAt(10);
/* 1183 */       double agg_value233 = agg_isNull209 ? -1.0 : (agg_aggBuffer.getDouble(10));
/* 1184 */       boolean agg_isNull210 = agg_aggBuffer.isNullAt(11);
/* 1185 */       double agg_value234 = agg_isNull210 ? -1.0 : (agg_aggBuffer.getDouble(11));
/* 1186 */       boolean agg_isNull211 = agg_aggBuffer.isNullAt(12);
/* 1187 */       double agg_value235 = agg_isNull211 ? -1.0 : (agg_aggBuffer.getDouble(12));
/* 1188 */       boolean agg_isNull212 = agg_aggBuffer.isNullAt(13);
/* 1189 */       double agg_value236 = agg_isNull212 ? -1.0 : (agg_aggBuffer.getDouble(13));
/* 1190 */       boolean agg_isNull213 = agg_aggBuffer.isNullAt(14);
/* 1191 */       double agg_value237 = agg_isNull213 ? -1.0 : (agg_aggBuffer.getDouble(14));
/* 1192 */       boolean agg_isNull214 = agg_aggBuffer.isNullAt(15);
/* 1193 */       double agg_value238 = agg_isNull214 ? -1.0 : (agg_aggBuffer.getDouble(15));
/* 1194 */       boolean agg_isNull215 = agg_aggBuffer.isNullAt(16);
/* 1195 */       double agg_value239 = agg_isNull215 ? -1.0 : (agg_aggBuffer.getDouble(16));
/* 1196 */       boolean agg_isNull216 = agg_aggBuffer.isNullAt(17);
/* 1197 */       double agg_value240 = agg_isNull216 ? -1.0 : (agg_aggBuffer.getDouble(17));
/* 1198 */       boolean agg_isNull217 = agg_aggBuffer.isNullAt(18);
/* 1199 */       double agg_value241 = agg_isNull217 ? -1.0 : (agg_aggBuffer.getDouble(18));
/* 1200 */       boolean agg_isNull218 = agg_aggBuffer.isNullAt(19);
/* 1201 */       double agg_value242 = agg_isNull218 ? -1.0 : (agg_aggBuffer.getDouble(19));
/* 1202 */       boolean agg_isNull219 = agg_aggBuffer.isNullAt(20);
/* 1203 */       double agg_value243 = agg_isNull219 ? -1.0 : (agg_aggBuffer.getDouble(20));
/* 1204 */       boolean agg_isNull220 = agg_aggBuffer.isNullAt(21);
/* 1205 */       double agg_value244 = agg_isNull220 ? -1.0 : (agg_aggBuffer.getDouble(21));
/* 1206 */       boolean agg_isNull221 = agg_aggBuffer.isNullAt(22);
/* 1207 */       double agg_value245 = agg_isNull221 ? -1.0 : (agg_aggBuffer.getDouble(22));
/* 1208 */       boolean agg_isNull222 = agg_aggBuffer.isNullAt(23);
/* 1209 */       double agg_value246 = agg_isNull222 ? -1.0 : (agg_aggBuffer.getDouble(23));
/* 1210 */
/* 1211 */       Object agg_obj = ((Expression) references[3]).eval(null);
/* 1212 */       UTF8String agg_value277 = (UTF8String) agg_obj;
/* 1213 */       agg_holder1.reset();
/* 1214 */
/* 1215 */       agg_rowWriter1.zeroOutNullBytes();
/* 1216 */
/* 1217 */       if (agg_isNull192) {
/* 1218 */         agg_rowWriter1.setNullAt(0);
/* 1219 */       } else {
/* 1220 */         agg_rowWriter1.write(0, agg_value216);
/* 1221 */       }
/* 1222 */
/* 1223 */       if (agg_isNull193) {
/* 1224 */         agg_rowWriter1.setNullAt(1);
/* 1225 */       } else {
/* 1226 */         agg_rowWriter1.write(1, agg_value217);
/* 1227 */       }
/* 1228 */
/* 1229 */       if (agg_isNull194) {
/* 1230 */         agg_rowWriter1.setNullAt(2);
/* 1231 */       } else {
/* 1232 */         agg_rowWriter1.write(2, agg_value218);
/* 1233 */       }
/* 1234 */
/* 1235 */       if (agg_isNull195) {
/* 1236 */         agg_rowWriter1.setNullAt(3);
/* 1237 */       } else {
/* 1238 */         agg_rowWriter1.write(3, agg_value219);
/* 1239 */       }
/* 1240 */
/* 1241 */       if (agg_isNull196) {
/* 1242 */         agg_rowWriter1.setNullAt(4);
/* 1243 */       } else {
/* 1244 */         agg_rowWriter1.write(4, agg_value220);
/* 1245 */       }
/* 1246 */
/* 1247 */       if (agg_isNull197) {
/* 1248 */         agg_rowWriter1.setNullAt(5);
/* 1249 */       } else {
/* 1250 */         agg_rowWriter1.write(5, agg_value221);
/* 1251 */       }
/* 1252 */
/* 1253 */       agg_rowWriter1.write(6, agg_value277);
/* 1254 */
/* 1255 */       if (agg_isNull198) {
/* 1256 */         agg_rowWriter1.setNullAt(7);
/* 1257 */       } else {
/* 1258 */         agg_rowWriter1.write(7, agg_value222);
/* 1259 */       }
/* 1260 */
/* 1261 */       if (agg_isNull199) {
/* 1262 */         agg_rowWriter1.setNullAt(8);
/* 1263 */       } else {
/* 1264 */         agg_rowWriter1.write(8, agg_value223);
/* 1265 */       }
/* 1266 */
/* 1267 */       if (agg_isNull200) {
/* 1268 */         agg_rowWriter1.setNullAt(9);
/* 1269 */       } else {
/* 1270 */         agg_rowWriter1.write(9, agg_value224);
/* 1271 */       }
/* 1272 */
/* 1273 */       if (agg_isNull201) {
/* 1274 */         agg_rowWriter1.setNullAt(10);
/* 1275 */       } else {
/* 1276 */         agg_rowWriter1.write(10, agg_value225);
/* 1277 */       }
/* 1278 */
/* 1279 */       if (agg_isNull202) {
/* 1280 */         agg_rowWriter1.setNullAt(11);
/* 1281 */       } else {
/* 1282 */         agg_rowWriter1.write(11, agg_value226);
/* 1283 */       }
/* 1284 */
/* 1285 */       if (agg_isNull203) {
/* 1286 */         agg_rowWriter1.setNullAt(12);
/* 1287 */       } else {
/* 1288 */         agg_rowWriter1.write(12, agg_value227);
/* 1289 */       }
/* 1290 */
/* 1291 */       if (agg_isNull204) {
/* 1292 */         agg_rowWriter1.setNullAt(13);
/* 1293 */       } else {
/* 1294 */         agg_rowWriter1.write(13, agg_value228);
/* 1295 */       }
/* 1296 */
/* 1297 */       if (agg_isNull205) {
/* 1298 */         agg_rowWriter1.setNullAt(14);
/* 1299 */       } else {
/* 1300 */         agg_rowWriter1.write(14, agg_value229);
/* 1301 */       }
/* 1302 */
/* 1303 */       if (agg_isNull206) {
/* 1304 */         agg_rowWriter1.setNullAt(15);
/* 1305 */       } else {
/* 1306 */         agg_rowWriter1.write(15, agg_value230);
/* 1307 */       }
/* 1308 */
/* 1309 */       if (agg_isNull207) {
/* 1310 */         agg_rowWriter1.setNullAt(16);
/* 1311 */       } else {
/* 1312 */         agg_rowWriter1.write(16, agg_value231);
/* 1313 */       }
/* 1314 */
/* 1315 */       if (agg_isNull208) {
/* 1316 */         agg_rowWriter1.setNullAt(17);
/* 1317 */       } else {
/* 1318 */         agg_rowWriter1.write(17, agg_value232);
/* 1319 */       }
/* 1320 */
/* 1321 */       if (agg_isNull209) {
/* 1322 */         agg_rowWriter1.setNullAt(18);
/* 1323 */       } else {
/* 1324 */         agg_rowWriter1.write(18, agg_value233);
/* 1325 */       }
/* 1326 */
/* 1327 */       if (agg_isNull210) {
/* 1328 */         agg_rowWriter1.setNullAt(19);
/* 1329 */       } else {
/* 1330 */         agg_rowWriter1.write(19, agg_value234);
/* 1331 */       }
/* 1332 */
/* 1333 */       if (agg_isNull211) {
/* 1334 */         agg_rowWriter1.setNullAt(20);
/* 1335 */       } else {
/* 1336 */         agg_rowWriter1.write(20, agg_value235);
/* 1337 */       }
/* 1338 */
/* 1339 */       if (agg_isNull212) {
/* 1340 */         agg_rowWriter1.setNullAt(21);
/* 1341 */       } else {
/* 1342 */         agg_rowWriter1.write(21, agg_value236);
/* 1343 */       }
/* 1344 */
/* 1345 */       if (agg_isNull213) {
/* 1346 */         agg_rowWriter1.setNullAt(22);
/* 1347 */       } else {
/* 1348 */         agg_rowWriter1.write(22, agg_value237);
/* 1349 */       }
/* 1350 */
/* 1351 */       if (agg_isNull214) {
/* 1352 */         agg_rowWriter1.setNullAt(23);
/* 1353 */       } else {
/* 1354 */         agg_rowWriter1.write(23, agg_value238);
/* 1355 */       }
/* 1356 */
/* 1357 */       if (agg_isNull215) {
/* 1358 */         agg_rowWriter1.setNullAt(24);
/* 1359 */       } else {
/* 1360 */         agg_rowWriter1.write(24, agg_value239);
/* 1361 */       }
/* 1362 */
/* 1363 */       if (agg_isNull216) {
/* 1364 */         agg_rowWriter1.setNullAt(25);
/* 1365 */       } else {
/* 1366 */         agg_rowWriter1.write(25, agg_value240);
/* 1367 */       }
/* 1368 */
/* 1369 */       if (agg_isNull217) {
/* 1370 */         agg_rowWriter1.setNullAt(26);
/* 1371 */       } else {
/* 1372 */         agg_rowWriter1.write(26, agg_value241);
/* 1373 */       }
/* 1374 */
/* 1375 */       if (agg_isNull218) {
/* 1376 */         agg_rowWriter1.setNullAt(27);
/* 1377 */       } else {
/* 1378 */         agg_rowWriter1.write(27, agg_value242);
/* 1379 */       }
/* 1380 */
/* 1381 */       if (agg_isNull219) {
/* 1382 */         agg_rowWriter1.setNullAt(28);
/* 1383 */       } else {
/* 1384 */         agg_rowWriter1.write(28, agg_value243);
/* 1385 */       }
/* 1386 */
/* 1387 */       if (agg_isNull220) {
/* 1388 */         agg_rowWriter1.setNullAt(29);
/* 1389 */       } else {
/* 1390 */         agg_rowWriter1.write(29, agg_value244);
/* 1391 */       }
/* 1392 */
/* 1393 */       if (agg_isNull221) {
/* 1394 */         agg_rowWriter1.setNullAt(30);
/* 1395 */       } else {
/* 1396 */         agg_rowWriter1.write(30, agg_value245);
/* 1397 */       }
/* 1398 */
/* 1399 */       if (agg_isNull222) {
/* 1400 */         agg_rowWriter1.setNullAt(31);
/* 1401 */       } else {
/* 1402 */         agg_rowWriter1.write(31, agg_value246);
/* 1403 */       }
/* 1404 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 1405 */       append(agg_result1);
/* 1406 */
/* 1407 */       if (shouldStop()) return;
/* 1408 */     }
/* 1409 */
/* 1410 */     agg_mapIter.close();
/* 1411 */     if (agg_sorter == null) {
/* 1412 */       agg_hashMap.free();
/* 1413 */     }
/* 1414 */   }
/* 1415 */ }
