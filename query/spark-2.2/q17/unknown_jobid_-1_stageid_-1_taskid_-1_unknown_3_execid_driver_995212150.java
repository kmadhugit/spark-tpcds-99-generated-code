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
/* 014 */   private long agg_bufValue2;
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
/* 030 */   private long agg_bufValue10;
/* 031 */   private boolean agg_bufIsNull11;
/* 032 */   private long agg_bufValue11;
/* 033 */   private boolean agg_bufIsNull12;
/* 034 */   private double agg_bufValue12;
/* 035 */   private boolean agg_bufIsNull13;
/* 036 */   private long agg_bufValue13;
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
/* 052 */   private long agg_bufValue21;
/* 053 */   private boolean agg_bufIsNull22;
/* 054 */   private long agg_bufValue22;
/* 055 */   private boolean agg_bufIsNull23;
/* 056 */   private double agg_bufValue23;
/* 057 */   private boolean agg_bufIsNull24;
/* 058 */   private long agg_bufValue24;
/* 059 */   private boolean agg_bufIsNull25;
/* 060 */   private double agg_bufValue25;
/* 061 */   private boolean agg_bufIsNull26;
/* 062 */   private double agg_bufValue26;
/* 063 */   private boolean agg_bufIsNull27;
/* 064 */   private double agg_bufValue27;
/* 065 */   private boolean agg_bufIsNull28;
/* 066 */   private double agg_bufValue28;
/* 067 */   private boolean agg_bufIsNull29;
/* 068 */   private long agg_bufValue29;
/* 069 */   private boolean agg_bufIsNull30;
/* 070 */   private double agg_bufValue30;
/* 071 */   private boolean agg_bufIsNull31;
/* 072 */   private double agg_bufValue31;
/* 073 */   private boolean agg_bufIsNull32;
/* 074 */   private double agg_bufValue32;
/* 075 */   private boolean agg_bufIsNull33;
/* 076 */   private double agg_bufValue33;
/* 077 */   private boolean agg_bufIsNull34;
/* 078 */   private long agg_bufValue34;
/* 079 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 080 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 081 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 082 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 083 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 084 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 085 */   private scala.collection.Iterator inputadapter_input;
/* 086 */   private UnsafeRow agg_result;
/* 087 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 088 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 089 */   private int agg_value83;
/* 090 */   private UnsafeRow agg_result1;
/* 091 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 092 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 093 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 094 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 095 */
/* 096 */   public GeneratedIterator(Object[] references) {
/* 097 */     this.references = references;
/* 098 */   }
/* 099 */
/* 100 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 101 */     partitionIndex = index;
/* 102 */     this.inputs = inputs;
/* 103 */     agg_initAgg = false;
/* 104 */
/* 105 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 106 */
/* 107 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 108 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 109 */     inputadapter_input = inputs[0];
/* 110 */     agg_result = new UnsafeRow(3);
/* 111 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 96);
/* 112 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 113 */
/* 114 */     agg_result1 = new UnsafeRow(15);
/* 115 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 96);
/* 116 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 15);
/* 117 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 118 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 119 */
/* 120 */   }
/* 121 */
/* 122 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 123 */     agg_hashMap = agg_plan.createHashMap();
/* 124 */
/* 125 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 126 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 127 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 128 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 129 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 130 */       UTF8String inputadapter_value1 = inputadapter_isNull1 ? null : (inputadapter_row.getUTF8String(1));
/* 131 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 132 */       UTF8String inputadapter_value2 = inputadapter_isNull2 ? null : (inputadapter_row.getUTF8String(2));
/* 133 */       long inputadapter_value3 = inputadapter_row.getLong(3);
/* 134 */       boolean inputadapter_isNull4 = inputadapter_row.isNullAt(4);
/* 135 */       double inputadapter_value4 = inputadapter_isNull4 ? -1.0 : (inputadapter_row.getDouble(4));
/* 136 */       boolean inputadapter_isNull5 = inputadapter_row.isNullAt(5);
/* 137 */       long inputadapter_value5 = inputadapter_isNull5 ? -1L : (inputadapter_row.getLong(5));
/* 138 */       double inputadapter_value6 = inputadapter_row.getDouble(6);
/* 139 */       double inputadapter_value7 = inputadapter_row.getDouble(7);
/* 140 */       double inputadapter_value8 = inputadapter_row.getDouble(8);
/* 141 */       double inputadapter_value9 = inputadapter_row.getDouble(9);
/* 142 */       double inputadapter_value10 = inputadapter_row.getDouble(10);
/* 143 */       double inputadapter_value11 = inputadapter_row.getDouble(11);
/* 144 */       boolean inputadapter_isNull12 = inputadapter_row.isNullAt(12);
/* 145 */       double inputadapter_value12 = inputadapter_isNull12 ? -1.0 : (inputadapter_row.getDouble(12));
/* 146 */       boolean inputadapter_isNull13 = inputadapter_row.isNullAt(13);
/* 147 */       long inputadapter_value13 = inputadapter_isNull13 ? -1L : (inputadapter_row.getLong(13));
/* 148 */       long inputadapter_value14 = inputadapter_row.getLong(14);
/* 149 */       boolean inputadapter_isNull15 = inputadapter_row.isNullAt(15);
/* 150 */       double inputadapter_value15 = inputadapter_isNull15 ? -1.0 : (inputadapter_row.getDouble(15));
/* 151 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 152 */       long inputadapter_value16 = inputadapter_isNull16 ? -1L : (inputadapter_row.getLong(16));
/* 153 */       double inputadapter_value17 = inputadapter_row.getDouble(17);
/* 154 */       double inputadapter_value18 = inputadapter_row.getDouble(18);
/* 155 */       double inputadapter_value19 = inputadapter_row.getDouble(19);
/* 156 */       double inputadapter_value20 = inputadapter_row.getDouble(20);
/* 157 */       double inputadapter_value21 = inputadapter_row.getDouble(21);
/* 158 */       double inputadapter_value22 = inputadapter_row.getDouble(22);
/* 159 */       boolean inputadapter_isNull23 = inputadapter_row.isNullAt(23);
/* 160 */       double inputadapter_value23 = inputadapter_isNull23 ? -1.0 : (inputadapter_row.getDouble(23));
/* 161 */       boolean inputadapter_isNull24 = inputadapter_row.isNullAt(24);
/* 162 */       long inputadapter_value24 = inputadapter_isNull24 ? -1L : (inputadapter_row.getLong(24));
/* 163 */       long inputadapter_value25 = inputadapter_row.getLong(25);
/* 164 */       boolean inputadapter_isNull26 = inputadapter_row.isNullAt(26);
/* 165 */       double inputadapter_value26 = inputadapter_isNull26 ? -1.0 : (inputadapter_row.getDouble(26));
/* 166 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 167 */       long inputadapter_value27 = inputadapter_isNull27 ? -1L : (inputadapter_row.getLong(27));
/* 168 */       double inputadapter_value28 = inputadapter_row.getDouble(28);
/* 169 */       double inputadapter_value29 = inputadapter_row.getDouble(29);
/* 170 */       double inputadapter_value30 = inputadapter_row.getDouble(30);
/* 171 */       boolean inputadapter_isNull31 = inputadapter_row.isNullAt(31);
/* 172 */       double inputadapter_value31 = inputadapter_isNull31 ? -1.0 : (inputadapter_row.getDouble(31));
/* 173 */       boolean inputadapter_isNull32 = inputadapter_row.isNullAt(32);
/* 174 */       long inputadapter_value32 = inputadapter_isNull32 ? -1L : (inputadapter_row.getLong(32));
/* 175 */       double inputadapter_value33 = inputadapter_row.getDouble(33);
/* 176 */       double inputadapter_value34 = inputadapter_row.getDouble(34);
/* 177 */       double inputadapter_value35 = inputadapter_row.getDouble(35);
/* 178 */       boolean inputadapter_isNull36 = inputadapter_row.isNullAt(36);
/* 179 */       double inputadapter_value36 = inputadapter_isNull36 ? -1.0 : (inputadapter_row.getDouble(36));
/* 180 */       boolean inputadapter_isNull37 = inputadapter_row.isNullAt(37);
/* 181 */       long inputadapter_value37 = inputadapter_isNull37 ? -1L : (inputadapter_row.getLong(37));
/* 182 */
/* 183 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 184 */
/* 185 */       UnsafeRow agg_fastAggBuffer = null;
/* 186 */
/* 187 */       if (agg_fastAggBuffer == null) {
/* 188 */         // generate grouping key
/* 189 */         agg_holder.reset();
/* 190 */
/* 191 */         agg_rowWriter.zeroOutNullBytes();
/* 192 */
/* 193 */         if (inputadapter_isNull) {
/* 194 */           agg_rowWriter.setNullAt(0);
/* 195 */         } else {
/* 196 */           agg_rowWriter.write(0, inputadapter_value);
/* 197 */         }
/* 198 */
/* 199 */         if (inputadapter_isNull1) {
/* 200 */           agg_rowWriter.setNullAt(1);
/* 201 */         } else {
/* 202 */           agg_rowWriter.write(1, inputadapter_value1);
/* 203 */         }
/* 204 */
/* 205 */         if (inputadapter_isNull2) {
/* 206 */           agg_rowWriter.setNullAt(2);
/* 207 */         } else {
/* 208 */           agg_rowWriter.write(2, inputadapter_value2);
/* 209 */         }
/* 210 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 211 */         agg_value83 = 42;
/* 212 */
/* 213 */         if (!inputadapter_isNull) {
/* 214 */           agg_value83 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value83);
/* 215 */         }
/* 216 */
/* 217 */         if (!inputadapter_isNull1) {
/* 218 */           agg_value83 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value1.getBaseObject(), inputadapter_value1.getBaseOffset(), inputadapter_value1.numBytes(), agg_value83);
/* 219 */         }
/* 220 */
/* 221 */         if (!inputadapter_isNull2) {
/* 222 */           agg_value83 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value2.getBaseObject(), inputadapter_value2.getBaseOffset(), inputadapter_value2.numBytes(), agg_value83);
/* 223 */         }
/* 224 */         if (true) {
/* 225 */           // try to get the buffer from hash map
/* 226 */           agg_unsafeRowAggBuffer =
/* 227 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value83);
/* 228 */         }
/* 229 */         if (agg_unsafeRowAggBuffer == null) {
/* 230 */           if (agg_sorter == null) {
/* 231 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 232 */           } else {
/* 233 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 234 */           }
/* 235 */
/* 236 */           // the hash map had be spilled, it should have enough memory now,
/* 237 */           // try  to allocate buffer again.
/* 238 */           agg_unsafeRowAggBuffer =
/* 239 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value83);
/* 240 */           if (agg_unsafeRowAggBuffer == null) {
/* 241 */             // failed to allocate the first page
/* 242 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 243 */           }
/* 244 */         }
/* 245 */       }
/* 246 */
/* 247 */       if (agg_fastAggBuffer != null) {
/* 248 */         // update fast row
/* 249 */
/* 250 */       } else {
/* 251 */         // update unsafe row
/* 252 */
/* 253 */         // common sub-expressions
/* 254 */         boolean agg_isNull53 = false;
/* 255 */
/* 256 */         boolean agg_isNull54 = false;
/* 257 */
/* 258 */         double agg_value90 = agg_unsafeRowAggBuffer.getDouble(14);
/* 259 */
/* 260 */         double agg_value89 = -1.0;
/* 261 */         agg_value89 = agg_value90 + inputadapter_value17;
/* 262 */
/* 263 */         boolean agg_value88 = false;
/* 264 */         agg_value88 = (java.lang.Double.isNaN(agg_value89) && java.lang.Double.isNaN(0.0D)) || agg_value89 == 0.0D;
/* 265 */         boolean agg_isNull52 = false;
/* 266 */         double agg_value87 = -1.0;
/* 267 */         if (!false && agg_value88) {
/* 268 */           agg_isNull52 = false;
/* 269 */           agg_value87 = 0.0D;
/* 270 */         } else {
/* 271 */           boolean agg_isNull63 = false;
/* 272 */
/* 273 */           double agg_value99 = agg_unsafeRowAggBuffer.getDouble(14);
/* 274 */
/* 275 */           double agg_value98 = -1.0;
/* 276 */           agg_value98 = agg_value99 + inputadapter_value17;
/* 277 */           boolean agg_isNull59 = false;
/* 278 */           double agg_value94 = -1.0;
/* 279 */           if (agg_value98 == 0) {
/* 280 */             agg_isNull59 = true;
/* 281 */           } else {
/* 282 */             boolean agg_isNull60 = false;
/* 283 */
/* 284 */             double agg_value97 = agg_unsafeRowAggBuffer.getDouble(15);
/* 285 */             double agg_value95 = -1.0;
/* 286 */             agg_value95 = inputadapter_value18 - agg_value97;
/* 287 */             agg_value94 = (double)(agg_value95 / agg_value98);
/* 288 */           }
/* 289 */           agg_isNull52 = agg_isNull59;
/* 290 */           agg_value87 = agg_value94;
/* 291 */         }
/* 292 */         boolean agg_isNull66 = false;
/* 293 */
/* 294 */         double agg_value102 = agg_unsafeRowAggBuffer.getDouble(6);
/* 295 */
/* 296 */         double agg_value101 = -1.0;
/* 297 */         agg_value101 = agg_value102 + inputadapter_value9;
/* 298 */         boolean agg_isNull70 = false;
/* 299 */
/* 300 */         boolean agg_isNull71 = false;
/* 301 */
/* 302 */         double agg_value107 = agg_unsafeRowAggBuffer.getDouble(17);
/* 303 */
/* 304 */         double agg_value106 = -1.0;
/* 305 */         agg_value106 = agg_value107 + inputadapter_value20;
/* 306 */
/* 307 */         boolean agg_value105 = false;
/* 308 */         agg_value105 = (java.lang.Double.isNaN(agg_value106) && java.lang.Double.isNaN(0.0D)) || agg_value106 == 0.0D;
/* 309 */         boolean agg_isNull69 = false;
/* 310 */         double agg_value104 = -1.0;
/* 311 */         if (!false && agg_value105) {
/* 312 */           agg_isNull69 = false;
/* 313 */           agg_value104 = 0.0D;
/* 314 */         } else {
/* 315 */           boolean agg_isNull80 = false;
/* 316 */
/* 317 */           double agg_value116 = agg_unsafeRowAggBuffer.getDouble(17);
/* 318 */
/* 319 */           double agg_value115 = -1.0;
/* 320 */           agg_value115 = agg_value116 + inputadapter_value20;
/* 321 */           boolean agg_isNull76 = false;
/* 322 */           double agg_value111 = -1.0;
/* 323 */           if (agg_value115 == 0) {
/* 324 */             agg_isNull76 = true;
/* 325 */           } else {
/* 326 */             boolean agg_isNull77 = false;
/* 327 */
/* 328 */             double agg_value114 = agg_unsafeRowAggBuffer.getDouble(18);
/* 329 */             double agg_value112 = -1.0;
/* 330 */             agg_value112 = inputadapter_value21 - agg_value114;
/* 331 */             agg_value111 = (double)(agg_value112 / agg_value115);
/* 332 */           }
/* 333 */           agg_isNull69 = agg_isNull76;
/* 334 */           agg_value104 = agg_value111;
/* 335 */         }
/* 336 */         boolean agg_isNull83 = false;
/* 337 */
/* 338 */         double agg_value119 = agg_unsafeRowAggBuffer.getDouble(30);
/* 339 */
/* 340 */         double agg_value118 = -1.0;
/* 341 */         agg_value118 = agg_value119 + inputadapter_value33;
/* 342 */         boolean agg_isNull87 = false;
/* 343 */
/* 344 */         boolean agg_isNull88 = false;
/* 345 */
/* 346 */         double agg_value124 = agg_unsafeRowAggBuffer.getDouble(30);
/* 347 */
/* 348 */         double agg_value123 = -1.0;
/* 349 */         agg_value123 = agg_value124 + inputadapter_value33;
/* 350 */
/* 351 */         boolean agg_value122 = false;
/* 352 */         agg_value122 = (java.lang.Double.isNaN(agg_value123) && java.lang.Double.isNaN(0.0D)) || agg_value123 == 0.0D;
/* 353 */         boolean agg_isNull86 = false;
/* 354 */         double agg_value121 = -1.0;
/* 355 */         if (!false && agg_value122) {
/* 356 */           agg_isNull86 = false;
/* 357 */           agg_value121 = 0.0D;
/* 358 */         } else {
/* 359 */           boolean agg_isNull97 = false;
/* 360 */
/* 361 */           double agg_value133 = agg_unsafeRowAggBuffer.getDouble(30);
/* 362 */
/* 363 */           double agg_value132 = -1.0;
/* 364 */           agg_value132 = agg_value133 + inputadapter_value33;
/* 365 */           boolean agg_isNull93 = false;
/* 366 */           double agg_value128 = -1.0;
/* 367 */           if (agg_value132 == 0) {
/* 368 */             agg_isNull93 = true;
/* 369 */           } else {
/* 370 */             boolean agg_isNull94 = false;
/* 371 */
/* 372 */             double agg_value131 = agg_unsafeRowAggBuffer.getDouble(31);
/* 373 */             double agg_value129 = -1.0;
/* 374 */             agg_value129 = inputadapter_value34 - agg_value131;
/* 375 */             agg_value128 = (double)(agg_value129 / agg_value132);
/* 376 */           }
/* 377 */           agg_isNull86 = agg_isNull93;
/* 378 */           agg_value121 = agg_value128;
/* 379 */         }
/* 380 */         boolean agg_isNull100 = false;
/* 381 */
/* 382 */         double agg_value136 = agg_unsafeRowAggBuffer.getDouble(14);
/* 383 */
/* 384 */         double agg_value135 = -1.0;
/* 385 */         agg_value135 = agg_value136 + inputadapter_value17;
/* 386 */         boolean agg_isNull104 = false;
/* 387 */
/* 388 */         boolean agg_isNull105 = false;
/* 389 */
/* 390 */         double agg_value141 = agg_unsafeRowAggBuffer.getDouble(3);
/* 391 */
/* 392 */         double agg_value140 = -1.0;
/* 393 */         agg_value140 = agg_value141 + inputadapter_value6;
/* 394 */
/* 395 */         boolean agg_value139 = false;
/* 396 */         agg_value139 = (java.lang.Double.isNaN(agg_value140) && java.lang.Double.isNaN(0.0D)) || agg_value140 == 0.0D;
/* 397 */         boolean agg_isNull103 = false;
/* 398 */         double agg_value138 = -1.0;
/* 399 */         if (!false && agg_value139) {
/* 400 */           agg_isNull103 = false;
/* 401 */           agg_value138 = 0.0D;
/* 402 */         } else {
/* 403 */           boolean agg_isNull114 = false;
/* 404 */
/* 405 */           double agg_value150 = agg_unsafeRowAggBuffer.getDouble(3);
/* 406 */
/* 407 */           double agg_value149 = -1.0;
/* 408 */           agg_value149 = agg_value150 + inputadapter_value6;
/* 409 */           boolean agg_isNull110 = false;
/* 410 */           double agg_value145 = -1.0;
/* 411 */           if (agg_value149 == 0) {
/* 412 */             agg_isNull110 = true;
/* 413 */           } else {
/* 414 */             boolean agg_isNull111 = false;
/* 415 */
/* 416 */             double agg_value148 = agg_unsafeRowAggBuffer.getDouble(4);
/* 417 */             double agg_value146 = -1.0;
/* 418 */             agg_value146 = inputadapter_value7 - agg_value148;
/* 419 */             agg_value145 = (double)(agg_value146 / agg_value149);
/* 420 */           }
/* 421 */           agg_isNull103 = agg_isNull110;
/* 422 */           agg_value138 = agg_value145;
/* 423 */         }
/* 424 */         boolean agg_isNull117 = false;
/* 425 */
/* 426 */         double agg_value153 = agg_unsafeRowAggBuffer.getDouble(17);
/* 427 */
/* 428 */         double agg_value152 = -1.0;
/* 429 */         agg_value152 = agg_value153 + inputadapter_value20;
/* 430 */         boolean agg_isNull121 = false;
/* 431 */
/* 432 */         boolean agg_isNull122 = false;
/* 433 */
/* 434 */         double agg_value158 = agg_unsafeRowAggBuffer.getDouble(25);
/* 435 */
/* 436 */         double agg_value157 = -1.0;
/* 437 */         agg_value157 = agg_value158 + inputadapter_value28;
/* 438 */
/* 439 */         boolean agg_value156 = false;
/* 440 */         agg_value156 = (java.lang.Double.isNaN(agg_value157) && java.lang.Double.isNaN(0.0D)) || agg_value157 == 0.0D;
/* 441 */         boolean agg_isNull120 = false;
/* 442 */         double agg_value155 = -1.0;
/* 443 */         if (!false && agg_value156) {
/* 444 */           agg_isNull120 = false;
/* 445 */           agg_value155 = 0.0D;
/* 446 */         } else {
/* 447 */           boolean agg_isNull131 = false;
/* 448 */
/* 449 */           double agg_value167 = agg_unsafeRowAggBuffer.getDouble(25);
/* 450 */
/* 451 */           double agg_value166 = -1.0;
/* 452 */           agg_value166 = agg_value167 + inputadapter_value28;
/* 453 */           boolean agg_isNull127 = false;
/* 454 */           double agg_value162 = -1.0;
/* 455 */           if (agg_value166 == 0) {
/* 456 */             agg_isNull127 = true;
/* 457 */           } else {
/* 458 */             boolean agg_isNull128 = false;
/* 459 */
/* 460 */             double agg_value165 = agg_unsafeRowAggBuffer.getDouble(26);
/* 461 */             double agg_value163 = -1.0;
/* 462 */             agg_value163 = inputadapter_value29 - agg_value165;
/* 463 */             agg_value162 = (double)(agg_value163 / agg_value166);
/* 464 */           }
/* 465 */           agg_isNull120 = agg_isNull127;
/* 466 */           agg_value155 = agg_value162;
/* 467 */         }
/* 468 */         boolean agg_isNull134 = false;
/* 469 */
/* 470 */         double agg_value170 = agg_unsafeRowAggBuffer.getDouble(25);
/* 471 */
/* 472 */         double agg_value169 = -1.0;
/* 473 */         agg_value169 = agg_value170 + inputadapter_value28;
/* 474 */         boolean agg_isNull137 = false;
/* 475 */
/* 476 */         double agg_value173 = agg_unsafeRowAggBuffer.getDouble(3);
/* 477 */
/* 478 */         double agg_value172 = -1.0;
/* 479 */         agg_value172 = agg_value173 + inputadapter_value6;
/* 480 */         boolean agg_isNull141 = false;
/* 481 */
/* 482 */         boolean agg_isNull142 = false;
/* 483 */
/* 484 */         double agg_value178 = agg_unsafeRowAggBuffer.getDouble(6);
/* 485 */
/* 486 */         double agg_value177 = -1.0;
/* 487 */         agg_value177 = agg_value178 + inputadapter_value9;
/* 488 */
/* 489 */         boolean agg_value176 = false;
/* 490 */         agg_value176 = (java.lang.Double.isNaN(agg_value177) && java.lang.Double.isNaN(0.0D)) || agg_value177 == 0.0D;
/* 491 */         boolean agg_isNull140 = false;
/* 492 */         double agg_value175 = -1.0;
/* 493 */         if (!false && agg_value176) {
/* 494 */           agg_isNull140 = false;
/* 495 */           agg_value175 = 0.0D;
/* 496 */         } else {
/* 497 */           boolean agg_isNull151 = false;
/* 498 */
/* 499 */           double agg_value187 = agg_unsafeRowAggBuffer.getDouble(6);
/* 500 */
/* 501 */           double agg_value186 = -1.0;
/* 502 */           agg_value186 = agg_value187 + inputadapter_value9;
/* 503 */           boolean agg_isNull147 = false;
/* 504 */           double agg_value182 = -1.0;
/* 505 */           if (agg_value186 == 0) {
/* 506 */             agg_isNull147 = true;
/* 507 */           } else {
/* 508 */             boolean agg_isNull148 = false;
/* 509 */
/* 510 */             double agg_value185 = agg_unsafeRowAggBuffer.getDouble(7);
/* 511 */             double agg_value183 = -1.0;
/* 512 */             agg_value183 = inputadapter_value10 - agg_value185;
/* 513 */             agg_value182 = (double)(agg_value183 / agg_value186);
/* 514 */           }
/* 515 */           agg_isNull140 = agg_isNull147;
/* 516 */           agg_value175 = agg_value182;
/* 517 */         }
/* 518 */         // evaluate aggregate function
/* 519 */         boolean agg_isNull154 = false;
/* 520 */
/* 521 */         long agg_value190 = agg_unsafeRowAggBuffer.getLong(0);
/* 522 */
/* 523 */         long agg_value189 = -1L;
/* 524 */         agg_value189 = agg_value190 + inputadapter_value3;
/* 525 */         boolean agg_isNull157 = true;
/* 526 */         double agg_value192 = -1.0;
/* 527 */
/* 528 */         boolean agg_isNull158 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 529 */         double agg_value193 = agg_isNull158 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 530 */         if (!agg_isNull158) {
/* 531 */           if (!inputadapter_isNull4) {
/* 532 */             agg_isNull157 = false; // resultCode could change nullability.
/* 533 */             agg_value192 = agg_value193 + inputadapter_value4;
/* 534 */
/* 535 */           }
/* 536 */
/* 537 */         }
/* 538 */         boolean agg_isNull160 = true;
/* 539 */         long agg_value195 = -1L;
/* 540 */
/* 541 */         boolean agg_isNull161 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 542 */         long agg_value196 = agg_isNull161 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 543 */         if (!agg_isNull161) {
/* 544 */           if (!inputadapter_isNull5) {
/* 545 */             agg_isNull160 = false; // resultCode could change nullability.
/* 546 */             agg_value195 = agg_value196 + inputadapter_value5;
/* 547 */
/* 548 */           }
/* 549 */
/* 550 */         }
/* 551 */         boolean agg_isNull163 = true;
/* 552 */         double agg_value198 = -1.0;
/* 553 */
/* 554 */         double agg_value199 = agg_unsafeRowAggBuffer.getDouble(4);
/* 555 */
/* 556 */         boolean agg_isNull165 = true;
/* 557 */         double agg_value200 = -1.0;
/* 558 */
/* 559 */         if (!agg_isNull103) {
/* 560 */           agg_isNull165 = false; // resultCode could change nullability.
/* 561 */           agg_value200 = agg_value138 * inputadapter_value6;
/* 562 */
/* 563 */         }
/* 564 */         if (!agg_isNull165) {
/* 565 */           agg_isNull163 = false; // resultCode could change nullability.
/* 566 */           agg_value198 = agg_value199 + agg_value200;
/* 567 */
/* 568 */         }
/* 569 */         boolean agg_isNull167 = true;
/* 570 */         double agg_value202 = -1.0;
/* 571 */
/* 572 */         boolean agg_isNull168 = false;
/* 573 */
/* 574 */         double agg_value204 = agg_unsafeRowAggBuffer.getDouble(5);
/* 575 */
/* 576 */         double agg_value203 = -1.0;
/* 577 */         agg_value203 = agg_value204 + inputadapter_value8;
/* 578 */
/* 579 */         boolean agg_isNull171 = true;
/* 580 */         double agg_value206 = -1.0;
/* 581 */
/* 582 */         boolean agg_isNull172 = true;
/* 583 */         double agg_value207 = -1.0;
/* 584 */
/* 585 */         boolean agg_isNull173 = true;
/* 586 */         double agg_value208 = -1.0;
/* 587 */
/* 588 */         boolean agg_isNull174 = false;
/* 589 */
/* 590 */         double agg_value211 = agg_unsafeRowAggBuffer.getDouble(4);
/* 591 */         double agg_value209 = -1.0;
/* 592 */         agg_value209 = inputadapter_value7 - agg_value211;
/* 593 */
/* 594 */         if (!agg_isNull103) {
/* 595 */           agg_isNull173 = false; // resultCode could change nullability.
/* 596 */           agg_value208 = agg_value209 * agg_value138;
/* 597 */
/* 598 */         }
/* 599 */         if (!agg_isNull173) {
/* 600 */           double agg_value212 = agg_unsafeRowAggBuffer.getDouble(3);
/* 601 */
/* 602 */           agg_isNull172 = false; // resultCode could change nullability.
/* 603 */           agg_value207 = agg_value208 * agg_value212;
/* 604 */
/* 605 */         }
/* 606 */         if (!agg_isNull172) {
/* 607 */           agg_isNull171 = false; // resultCode could change nullability.
/* 608 */           agg_value206 = agg_value207 * inputadapter_value6;
/* 609 */
/* 610 */         }
/* 611 */         if (!agg_isNull171) {
/* 612 */           agg_isNull167 = false; // resultCode could change nullability.
/* 613 */           agg_value202 = agg_value203 + agg_value206;
/* 614 */
/* 615 */         }
/* 616 */         boolean agg_isNull179 = true;
/* 617 */         double agg_value214 = -1.0;
/* 618 */
/* 619 */         double agg_value215 = agg_unsafeRowAggBuffer.getDouble(7);
/* 620 */
/* 621 */         boolean agg_isNull181 = true;
/* 622 */         double agg_value216 = -1.0;
/* 623 */
/* 624 */         if (!agg_isNull140) {
/* 625 */           agg_isNull181 = false; // resultCode could change nullability.
/* 626 */           agg_value216 = agg_value175 * inputadapter_value9;
/* 627 */
/* 628 */         }
/* 629 */         if (!agg_isNull181) {
/* 630 */           agg_isNull179 = false; // resultCode could change nullability.
/* 631 */           agg_value214 = agg_value215 + agg_value216;
/* 632 */
/* 633 */         }
/* 634 */         boolean agg_isNull183 = true;
/* 635 */         double agg_value218 = -1.0;
/* 636 */
/* 637 */         boolean agg_isNull184 = false;
/* 638 */
/* 639 */         double agg_value220 = agg_unsafeRowAggBuffer.getDouble(8);
/* 640 */
/* 641 */         double agg_value219 = -1.0;
/* 642 */         agg_value219 = agg_value220 + inputadapter_value11;
/* 643 */
/* 644 */         boolean agg_isNull187 = true;
/* 645 */         double agg_value222 = -1.0;
/* 646 */
/* 647 */         boolean agg_isNull188 = true;
/* 648 */         double agg_value223 = -1.0;
/* 649 */
/* 650 */         boolean agg_isNull189 = true;
/* 651 */         double agg_value224 = -1.0;
/* 652 */
/* 653 */         boolean agg_isNull190 = false;
/* 654 */
/* 655 */         double agg_value227 = agg_unsafeRowAggBuffer.getDouble(7);
/* 656 */         double agg_value225 = -1.0;
/* 657 */         agg_value225 = inputadapter_value10 - agg_value227;
/* 658 */
/* 659 */         if (!agg_isNull140) {
/* 660 */           agg_isNull189 = false; // resultCode could change nullability.
/* 661 */           agg_value224 = agg_value225 * agg_value175;
/* 662 */
/* 663 */         }
/* 664 */         if (!agg_isNull189) {
/* 665 */           double agg_value228 = agg_unsafeRowAggBuffer.getDouble(6);
/* 666 */
/* 667 */           agg_isNull188 = false; // resultCode could change nullability.
/* 668 */           agg_value223 = agg_value224 * agg_value228;
/* 669 */
/* 670 */         }
/* 671 */         if (!agg_isNull188) {
/* 672 */           agg_isNull187 = false; // resultCode could change nullability.
/* 673 */           agg_value222 = agg_value223 * inputadapter_value9;
/* 674 */
/* 675 */         }
/* 676 */         if (!agg_isNull187) {
/* 677 */           agg_isNull183 = false; // resultCode could change nullability.
/* 678 */           agg_value218 = agg_value219 + agg_value222;
/* 679 */
/* 680 */         }
/* 681 */         boolean agg_isNull195 = true;
/* 682 */         double agg_value230 = -1.0;
/* 683 */
/* 684 */         boolean agg_isNull196 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 685 */         double agg_value231 = agg_isNull196 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 686 */         if (!agg_isNull196) {
/* 687 */           if (!inputadapter_isNull12) {
/* 688 */             agg_isNull195 = false; // resultCode could change nullability.
/* 689 */             agg_value230 = agg_value231 + inputadapter_value12;
/* 690 */
/* 691 */           }
/* 692 */
/* 693 */         }
/* 694 */         boolean agg_isNull198 = true;
/* 695 */         long agg_value233 = -1L;
/* 696 */
/* 697 */         boolean agg_isNull199 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 698 */         long agg_value234 = agg_isNull199 ? -1L : (agg_unsafeRowAggBuffer.getLong(10));
/* 699 */         if (!agg_isNull199) {
/* 700 */           if (!inputadapter_isNull13) {
/* 701 */             agg_isNull198 = false; // resultCode could change nullability.
/* 702 */             agg_value233 = agg_value234 + inputadapter_value13;
/* 703 */
/* 704 */           }
/* 705 */
/* 706 */         }
/* 707 */         boolean agg_isNull201 = false;
/* 708 */
/* 709 */         long agg_value237 = agg_unsafeRowAggBuffer.getLong(11);
/* 710 */
/* 711 */         long agg_value236 = -1L;
/* 712 */         agg_value236 = agg_value237 + inputadapter_value14;
/* 713 */         boolean agg_isNull204 = true;
/* 714 */         double agg_value239 = -1.0;
/* 715 */
/* 716 */         boolean agg_isNull205 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 717 */         double agg_value240 = agg_isNull205 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 718 */         if (!agg_isNull205) {
/* 719 */           if (!inputadapter_isNull15) {
/* 720 */             agg_isNull204 = false; // resultCode could change nullability.
/* 721 */             agg_value239 = agg_value240 + inputadapter_value15;
/* 722 */
/* 723 */           }
/* 724 */
/* 725 */         }
/* 726 */         boolean agg_isNull207 = true;
/* 727 */         long agg_value242 = -1L;
/* 728 */
/* 729 */         boolean agg_isNull208 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 730 */         long agg_value243 = agg_isNull208 ? -1L : (agg_unsafeRowAggBuffer.getLong(13));
/* 731 */         if (!agg_isNull208) {
/* 732 */           if (!inputadapter_isNull16) {
/* 733 */             agg_isNull207 = false; // resultCode could change nullability.
/* 734 */             agg_value242 = agg_value243 + inputadapter_value16;
/* 735 */
/* 736 */           }
/* 737 */
/* 738 */         }
/* 739 */         boolean agg_isNull210 = true;
/* 740 */         double agg_value245 = -1.0;
/* 741 */
/* 742 */         double agg_value246 = agg_unsafeRowAggBuffer.getDouble(15);
/* 743 */
/* 744 */         boolean agg_isNull212 = true;
/* 745 */         double agg_value247 = -1.0;
/* 746 */
/* 747 */         if (!agg_isNull52) {
/* 748 */           agg_isNull212 = false; // resultCode could change nullability.
/* 749 */           agg_value247 = agg_value87 * inputadapter_value17;
/* 750 */
/* 751 */         }
/* 752 */         if (!agg_isNull212) {
/* 753 */           agg_isNull210 = false; // resultCode could change nullability.
/* 754 */           agg_value245 = agg_value246 + agg_value247;
/* 755 */
/* 756 */         }
/* 757 */         boolean agg_isNull214 = true;
/* 758 */         double agg_value249 = -1.0;
/* 759 */
/* 760 */         boolean agg_isNull215 = false;
/* 761 */
/* 762 */         double agg_value251 = agg_unsafeRowAggBuffer.getDouble(16);
/* 763 */
/* 764 */         double agg_value250 = -1.0;
/* 765 */         agg_value250 = agg_value251 + inputadapter_value19;
/* 766 */
/* 767 */         boolean agg_isNull218 = true;
/* 768 */         double agg_value253 = -1.0;
/* 769 */
/* 770 */         boolean agg_isNull219 = true;
/* 771 */         double agg_value254 = -1.0;
/* 772 */
/* 773 */         boolean agg_isNull220 = true;
/* 774 */         double agg_value255 = -1.0;
/* 775 */
/* 776 */         boolean agg_isNull221 = false;
/* 777 */
/* 778 */         double agg_value258 = agg_unsafeRowAggBuffer.getDouble(15);
/* 779 */         double agg_value256 = -1.0;
/* 780 */         agg_value256 = inputadapter_value18 - agg_value258;
/* 781 */
/* 782 */         if (!agg_isNull52) {
/* 783 */           agg_isNull220 = false; // resultCode could change nullability.
/* 784 */           agg_value255 = agg_value256 * agg_value87;
/* 785 */
/* 786 */         }
/* 787 */         if (!agg_isNull220) {
/* 788 */           double agg_value259 = agg_unsafeRowAggBuffer.getDouble(14);
/* 789 */
/* 790 */           agg_isNull219 = false; // resultCode could change nullability.
/* 791 */           agg_value254 = agg_value255 * agg_value259;
/* 792 */
/* 793 */         }
/* 794 */         if (!agg_isNull219) {
/* 795 */           agg_isNull218 = false; // resultCode could change nullability.
/* 796 */           agg_value253 = agg_value254 * inputadapter_value17;
/* 797 */
/* 798 */         }
/* 799 */         if (!agg_isNull218) {
/* 800 */           agg_isNull214 = false; // resultCode could change nullability.
/* 801 */           agg_value249 = agg_value250 + agg_value253;
/* 802 */
/* 803 */         }
/* 804 */         boolean agg_isNull226 = true;
/* 805 */         double agg_value261 = -1.0;
/* 806 */
/* 807 */         double agg_value262 = agg_unsafeRowAggBuffer.getDouble(18);
/* 808 */
/* 809 */         boolean agg_isNull228 = true;
/* 810 */         double agg_value263 = -1.0;
/* 811 */
/* 812 */         if (!agg_isNull69) {
/* 813 */           agg_isNull228 = false; // resultCode could change nullability.
/* 814 */           agg_value263 = agg_value104 * inputadapter_value20;
/* 815 */
/* 816 */         }
/* 817 */         if (!agg_isNull228) {
/* 818 */           agg_isNull226 = false; // resultCode could change nullability.
/* 819 */           agg_value261 = agg_value262 + agg_value263;
/* 820 */
/* 821 */         }
/* 822 */         boolean agg_isNull230 = true;
/* 823 */         double agg_value265 = -1.0;
/* 824 */
/* 825 */         boolean agg_isNull231 = false;
/* 826 */
/* 827 */         double agg_value267 = agg_unsafeRowAggBuffer.getDouble(19);
/* 828 */
/* 829 */         double agg_value266 = -1.0;
/* 830 */         agg_value266 = agg_value267 + inputadapter_value22;
/* 831 */
/* 832 */         boolean agg_isNull234 = true;
/* 833 */         double agg_value269 = -1.0;
/* 834 */
/* 835 */         boolean agg_isNull235 = true;
/* 836 */         double agg_value270 = -1.0;
/* 837 */
/* 838 */         boolean agg_isNull236 = true;
/* 839 */         double agg_value271 = -1.0;
/* 840 */
/* 841 */         boolean agg_isNull237 = false;
/* 842 */
/* 843 */         double agg_value274 = agg_unsafeRowAggBuffer.getDouble(18);
/* 844 */         double agg_value272 = -1.0;
/* 845 */         agg_value272 = inputadapter_value21 - agg_value274;
/* 846 */
/* 847 */         if (!agg_isNull69) {
/* 848 */           agg_isNull236 = false; // resultCode could change nullability.
/* 849 */           agg_value271 = agg_value272 * agg_value104;
/* 850 */
/* 851 */         }
/* 852 */         if (!agg_isNull236) {
/* 853 */           double agg_value275 = agg_unsafeRowAggBuffer.getDouble(17);
/* 854 */
/* 855 */           agg_isNull235 = false; // resultCode could change nullability.
/* 856 */           agg_value270 = agg_value271 * agg_value275;
/* 857 */
/* 858 */         }
/* 859 */         if (!agg_isNull235) {
/* 860 */           agg_isNull234 = false; // resultCode could change nullability.
/* 861 */           agg_value269 = agg_value270 * inputadapter_value20;
/* 862 */
/* 863 */         }
/* 864 */         if (!agg_isNull234) {
/* 865 */           agg_isNull230 = false; // resultCode could change nullability.
/* 866 */           agg_value265 = agg_value266 + agg_value269;
/* 867 */
/* 868 */         }
/* 869 */         boolean agg_isNull242 = true;
/* 870 */         double agg_value277 = -1.0;
/* 871 */
/* 872 */         boolean agg_isNull243 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 873 */         double agg_value278 = agg_isNull243 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 874 */         if (!agg_isNull243) {
/* 875 */           if (!inputadapter_isNull23) {
/* 876 */             agg_isNull242 = false; // resultCode could change nullability.
/* 877 */             agg_value277 = agg_value278 + inputadapter_value23;
/* 878 */
/* 879 */           }
/* 880 */
/* 881 */         }
/* 882 */         boolean agg_isNull245 = true;
/* 883 */         long agg_value280 = -1L;
/* 884 */
/* 885 */         boolean agg_isNull246 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 886 */         long agg_value281 = agg_isNull246 ? -1L : (agg_unsafeRowAggBuffer.getLong(21));
/* 887 */         if (!agg_isNull246) {
/* 888 */           if (!inputadapter_isNull24) {
/* 889 */             agg_isNull245 = false; // resultCode could change nullability.
/* 890 */             agg_value280 = agg_value281 + inputadapter_value24;
/* 891 */
/* 892 */           }
/* 893 */
/* 894 */         }
/* 895 */         boolean agg_isNull248 = false;
/* 896 */
/* 897 */         long agg_value284 = agg_unsafeRowAggBuffer.getLong(22);
/* 898 */
/* 899 */         long agg_value283 = -1L;
/* 900 */         agg_value283 = agg_value284 + inputadapter_value25;
/* 901 */         boolean agg_isNull251 = true;
/* 902 */         double agg_value286 = -1.0;
/* 903 */
/* 904 */         boolean agg_isNull252 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 905 */         double agg_value287 = agg_isNull252 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 906 */         if (!agg_isNull252) {
/* 907 */           if (!inputadapter_isNull26) {
/* 908 */             agg_isNull251 = false; // resultCode could change nullability.
/* 909 */             agg_value286 = agg_value287 + inputadapter_value26;
/* 910 */
/* 911 */           }
/* 912 */
/* 913 */         }
/* 914 */         boolean agg_isNull254 = true;
/* 915 */         long agg_value289 = -1L;
/* 916 */
/* 917 */         boolean agg_isNull255 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 918 */         long agg_value290 = agg_isNull255 ? -1L : (agg_unsafeRowAggBuffer.getLong(24));
/* 919 */         if (!agg_isNull255) {
/* 920 */           if (!inputadapter_isNull27) {
/* 921 */             agg_isNull254 = false; // resultCode could change nullability.
/* 922 */             agg_value289 = agg_value290 + inputadapter_value27;
/* 923 */
/* 924 */           }
/* 925 */
/* 926 */         }
/* 927 */         boolean agg_isNull257 = true;
/* 928 */         double agg_value292 = -1.0;
/* 929 */
/* 930 */         double agg_value293 = agg_unsafeRowAggBuffer.getDouble(26);
/* 931 */
/* 932 */         boolean agg_isNull259 = true;
/* 933 */         double agg_value294 = -1.0;
/* 934 */
/* 935 */         if (!agg_isNull120) {
/* 936 */           agg_isNull259 = false; // resultCode could change nullability.
/* 937 */           agg_value294 = agg_value155 * inputadapter_value28;
/* 938 */
/* 939 */         }
/* 940 */         if (!agg_isNull259) {
/* 941 */           agg_isNull257 = false; // resultCode could change nullability.
/* 942 */           agg_value292 = agg_value293 + agg_value294;
/* 943 */
/* 944 */         }
/* 945 */         boolean agg_isNull261 = true;
/* 946 */         double agg_value296 = -1.0;
/* 947 */
/* 948 */         boolean agg_isNull262 = false;
/* 949 */
/* 950 */         double agg_value298 = agg_unsafeRowAggBuffer.getDouble(27);
/* 951 */
/* 952 */         double agg_value297 = -1.0;
/* 953 */         agg_value297 = agg_value298 + inputadapter_value30;
/* 954 */
/* 955 */         boolean agg_isNull265 = true;
/* 956 */         double agg_value300 = -1.0;
/* 957 */
/* 958 */         boolean agg_isNull266 = true;
/* 959 */         double agg_value301 = -1.0;
/* 960 */
/* 961 */         boolean agg_isNull267 = true;
/* 962 */         double agg_value302 = -1.0;
/* 963 */
/* 964 */         boolean agg_isNull268 = false;
/* 965 */
/* 966 */         double agg_value305 = agg_unsafeRowAggBuffer.getDouble(26);
/* 967 */         double agg_value303 = -1.0;
/* 968 */         agg_value303 = inputadapter_value29 - agg_value305;
/* 969 */
/* 970 */         if (!agg_isNull120) {
/* 971 */           agg_isNull267 = false; // resultCode could change nullability.
/* 972 */           agg_value302 = agg_value303 * agg_value155;
/* 973 */
/* 974 */         }
/* 975 */         if (!agg_isNull267) {
/* 976 */           double agg_value306 = agg_unsafeRowAggBuffer.getDouble(25);
/* 977 */
/* 978 */           agg_isNull266 = false; // resultCode could change nullability.
/* 979 */           agg_value301 = agg_value302 * agg_value306;
/* 980 */
/* 981 */         }
/* 982 */         if (!agg_isNull266) {
/* 983 */           agg_isNull265 = false; // resultCode could change nullability.
/* 984 */           agg_value300 = agg_value301 * inputadapter_value28;
/* 985 */
/* 986 */         }
/* 987 */         if (!agg_isNull265) {
/* 988 */           agg_isNull261 = false; // resultCode could change nullability.
/* 989 */           agg_value296 = agg_value297 + agg_value300;
/* 990 */
/* 991 */         }
/* 992 */         boolean agg_isNull273 = true;
/* 993 */         double agg_value308 = -1.0;
/* 994 */
/* 995 */         boolean agg_isNull274 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 996 */         double agg_value309 = agg_isNull274 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 997 */         if (!agg_isNull274) {
/* 998 */           if (!inputadapter_isNull31) {
/* 999 */             agg_isNull273 = false; // resultCode could change nullability.
/* 1000 */             agg_value308 = agg_value309 + inputadapter_value31;
/* 1001 */
/* 1002 */           }
/* 1003 */
/* 1004 */         }
/* 1005 */         boolean agg_isNull276 = true;
/* 1006 */         long agg_value311 = -1L;
/* 1007 */
/* 1008 */         boolean agg_isNull277 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 1009 */         long agg_value312 = agg_isNull277 ? -1L : (agg_unsafeRowAggBuffer.getLong(29));
/* 1010 */         if (!agg_isNull277) {
/* 1011 */           if (!inputadapter_isNull32) {
/* 1012 */             agg_isNull276 = false; // resultCode could change nullability.
/* 1013 */             agg_value311 = agg_value312 + inputadapter_value32;
/* 1014 */
/* 1015 */           }
/* 1016 */
/* 1017 */         }
/* 1018 */         boolean agg_isNull279 = true;
/* 1019 */         double agg_value314 = -1.0;
/* 1020 */
/* 1021 */         double agg_value315 = agg_unsafeRowAggBuffer.getDouble(31);
/* 1022 */
/* 1023 */         boolean agg_isNull281 = true;
/* 1024 */         double agg_value316 = -1.0;
/* 1025 */
/* 1026 */         if (!agg_isNull86) {
/* 1027 */           agg_isNull281 = false; // resultCode could change nullability.
/* 1028 */           agg_value316 = agg_value121 * inputadapter_value33;
/* 1029 */
/* 1030 */         }
/* 1031 */         if (!agg_isNull281) {
/* 1032 */           agg_isNull279 = false; // resultCode could change nullability.
/* 1033 */           agg_value314 = agg_value315 + agg_value316;
/* 1034 */
/* 1035 */         }
/* 1036 */         boolean agg_isNull283 = true;
/* 1037 */         double agg_value318 = -1.0;
/* 1038 */
/* 1039 */         boolean agg_isNull284 = false;
/* 1040 */
/* 1041 */         double agg_value320 = agg_unsafeRowAggBuffer.getDouble(32);
/* 1042 */
/* 1043 */         double agg_value319 = -1.0;
/* 1044 */         agg_value319 = agg_value320 + inputadapter_value35;
/* 1045 */
/* 1046 */         boolean agg_isNull287 = true;
/* 1047 */         double agg_value322 = -1.0;
/* 1048 */
/* 1049 */         boolean agg_isNull288 = true;
/* 1050 */         double agg_value323 = -1.0;
/* 1051 */
/* 1052 */         boolean agg_isNull289 = true;
/* 1053 */         double agg_value324 = -1.0;
/* 1054 */
/* 1055 */         boolean agg_isNull290 = false;
/* 1056 */
/* 1057 */         double agg_value327 = agg_unsafeRowAggBuffer.getDouble(31);
/* 1058 */         double agg_value325 = -1.0;
/* 1059 */         agg_value325 = inputadapter_value34 - agg_value327;
/* 1060 */
/* 1061 */         if (!agg_isNull86) {
/* 1062 */           agg_isNull289 = false; // resultCode could change nullability.
/* 1063 */           agg_value324 = agg_value325 * agg_value121;
/* 1064 */
/* 1065 */         }
/* 1066 */         if (!agg_isNull289) {
/* 1067 */           double agg_value328 = agg_unsafeRowAggBuffer.getDouble(30);
/* 1068 */
/* 1069 */           agg_isNull288 = false; // resultCode could change nullability.
/* 1070 */           agg_value323 = agg_value324 * agg_value328;
/* 1071 */
/* 1072 */         }
/* 1073 */         if (!agg_isNull288) {
/* 1074 */           agg_isNull287 = false; // resultCode could change nullability.
/* 1075 */           agg_value322 = agg_value323 * inputadapter_value33;
/* 1076 */
/* 1077 */         }
/* 1078 */         if (!agg_isNull287) {
/* 1079 */           agg_isNull283 = false; // resultCode could change nullability.
/* 1080 */           agg_value318 = agg_value319 + agg_value322;
/* 1081 */
/* 1082 */         }
/* 1083 */         boolean agg_isNull295 = true;
/* 1084 */         double agg_value330 = -1.0;
/* 1085 */
/* 1086 */         boolean agg_isNull296 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 1087 */         double agg_value331 = agg_isNull296 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 1088 */         if (!agg_isNull296) {
/* 1089 */           if (!inputadapter_isNull36) {
/* 1090 */             agg_isNull295 = false; // resultCode could change nullability.
/* 1091 */             agg_value330 = agg_value331 + inputadapter_value36;
/* 1092 */
/* 1093 */           }
/* 1094 */
/* 1095 */         }
/* 1096 */         boolean agg_isNull298 = true;
/* 1097 */         long agg_value333 = -1L;
/* 1098 */
/* 1099 */         boolean agg_isNull299 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 1100 */         long agg_value334 = agg_isNull299 ? -1L : (agg_unsafeRowAggBuffer.getLong(34));
/* 1101 */         if (!agg_isNull299) {
/* 1102 */           if (!inputadapter_isNull37) {
/* 1103 */             agg_isNull298 = false; // resultCode could change nullability.
/* 1104 */             agg_value333 = agg_value334 + inputadapter_value37;
/* 1105 */
/* 1106 */           }
/* 1107 */
/* 1108 */         }
/* 1109 */         // update unsafe row buffer
/* 1110 */         agg_unsafeRowAggBuffer.setLong(0, agg_value189);
/* 1111 */
/* 1112 */         if (!agg_isNull157) {
/* 1113 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value192);
/* 1114 */         } else {
/* 1115 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1116 */         }
/* 1117 */
/* 1118 */         if (!agg_isNull160) {
/* 1119 */           agg_unsafeRowAggBuffer.setLong(2, agg_value195);
/* 1120 */         } else {
/* 1121 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 1122 */         }
/* 1123 */
/* 1124 */         agg_unsafeRowAggBuffer.setDouble(3, agg_value172);
/* 1125 */
/* 1126 */         if (!agg_isNull163) {
/* 1127 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value198);
/* 1128 */         } else {
/* 1129 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1130 */         }
/* 1131 */
/* 1132 */         if (!agg_isNull167) {
/* 1133 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value202);
/* 1134 */         } else {
/* 1135 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 1136 */         }
/* 1137 */
/* 1138 */         agg_unsafeRowAggBuffer.setDouble(6, agg_value101);
/* 1139 */
/* 1140 */         if (!agg_isNull179) {
/* 1141 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value214);
/* 1142 */         } else {
/* 1143 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1144 */         }
/* 1145 */
/* 1146 */         if (!agg_isNull183) {
/* 1147 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value218);
/* 1148 */         } else {
/* 1149 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1150 */         }
/* 1151 */
/* 1152 */         if (!agg_isNull195) {
/* 1153 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value230);
/* 1154 */         } else {
/* 1155 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1156 */         }
/* 1157 */
/* 1158 */         if (!agg_isNull198) {
/* 1159 */           agg_unsafeRowAggBuffer.setLong(10, agg_value233);
/* 1160 */         } else {
/* 1161 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 1162 */         }
/* 1163 */
/* 1164 */         agg_unsafeRowAggBuffer.setLong(11, agg_value236);
/* 1165 */
/* 1166 */         if (!agg_isNull204) {
/* 1167 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value239);
/* 1168 */         } else {
/* 1169 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 1170 */         }
/* 1171 */
/* 1172 */         if (!agg_isNull207) {
/* 1173 */           agg_unsafeRowAggBuffer.setLong(13, agg_value242);
/* 1174 */         } else {
/* 1175 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 1176 */         }
/* 1177 */
/* 1178 */         agg_unsafeRowAggBuffer.setDouble(14, agg_value135);
/* 1179 */
/* 1180 */         if (!agg_isNull210) {
/* 1181 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value245);
/* 1182 */         } else {
/* 1183 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 1184 */         }
/* 1185 */
/* 1186 */         if (!agg_isNull214) {
/* 1187 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value249);
/* 1188 */         } else {
/* 1189 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 1190 */         }
/* 1191 */
/* 1192 */         agg_unsafeRowAggBuffer.setDouble(17, agg_value152);
/* 1193 */
/* 1194 */         if (!agg_isNull226) {
/* 1195 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value261);
/* 1196 */         } else {
/* 1197 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 1198 */         }
/* 1199 */
/* 1200 */         if (!agg_isNull230) {
/* 1201 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value265);
/* 1202 */         } else {
/* 1203 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 1204 */         }
/* 1205 */
/* 1206 */         if (!agg_isNull242) {
/* 1207 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value277);
/* 1208 */         } else {
/* 1209 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 1210 */         }
/* 1211 */
/* 1212 */         if (!agg_isNull245) {
/* 1213 */           agg_unsafeRowAggBuffer.setLong(21, agg_value280);
/* 1214 */         } else {
/* 1215 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 1216 */         }
/* 1217 */
/* 1218 */         agg_unsafeRowAggBuffer.setLong(22, agg_value283);
/* 1219 */
/* 1220 */         if (!agg_isNull251) {
/* 1221 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value286);
/* 1222 */         } else {
/* 1223 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 1224 */         }
/* 1225 */
/* 1226 */         if (!agg_isNull254) {
/* 1227 */           agg_unsafeRowAggBuffer.setLong(24, agg_value289);
/* 1228 */         } else {
/* 1229 */           agg_unsafeRowAggBuffer.setNullAt(24);
/* 1230 */         }
/* 1231 */
/* 1232 */         agg_unsafeRowAggBuffer.setDouble(25, agg_value169);
/* 1233 */
/* 1234 */         if (!agg_isNull257) {
/* 1235 */           agg_unsafeRowAggBuffer.setDouble(26, agg_value292);
/* 1236 */         } else {
/* 1237 */           agg_unsafeRowAggBuffer.setNullAt(26);
/* 1238 */         }
/* 1239 */
/* 1240 */         if (!agg_isNull261) {
/* 1241 */           agg_unsafeRowAggBuffer.setDouble(27, agg_value296);
/* 1242 */         } else {
/* 1243 */           agg_unsafeRowAggBuffer.setNullAt(27);
/* 1244 */         }
/* 1245 */
/* 1246 */         if (!agg_isNull273) {
/* 1247 */           agg_unsafeRowAggBuffer.setDouble(28, agg_value308);
/* 1248 */         } else {
/* 1249 */           agg_unsafeRowAggBuffer.setNullAt(28);
/* 1250 */         }
/* 1251 */
/* 1252 */         if (!agg_isNull276) {
/* 1253 */           agg_unsafeRowAggBuffer.setLong(29, agg_value311);
/* 1254 */         } else {
/* 1255 */           agg_unsafeRowAggBuffer.setNullAt(29);
/* 1256 */         }
/* 1257 */
/* 1258 */         agg_unsafeRowAggBuffer.setDouble(30, agg_value118);
/* 1259 */
/* 1260 */         if (!agg_isNull279) {
/* 1261 */           agg_unsafeRowAggBuffer.setDouble(31, agg_value314);
/* 1262 */         } else {
/* 1263 */           agg_unsafeRowAggBuffer.setNullAt(31);
/* 1264 */         }
/* 1265 */
/* 1266 */         if (!agg_isNull283) {
/* 1267 */           agg_unsafeRowAggBuffer.setDouble(32, agg_value318);
/* 1268 */         } else {
/* 1269 */           agg_unsafeRowAggBuffer.setNullAt(32);
/* 1270 */         }
/* 1271 */
/* 1272 */         if (!agg_isNull295) {
/* 1273 */           agg_unsafeRowAggBuffer.setDouble(33, agg_value330);
/* 1274 */         } else {
/* 1275 */           agg_unsafeRowAggBuffer.setNullAt(33);
/* 1276 */         }
/* 1277 */
/* 1278 */         if (!agg_isNull298) {
/* 1279 */           agg_unsafeRowAggBuffer.setLong(34, agg_value333);
/* 1280 */         } else {
/* 1281 */           agg_unsafeRowAggBuffer.setNullAt(34);
/* 1282 */         }
/* 1283 */
/* 1284 */       }
/* 1285 */       if (shouldStop()) return;
/* 1286 */     }
/* 1287 */
/* 1288 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1289 */   }
/* 1290 */
/* 1291 */   protected void processNext() throws java.io.IOException {
/* 1292 */     if (!agg_initAgg) {
/* 1293 */       agg_initAgg = true;
/* 1294 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1295 */       agg_doAggregateWithKeys();
/* 1296 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1297 */     }
/* 1298 */
/* 1299 */     // output the result
/* 1300 */
/* 1301 */     while (agg_mapIter.next()) {
/* 1302 */       wholestagecodegen_numOutputRows.add(1);
/* 1303 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1304 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1305 */
/* 1306 */       boolean agg_isNull301 = agg_aggKey.isNullAt(0);
/* 1307 */       UTF8String agg_value336 = agg_isNull301 ? null : (agg_aggKey.getUTF8String(0));
/* 1308 */       boolean agg_isNull302 = agg_aggKey.isNullAt(1);
/* 1309 */       UTF8String agg_value337 = agg_isNull302 ? null : (agg_aggKey.getUTF8String(1));
/* 1310 */       boolean agg_isNull303 = agg_aggKey.isNullAt(2);
/* 1311 */       UTF8String agg_value338 = agg_isNull303 ? null : (agg_aggKey.getUTF8String(2));
/* 1312 */       long agg_value339 = agg_aggBuffer.getLong(0);
/* 1313 */       boolean agg_isNull305 = agg_aggBuffer.isNullAt(1);
/* 1314 */       double agg_value340 = agg_isNull305 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 1315 */       boolean agg_isNull306 = agg_aggBuffer.isNullAt(2);
/* 1316 */       long agg_value341 = agg_isNull306 ? -1L : (agg_aggBuffer.getLong(2));
/* 1317 */       double agg_value342 = agg_aggBuffer.getDouble(3);
/* 1318 */       double agg_value343 = agg_aggBuffer.getDouble(4);
/* 1319 */       double agg_value344 = agg_aggBuffer.getDouble(5);
/* 1320 */       double agg_value345 = agg_aggBuffer.getDouble(6);
/* 1321 */       double agg_value346 = agg_aggBuffer.getDouble(7);
/* 1322 */       double agg_value347 = agg_aggBuffer.getDouble(8);
/* 1323 */       boolean agg_isNull313 = agg_aggBuffer.isNullAt(9);
/* 1324 */       double agg_value348 = agg_isNull313 ? -1.0 : (agg_aggBuffer.getDouble(9));
/* 1325 */       boolean agg_isNull314 = agg_aggBuffer.isNullAt(10);
/* 1326 */       long agg_value349 = agg_isNull314 ? -1L : (agg_aggBuffer.getLong(10));
/* 1327 */       long agg_value350 = agg_aggBuffer.getLong(11);
/* 1328 */       boolean agg_isNull316 = agg_aggBuffer.isNullAt(12);
/* 1329 */       double agg_value351 = agg_isNull316 ? -1.0 : (agg_aggBuffer.getDouble(12));
/* 1330 */       boolean agg_isNull317 = agg_aggBuffer.isNullAt(13);
/* 1331 */       long agg_value352 = agg_isNull317 ? -1L : (agg_aggBuffer.getLong(13));
/* 1332 */       double agg_value353 = agg_aggBuffer.getDouble(14);
/* 1333 */       double agg_value354 = agg_aggBuffer.getDouble(15);
/* 1334 */       double agg_value355 = agg_aggBuffer.getDouble(16);
/* 1335 */       double agg_value356 = agg_aggBuffer.getDouble(17);
/* 1336 */       double agg_value357 = agg_aggBuffer.getDouble(18);
/* 1337 */       double agg_value358 = agg_aggBuffer.getDouble(19);
/* 1338 */       boolean agg_isNull324 = agg_aggBuffer.isNullAt(20);
/* 1339 */       double agg_value359 = agg_isNull324 ? -1.0 : (agg_aggBuffer.getDouble(20));
/* 1340 */       boolean agg_isNull325 = agg_aggBuffer.isNullAt(21);
/* 1341 */       long agg_value360 = agg_isNull325 ? -1L : (agg_aggBuffer.getLong(21));
/* 1342 */       long agg_value361 = agg_aggBuffer.getLong(22);
/* 1343 */       boolean agg_isNull327 = agg_aggBuffer.isNullAt(23);
/* 1344 */       double agg_value362 = agg_isNull327 ? -1.0 : (agg_aggBuffer.getDouble(23));
/* 1345 */       boolean agg_isNull328 = agg_aggBuffer.isNullAt(24);
/* 1346 */       long agg_value363 = agg_isNull328 ? -1L : (agg_aggBuffer.getLong(24));
/* 1347 */       double agg_value364 = agg_aggBuffer.getDouble(25);
/* 1348 */       double agg_value365 = agg_aggBuffer.getDouble(26);
/* 1349 */       double agg_value366 = agg_aggBuffer.getDouble(27);
/* 1350 */       boolean agg_isNull332 = agg_aggBuffer.isNullAt(28);
/* 1351 */       double agg_value367 = agg_isNull332 ? -1.0 : (agg_aggBuffer.getDouble(28));
/* 1352 */       boolean agg_isNull333 = agg_aggBuffer.isNullAt(29);
/* 1353 */       long agg_value368 = agg_isNull333 ? -1L : (agg_aggBuffer.getLong(29));
/* 1354 */       double agg_value369 = agg_aggBuffer.getDouble(30);
/* 1355 */       double agg_value370 = agg_aggBuffer.getDouble(31);
/* 1356 */       double agg_value371 = agg_aggBuffer.getDouble(32);
/* 1357 */       boolean agg_isNull337 = agg_aggBuffer.isNullAt(33);
/* 1358 */       double agg_value372 = agg_isNull337 ? -1.0 : (agg_aggBuffer.getDouble(33));
/* 1359 */       boolean agg_isNull338 = agg_aggBuffer.isNullAt(34);
/* 1360 */       long agg_value373 = agg_isNull338 ? -1L : (agg_aggBuffer.getLong(34));
/* 1361 */       boolean agg_isNull342 = agg_isNull306;
/* 1362 */       double agg_value377 = -1.0;
/* 1363 */       if (!agg_isNull306) {
/* 1364 */         agg_value377 = (double) agg_value341;
/* 1365 */       }
/* 1366 */       boolean agg_isNull340 = false;
/* 1367 */       double agg_value375 = -1.0;
/* 1368 */       if (agg_isNull342 || agg_value377 == 0) {
/* 1369 */         agg_isNull340 = true;
/* 1370 */       } else {
/* 1371 */         if (agg_isNull305) {
/* 1372 */           agg_isNull340 = true;
/* 1373 */         } else {
/* 1374 */           agg_value375 = (double)(agg_value340 / agg_value377);
/* 1375 */         }
/* 1376 */       }
/* 1377 */       boolean agg_isNull345 = false;
/* 1378 */
/* 1379 */       boolean agg_value380 = false;
/* 1380 */       agg_value380 = (java.lang.Double.isNaN(agg_value342) && java.lang.Double.isNaN(0.0D)) || agg_value342 == 0.0D;
/* 1381 */       boolean agg_isNull344 = false;
/* 1382 */       double agg_value379 = -1.0;
/* 1383 */       if (!false && agg_value380) {
/* 1384 */         final double agg_value383 = -1.0;
/* 1385 */         agg_isNull344 = true;
/* 1386 */         agg_value379 = agg_value383;
/* 1387 */       } else {
/* 1388 */         boolean agg_isNull350 = false;
/* 1389 */
/* 1390 */         boolean agg_value385 = false;
/* 1391 */         agg_value385 = (java.lang.Double.isNaN(agg_value342) && java.lang.Double.isNaN(1.0D)) || agg_value342 == 1.0D;
/* 1392 */         boolean agg_isNull349 = false;
/* 1393 */         double agg_value384 = -1.0;
/* 1394 */         if (!false && agg_value385) {
/* 1395 */           final double agg_value388 = (double) ((java.lang.Double) references[3]);
/* 1396 */           agg_isNull349 = false;
/* 1397 */           agg_value384 = agg_value388;
/* 1398 */         } else {
/* 1399 */           boolean agg_isNull357 = false;
/* 1400 */
/* 1401 */           double agg_value392 = -1.0;
/* 1402 */           agg_value392 = agg_value342 - 1.0D;
/* 1403 */           boolean agg_isNull355 = false;
/* 1404 */           double agg_value390 = -1.0;
/* 1405 */           if (agg_value392 == 0) {
/* 1406 */             agg_isNull355 = true;
/* 1407 */           } else {
/* 1408 */             agg_value390 = (double)(agg_value344 / agg_value392);
/* 1409 */           }
/* 1410 */           boolean agg_isNull354 = agg_isNull355;
/* 1411 */           double agg_value389 = -1.0;
/* 1412 */
/* 1413 */           if (!agg_isNull355) {
/* 1414 */             agg_value389 = java.lang.Math.sqrt(agg_value390);
/* 1415 */           }
/* 1416 */           agg_isNull349 = agg_isNull354;
/* 1417 */           agg_value384 = agg_value389;
/* 1418 */         }
/* 1419 */         agg_isNull344 = agg_isNull349;
/* 1420 */         agg_value379 = agg_value384;
/* 1421 */       }
/* 1422 */       boolean agg_isNull361 = false;
/* 1423 */
/* 1424 */       boolean agg_value396 = false;
/* 1425 */       agg_value396 = (java.lang.Double.isNaN(agg_value345) && java.lang.Double.isNaN(0.0D)) || agg_value345 == 0.0D;
/* 1426 */       boolean agg_isNull360 = false;
/* 1427 */       double agg_value395 = -1.0;
/* 1428 */       if (!false && agg_value396) {
/* 1429 */         final double agg_value399 = -1.0;
/* 1430 */         agg_isNull360 = true;
/* 1431 */         agg_value395 = agg_value399;
/* 1432 */       } else {
/* 1433 */         boolean agg_isNull366 = false;
/* 1434 */
/* 1435 */         boolean agg_value401 = false;
/* 1436 */         agg_value401 = (java.lang.Double.isNaN(agg_value345) && java.lang.Double.isNaN(1.0D)) || agg_value345 == 1.0D;
/* 1437 */         boolean agg_isNull365 = false;
/* 1438 */         double agg_value400 = -1.0;
/* 1439 */         if (!false && agg_value401) {
/* 1440 */           final double agg_value404 = (double) ((java.lang.Double) references[4]);
/* 1441 */           agg_isNull365 = false;
/* 1442 */           agg_value400 = agg_value404;
/* 1443 */         } else {
/* 1444 */           boolean agg_isNull373 = false;
/* 1445 */
/* 1446 */           double agg_value408 = -1.0;
/* 1447 */           agg_value408 = agg_value345 - 1.0D;
/* 1448 */           boolean agg_isNull371 = false;
/* 1449 */           double agg_value406 = -1.0;
/* 1450 */           if (agg_value408 == 0) {
/* 1451 */             agg_isNull371 = true;
/* 1452 */           } else {
/* 1453 */             agg_value406 = (double)(agg_value347 / agg_value408);
/* 1454 */           }
/* 1455 */           boolean agg_isNull370 = agg_isNull371;
/* 1456 */           double agg_value405 = -1.0;
/* 1457 */
/* 1458 */           if (!agg_isNull371) {
/* 1459 */             agg_value405 = java.lang.Math.sqrt(agg_value406);
/* 1460 */           }
/* 1461 */           agg_isNull365 = agg_isNull370;
/* 1462 */           agg_value400 = agg_value405;
/* 1463 */         }
/* 1464 */         agg_isNull360 = agg_isNull365;
/* 1465 */         agg_value395 = agg_value400;
/* 1466 */       }
/* 1467 */       boolean agg_isNull378 = agg_isNull314;
/* 1468 */       double agg_value413 = -1.0;
/* 1469 */       if (!agg_isNull314) {
/* 1470 */         agg_value413 = (double) agg_value349;
/* 1471 */       }
/* 1472 */       boolean agg_isNull376 = false;
/* 1473 */       double agg_value411 = -1.0;
/* 1474 */       if (agg_isNull378 || agg_value413 == 0) {
/* 1475 */         agg_isNull376 = true;
/* 1476 */       } else {
/* 1477 */         if (agg_isNull313) {
/* 1478 */           agg_isNull376 = true;
/* 1479 */         } else {
/* 1480 */           agg_value411 = (double)(agg_value348 / agg_value413);
/* 1481 */         }
/* 1482 */       }
/* 1483 */       boolean agg_isNull383 = agg_isNull317;
/* 1484 */       double agg_value418 = -1.0;
/* 1485 */       if (!agg_isNull317) {
/* 1486 */         agg_value418 = (double) agg_value352;
/* 1487 */       }
/* 1488 */       boolean agg_isNull381 = false;
/* 1489 */       double agg_value416 = -1.0;
/* 1490 */       if (agg_isNull383 || agg_value418 == 0) {
/* 1491 */         agg_isNull381 = true;
/* 1492 */       } else {
/* 1493 */         if (agg_isNull316) {
/* 1494 */           agg_isNull381 = true;
/* 1495 */         } else {
/* 1496 */           agg_value416 = (double)(agg_value351 / agg_value418);
/* 1497 */         }
/* 1498 */       }
/* 1499 */       boolean agg_isNull386 = false;
/* 1500 */
/* 1501 */       boolean agg_value421 = false;
/* 1502 */       agg_value421 = (java.lang.Double.isNaN(agg_value353) && java.lang.Double.isNaN(0.0D)) || agg_value353 == 0.0D;
/* 1503 */       boolean agg_isNull385 = false;
/* 1504 */       double agg_value420 = -1.0;
/* 1505 */       if (!false && agg_value421) {
/* 1506 */         final double agg_value424 = -1.0;
/* 1507 */         agg_isNull385 = true;
/* 1508 */         agg_value420 = agg_value424;
/* 1509 */       } else {
/* 1510 */         boolean agg_isNull391 = false;
/* 1511 */
/* 1512 */         boolean agg_value426 = false;
/* 1513 */         agg_value426 = (java.lang.Double.isNaN(agg_value353) && java.lang.Double.isNaN(1.0D)) || agg_value353 == 1.0D;
/* 1514 */         boolean agg_isNull390 = false;
/* 1515 */         double agg_value425 = -1.0;
/* 1516 */         if (!false && agg_value426) {
/* 1517 */           final double agg_value429 = (double) ((java.lang.Double) references[5]);
/* 1518 */           agg_isNull390 = false;
/* 1519 */           agg_value425 = agg_value429;
/* 1520 */         } else {
/* 1521 */           boolean agg_isNull398 = false;
/* 1522 */
/* 1523 */           double agg_value433 = -1.0;
/* 1524 */           agg_value433 = agg_value353 - 1.0D;
/* 1525 */           boolean agg_isNull396 = false;
/* 1526 */           double agg_value431 = -1.0;
/* 1527 */           if (agg_value433 == 0) {
/* 1528 */             agg_isNull396 = true;
/* 1529 */           } else {
/* 1530 */             agg_value431 = (double)(agg_value355 / agg_value433);
/* 1531 */           }
/* 1532 */           boolean agg_isNull395 = agg_isNull396;
/* 1533 */           double agg_value430 = -1.0;
/* 1534 */
/* 1535 */           if (!agg_isNull396) {
/* 1536 */             agg_value430 = java.lang.Math.sqrt(agg_value431);
/* 1537 */           }
/* 1538 */           agg_isNull390 = agg_isNull395;
/* 1539 */           agg_value425 = agg_value430;
/* 1540 */         }
/* 1541 */         agg_isNull385 = agg_isNull390;
/* 1542 */         agg_value420 = agg_value425;
/* 1543 */       }
/* 1544 */       boolean agg_isNull402 = false;
/* 1545 */
/* 1546 */       boolean agg_value437 = false;
/* 1547 */       agg_value437 = (java.lang.Double.isNaN(agg_value356) && java.lang.Double.isNaN(0.0D)) || agg_value356 == 0.0D;
/* 1548 */       boolean agg_isNull401 = false;
/* 1549 */       double agg_value436 = -1.0;
/* 1550 */       if (!false && agg_value437) {
/* 1551 */         final double agg_value440 = -1.0;
/* 1552 */         agg_isNull401 = true;
/* 1553 */         agg_value436 = agg_value440;
/* 1554 */       } else {
/* 1555 */         boolean agg_isNull407 = false;
/* 1556 */
/* 1557 */         boolean agg_value442 = false;
/* 1558 */         agg_value442 = (java.lang.Double.isNaN(agg_value356) && java.lang.Double.isNaN(1.0D)) || agg_value356 == 1.0D;
/* 1559 */         boolean agg_isNull406 = false;
/* 1560 */         double agg_value441 = -1.0;
/* 1561 */         if (!false && agg_value442) {
/* 1562 */           final double agg_value445 = (double) ((java.lang.Double) references[6]);
/* 1563 */           agg_isNull406 = false;
/* 1564 */           agg_value441 = agg_value445;
/* 1565 */         } else {
/* 1566 */           boolean agg_isNull414 = false;
/* 1567 */
/* 1568 */           double agg_value449 = -1.0;
/* 1569 */           agg_value449 = agg_value356 - 1.0D;
/* 1570 */           boolean agg_isNull412 = false;
/* 1571 */           double agg_value447 = -1.0;
/* 1572 */           if (agg_value449 == 0) {
/* 1573 */             agg_isNull412 = true;
/* 1574 */           } else {
/* 1575 */             agg_value447 = (double)(agg_value358 / agg_value449);
/* 1576 */           }
/* 1577 */           boolean agg_isNull411 = agg_isNull412;
/* 1578 */           double agg_value446 = -1.0;
/* 1579 */
/* 1580 */           if (!agg_isNull412) {
/* 1581 */             agg_value446 = java.lang.Math.sqrt(agg_value447);
/* 1582 */           }
/* 1583 */           agg_isNull406 = agg_isNull411;
/* 1584 */           agg_value441 = agg_value446;
/* 1585 */         }
/* 1586 */         agg_isNull401 = agg_isNull406;
/* 1587 */         agg_value436 = agg_value441;
/* 1588 */       }
/* 1589 */       boolean agg_isNull419 = agg_isNull325;
/* 1590 */       double agg_value454 = -1.0;
/* 1591 */       if (!agg_isNull325) {
/* 1592 */         agg_value454 = (double) agg_value360;
/* 1593 */       }
/* 1594 */       boolean agg_isNull417 = false;
/* 1595 */       double agg_value452 = -1.0;
/* 1596 */       if (agg_isNull419 || agg_value454 == 0) {
/* 1597 */         agg_isNull417 = true;
/* 1598 */       } else {
/* 1599 */         if (agg_isNull324) {
/* 1600 */           agg_isNull417 = true;
/* 1601 */         } else {
/* 1602 */           agg_value452 = (double)(agg_value359 / agg_value454);
/* 1603 */         }
/* 1604 */       }
/* 1605 */       boolean agg_isNull424 = agg_isNull328;
/* 1606 */       double agg_value459 = -1.0;
/* 1607 */       if (!agg_isNull328) {
/* 1608 */         agg_value459 = (double) agg_value363;
/* 1609 */       }
/* 1610 */       boolean agg_isNull422 = false;
/* 1611 */       double agg_value457 = -1.0;
/* 1612 */       if (agg_isNull424 || agg_value459 == 0) {
/* 1613 */         agg_isNull422 = true;
/* 1614 */       } else {
/* 1615 */         if (agg_isNull327) {
/* 1616 */           agg_isNull422 = true;
/* 1617 */         } else {
/* 1618 */           agg_value457 = (double)(agg_value362 / agg_value459);
/* 1619 */         }
/* 1620 */       }
/* 1621 */       boolean agg_isNull427 = false;
/* 1622 */
/* 1623 */       boolean agg_value462 = false;
/* 1624 */       agg_value462 = (java.lang.Double.isNaN(agg_value364) && java.lang.Double.isNaN(0.0D)) || agg_value364 == 0.0D;
/* 1625 */       boolean agg_isNull426 = false;
/* 1626 */       double agg_value461 = -1.0;
/* 1627 */       if (!false && agg_value462) {
/* 1628 */         final double agg_value465 = -1.0;
/* 1629 */         agg_isNull426 = true;
/* 1630 */         agg_value461 = agg_value465;
/* 1631 */       } else {
/* 1632 */         boolean agg_isNull432 = false;
/* 1633 */
/* 1634 */         boolean agg_value467 = false;
/* 1635 */         agg_value467 = (java.lang.Double.isNaN(agg_value364) && java.lang.Double.isNaN(1.0D)) || agg_value364 == 1.0D;
/* 1636 */         boolean agg_isNull431 = false;
/* 1637 */         double agg_value466 = -1.0;
/* 1638 */         if (!false && agg_value467) {
/* 1639 */           final double agg_value470 = (double) ((java.lang.Double) references[7]);
/* 1640 */           agg_isNull431 = false;
/* 1641 */           agg_value466 = agg_value470;
/* 1642 */         } else {
/* 1643 */           boolean agg_isNull439 = false;
/* 1644 */
/* 1645 */           double agg_value474 = -1.0;
/* 1646 */           agg_value474 = agg_value364 - 1.0D;
/* 1647 */           boolean agg_isNull437 = false;
/* 1648 */           double agg_value472 = -1.0;
/* 1649 */           if (agg_value474 == 0) {
/* 1650 */             agg_isNull437 = true;
/* 1651 */           } else {
/* 1652 */             agg_value472 = (double)(agg_value366 / agg_value474);
/* 1653 */           }
/* 1654 */           boolean agg_isNull436 = agg_isNull437;
/* 1655 */           double agg_value471 = -1.0;
/* 1656 */
/* 1657 */           if (!agg_isNull437) {
/* 1658 */             agg_value471 = java.lang.Math.sqrt(agg_value472);
/* 1659 */           }
/* 1660 */           agg_isNull431 = agg_isNull436;
/* 1661 */           agg_value466 = agg_value471;
/* 1662 */         }
/* 1663 */         agg_isNull426 = agg_isNull431;
/* 1664 */         agg_value461 = agg_value466;
/* 1665 */       }
/* 1666 */       boolean agg_isNull444 = agg_isNull333;
/* 1667 */       double agg_value479 = -1.0;
/* 1668 */       if (!agg_isNull333) {
/* 1669 */         agg_value479 = (double) agg_value368;
/* 1670 */       }
/* 1671 */       boolean agg_isNull442 = false;
/* 1672 */       double agg_value477 = -1.0;
/* 1673 */       if (agg_isNull444 || agg_value479 == 0) {
/* 1674 */         agg_isNull442 = true;
/* 1675 */       } else {
/* 1676 */         if (agg_isNull332) {
/* 1677 */           agg_isNull442 = true;
/* 1678 */         } else {
/* 1679 */           agg_value477 = (double)(agg_value367 / agg_value479);
/* 1680 */         }
/* 1681 */       }
/* 1682 */       boolean agg_isNull447 = false;
/* 1683 */
/* 1684 */       boolean agg_value482 = false;
/* 1685 */       agg_value482 = (java.lang.Double.isNaN(agg_value369) && java.lang.Double.isNaN(0.0D)) || agg_value369 == 0.0D;
/* 1686 */       boolean agg_isNull446 = false;
/* 1687 */       double agg_value481 = -1.0;
/* 1688 */       if (!false && agg_value482) {
/* 1689 */         final double agg_value485 = -1.0;
/* 1690 */         agg_isNull446 = true;
/* 1691 */         agg_value481 = agg_value485;
/* 1692 */       } else {
/* 1693 */         boolean agg_isNull452 = false;
/* 1694 */
/* 1695 */         boolean agg_value487 = false;
/* 1696 */         agg_value487 = (java.lang.Double.isNaN(agg_value369) && java.lang.Double.isNaN(1.0D)) || agg_value369 == 1.0D;
/* 1697 */         boolean agg_isNull451 = false;
/* 1698 */         double agg_value486 = -1.0;
/* 1699 */         if (!false && agg_value487) {
/* 1700 */           final double agg_value490 = (double) ((java.lang.Double) references[8]);
/* 1701 */           agg_isNull451 = false;
/* 1702 */           agg_value486 = agg_value490;
/* 1703 */         } else {
/* 1704 */           boolean agg_isNull459 = false;
/* 1705 */
/* 1706 */           double agg_value494 = -1.0;
/* 1707 */           agg_value494 = agg_value369 - 1.0D;
/* 1708 */           boolean agg_isNull457 = false;
/* 1709 */           double agg_value492 = -1.0;
/* 1710 */           if (agg_value494 == 0) {
/* 1711 */             agg_isNull457 = true;
/* 1712 */           } else {
/* 1713 */             agg_value492 = (double)(agg_value371 / agg_value494);
/* 1714 */           }
/* 1715 */           boolean agg_isNull456 = agg_isNull457;
/* 1716 */           double agg_value491 = -1.0;
/* 1717 */
/* 1718 */           if (!agg_isNull457) {
/* 1719 */             agg_value491 = java.lang.Math.sqrt(agg_value492);
/* 1720 */           }
/* 1721 */           agg_isNull451 = agg_isNull456;
/* 1722 */           agg_value486 = agg_value491;
/* 1723 */         }
/* 1724 */         agg_isNull446 = agg_isNull451;
/* 1725 */         agg_value481 = agg_value486;
/* 1726 */       }
/* 1727 */       boolean agg_isNull464 = agg_isNull338;
/* 1728 */       double agg_value499 = -1.0;
/* 1729 */       if (!agg_isNull338) {
/* 1730 */         agg_value499 = (double) agg_value373;
/* 1731 */       }
/* 1732 */       boolean agg_isNull462 = false;
/* 1733 */       double agg_value497 = -1.0;
/* 1734 */       if (agg_isNull464 || agg_value499 == 0) {
/* 1735 */         agg_isNull462 = true;
/* 1736 */       } else {
/* 1737 */         if (agg_isNull337) {
/* 1738 */           agg_isNull462 = true;
/* 1739 */         } else {
/* 1740 */           agg_value497 = (double)(agg_value372 / agg_value499);
/* 1741 */         }
/* 1742 */       }
/* 1743 */
/* 1744 */       boolean agg_isNull472 = false;
/* 1745 */       double agg_value507 = -1.0;
/* 1746 */       if (agg_isNull376 || agg_value411 == 0) {
/* 1747 */         agg_isNull472 = true;
/* 1748 */       } else {
/* 1749 */         if (agg_isNull360) {
/* 1750 */           agg_isNull472 = true;
/* 1751 */         } else {
/* 1752 */           agg_value507 = (double)(agg_value395 / agg_value411);
/* 1753 */         }
/* 1754 */       }
/* 1755 */       boolean agg_isNull478 = false;
/* 1756 */       double agg_value513 = -1.0;
/* 1757 */       if (agg_isNull417 || agg_value452 == 0) {
/* 1758 */         agg_isNull478 = true;
/* 1759 */       } else {
/* 1760 */         if (agg_isNull401) {
/* 1761 */           agg_isNull478 = true;
/* 1762 */         } else {
/* 1763 */           agg_value513 = (double)(agg_value436 / agg_value452);
/* 1764 */         }
/* 1765 */       }
/* 1766 */       boolean agg_isNull483 = false;
/* 1767 */       double agg_value518 = -1.0;
/* 1768 */       if (agg_isNull442 || agg_value477 == 0) {
/* 1769 */         agg_isNull483 = true;
/* 1770 */       } else {
/* 1771 */         if (agg_isNull426) {
/* 1772 */           agg_isNull483 = true;
/* 1773 */         } else {
/* 1774 */           agg_value518 = (double)(agg_value461 / agg_value477);
/* 1775 */         }
/* 1776 */       }
/* 1777 */       boolean agg_isNull486 = false;
/* 1778 */       double agg_value521 = -1.0;
/* 1779 */       if (agg_isNull462 || agg_value497 == 0) {
/* 1780 */         agg_isNull486 = true;
/* 1781 */       } else {
/* 1782 */         if (agg_isNull446) {
/* 1783 */           agg_isNull486 = true;
/* 1784 */         } else {
/* 1785 */           agg_value521 = (double)(agg_value481 / agg_value497);
/* 1786 */         }
/* 1787 */       }
/* 1788 */       agg_holder1.reset();
/* 1789 */
/* 1790 */       agg_rowWriter1.zeroOutNullBytes();
/* 1791 */
/* 1792 */       if (agg_isNull301) {
/* 1793 */         agg_rowWriter1.setNullAt(0);
/* 1794 */       } else {
/* 1795 */         agg_rowWriter1.write(0, agg_value336);
/* 1796 */       }
/* 1797 */
/* 1798 */       if (agg_isNull302) {
/* 1799 */         agg_rowWriter1.setNullAt(1);
/* 1800 */       } else {
/* 1801 */         agg_rowWriter1.write(1, agg_value337);
/* 1802 */       }
/* 1803 */
/* 1804 */       if (agg_isNull303) {
/* 1805 */         agg_rowWriter1.setNullAt(2);
/* 1806 */       } else {
/* 1807 */         agg_rowWriter1.write(2, agg_value338);
/* 1808 */       }
/* 1809 */
/* 1810 */       agg_rowWriter1.write(3, agg_value339);
/* 1811 */
/* 1812 */       if (agg_isNull340) {
/* 1813 */         agg_rowWriter1.setNullAt(4);
/* 1814 */       } else {
/* 1815 */         agg_rowWriter1.write(4, agg_value375);
/* 1816 */       }
/* 1817 */
/* 1818 */       if (agg_isNull344) {
/* 1819 */         agg_rowWriter1.setNullAt(5);
/* 1820 */       } else {
/* 1821 */         agg_rowWriter1.write(5, agg_value379);
/* 1822 */       }
/* 1823 */
/* 1824 */       if (agg_isNull472) {
/* 1825 */         agg_rowWriter1.setNullAt(6);
/* 1826 */       } else {
/* 1827 */         agg_rowWriter1.write(6, agg_value507);
/* 1828 */       }
/* 1829 */
/* 1830 */       agg_rowWriter1.write(7, agg_value350);
/* 1831 */
/* 1832 */       if (agg_isNull381) {
/* 1833 */         agg_rowWriter1.setNullAt(8);
/* 1834 */       } else {
/* 1835 */         agg_rowWriter1.write(8, agg_value416);
/* 1836 */       }
/* 1837 */
/* 1838 */       if (agg_isNull385) {
/* 1839 */         agg_rowWriter1.setNullAt(9);
/* 1840 */       } else {
/* 1841 */         agg_rowWriter1.write(9, agg_value420);
/* 1842 */       }
/* 1843 */
/* 1844 */       if (agg_isNull478) {
/* 1845 */         agg_rowWriter1.setNullAt(10);
/* 1846 */       } else {
/* 1847 */         agg_rowWriter1.write(10, agg_value513);
/* 1848 */       }
/* 1849 */
/* 1850 */       agg_rowWriter1.write(11, agg_value361);
/* 1851 */
/* 1852 */       if (agg_isNull422) {
/* 1853 */         agg_rowWriter1.setNullAt(12);
/* 1854 */       } else {
/* 1855 */         agg_rowWriter1.write(12, agg_value457);
/* 1856 */       }
/* 1857 */
/* 1858 */       if (agg_isNull483) {
/* 1859 */         agg_rowWriter1.setNullAt(13);
/* 1860 */       } else {
/* 1861 */         agg_rowWriter1.write(13, agg_value518);
/* 1862 */       }
/* 1863 */
/* 1864 */       if (agg_isNull486) {
/* 1865 */         agg_rowWriter1.setNullAt(14);
/* 1866 */       } else {
/* 1867 */         agg_rowWriter1.write(14, agg_value521);
/* 1868 */       }
/* 1869 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 1870 */       append(agg_result1);
/* 1871 */
/* 1872 */       if (shouldStop()) return;
/* 1873 */     }
/* 1874 */
/* 1875 */     agg_mapIter.close();
/* 1876 */     if (agg_sorter == null) {
/* 1877 */       agg_hashMap.free();
/* 1878 */     }
/* 1879 */   }
/* 1880 */ }
