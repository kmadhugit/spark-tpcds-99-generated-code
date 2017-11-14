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
/* 125 */     while (inputadapter_input.hasNext()) {
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
/* 338 */         double agg_value120 = agg_unsafeRowAggBuffer.getDouble(4);
/* 339 */         double agg_value118 = -1.0;
/* 340 */         agg_value118 = inputadapter_value7 - agg_value120;
/* 341 */         boolean agg_isNull86 = false;
/* 342 */
/* 343 */         double agg_value122 = agg_unsafeRowAggBuffer.getDouble(30);
/* 344 */
/* 345 */         double agg_value121 = -1.0;
/* 346 */         agg_value121 = agg_value122 + inputadapter_value33;
/* 347 */         boolean agg_isNull89 = false;
/* 348 */
/* 349 */         double agg_value126 = agg_unsafeRowAggBuffer.getDouble(26);
/* 350 */         double agg_value124 = -1.0;
/* 351 */         agg_value124 = inputadapter_value29 - agg_value126;
/* 352 */         boolean agg_isNull92 = false;
/* 353 */
/* 354 */         double agg_value129 = agg_unsafeRowAggBuffer.getDouble(31);
/* 355 */         double agg_value127 = -1.0;
/* 356 */         agg_value127 = inputadapter_value34 - agg_value129;
/* 357 */         boolean agg_isNull95 = false;
/* 358 */
/* 359 */         double agg_value132 = agg_unsafeRowAggBuffer.getDouble(18);
/* 360 */         double agg_value130 = -1.0;
/* 361 */         agg_value130 = inputadapter_value21 - agg_value132;
/* 362 */         boolean agg_isNull99 = false;
/* 363 */
/* 364 */         boolean agg_isNull100 = false;
/* 365 */
/* 366 */         double agg_value136 = agg_unsafeRowAggBuffer.getDouble(30);
/* 367 */
/* 368 */         double agg_value135 = -1.0;
/* 369 */         agg_value135 = agg_value136 + inputadapter_value33;
/* 370 */
/* 371 */         boolean agg_value134 = false;
/* 372 */         agg_value134 = (java.lang.Double.isNaN(agg_value135) && java.lang.Double.isNaN(0.0D)) || agg_value135 == 0.0D;
/* 373 */         boolean agg_isNull98 = false;
/* 374 */         double agg_value133 = -1.0;
/* 375 */         if (!false && agg_value134) {
/* 376 */           agg_isNull98 = false;
/* 377 */           agg_value133 = 0.0D;
/* 378 */         } else {
/* 379 */           boolean agg_isNull109 = false;
/* 380 */
/* 381 */           double agg_value145 = agg_unsafeRowAggBuffer.getDouble(30);
/* 382 */
/* 383 */           double agg_value144 = -1.0;
/* 384 */           agg_value144 = agg_value145 + inputadapter_value33;
/* 385 */           boolean agg_isNull105 = false;
/* 386 */           double agg_value140 = -1.0;
/* 387 */           if (agg_value144 == 0) {
/* 388 */             agg_isNull105 = true;
/* 389 */           } else {
/* 390 */             boolean agg_isNull106 = false;
/* 391 */
/* 392 */             double agg_value143 = agg_unsafeRowAggBuffer.getDouble(31);
/* 393 */             double agg_value141 = -1.0;
/* 394 */             agg_value141 = inputadapter_value34 - agg_value143;
/* 395 */             agg_value140 = (double)(agg_value141 / agg_value144);
/* 396 */           }
/* 397 */           agg_isNull98 = agg_isNull105;
/* 398 */           agg_value133 = agg_value140;
/* 399 */         }
/* 400 */         boolean agg_isNull112 = false;
/* 401 */
/* 402 */         double agg_value148 = agg_unsafeRowAggBuffer.getDouble(14);
/* 403 */
/* 404 */         double agg_value147 = -1.0;
/* 405 */         agg_value147 = agg_value148 + inputadapter_value17;
/* 406 */         boolean agg_isNull116 = false;
/* 407 */
/* 408 */         boolean agg_isNull117 = false;
/* 409 */
/* 410 */         double agg_value153 = agg_unsafeRowAggBuffer.getDouble(3);
/* 411 */
/* 412 */         double agg_value152 = -1.0;
/* 413 */         agg_value152 = agg_value153 + inputadapter_value6;
/* 414 */
/* 415 */         boolean agg_value151 = false;
/* 416 */         agg_value151 = (java.lang.Double.isNaN(agg_value152) && java.lang.Double.isNaN(0.0D)) || agg_value152 == 0.0D;
/* 417 */         boolean agg_isNull115 = false;
/* 418 */         double agg_value150 = -1.0;
/* 419 */         if (!false && agg_value151) {
/* 420 */           agg_isNull115 = false;
/* 421 */           agg_value150 = 0.0D;
/* 422 */         } else {
/* 423 */           boolean agg_isNull126 = false;
/* 424 */
/* 425 */           double agg_value162 = agg_unsafeRowAggBuffer.getDouble(3);
/* 426 */
/* 427 */           double agg_value161 = -1.0;
/* 428 */           agg_value161 = agg_value162 + inputadapter_value6;
/* 429 */           boolean agg_isNull122 = false;
/* 430 */           double agg_value157 = -1.0;
/* 431 */           if (agg_value161 == 0) {
/* 432 */             agg_isNull122 = true;
/* 433 */           } else {
/* 434 */             boolean agg_isNull123 = false;
/* 435 */
/* 436 */             double agg_value160 = agg_unsafeRowAggBuffer.getDouble(4);
/* 437 */             double agg_value158 = -1.0;
/* 438 */             agg_value158 = inputadapter_value7 - agg_value160;
/* 439 */             agg_value157 = (double)(agg_value158 / agg_value161);
/* 440 */           }
/* 441 */           agg_isNull115 = agg_isNull122;
/* 442 */           agg_value150 = agg_value157;
/* 443 */         }
/* 444 */         boolean agg_isNull129 = false;
/* 445 */
/* 446 */         double agg_value166 = agg_unsafeRowAggBuffer.getDouble(7);
/* 447 */         double agg_value164 = -1.0;
/* 448 */         agg_value164 = inputadapter_value10 - agg_value166;
/* 449 */         boolean agg_isNull132 = false;
/* 450 */
/* 451 */         double agg_value168 = agg_unsafeRowAggBuffer.getDouble(17);
/* 452 */
/* 453 */         double agg_value167 = -1.0;
/* 454 */         agg_value167 = agg_value168 + inputadapter_value20;
/* 455 */         boolean agg_isNull136 = false;
/* 456 */
/* 457 */         boolean agg_isNull137 = false;
/* 458 */
/* 459 */         double agg_value173 = agg_unsafeRowAggBuffer.getDouble(25);
/* 460 */
/* 461 */         double agg_value172 = -1.0;
/* 462 */         agg_value172 = agg_value173 + inputadapter_value28;
/* 463 */
/* 464 */         boolean agg_value171 = false;
/* 465 */         agg_value171 = (java.lang.Double.isNaN(agg_value172) && java.lang.Double.isNaN(0.0D)) || agg_value172 == 0.0D;
/* 466 */         boolean agg_isNull135 = false;
/* 467 */         double agg_value170 = -1.0;
/* 468 */         if (!false && agg_value171) {
/* 469 */           agg_isNull135 = false;
/* 470 */           agg_value170 = 0.0D;
/* 471 */         } else {
/* 472 */           boolean agg_isNull146 = false;
/* 473 */
/* 474 */           double agg_value182 = agg_unsafeRowAggBuffer.getDouble(25);
/* 475 */
/* 476 */           double agg_value181 = -1.0;
/* 477 */           agg_value181 = agg_value182 + inputadapter_value28;
/* 478 */           boolean agg_isNull142 = false;
/* 479 */           double agg_value177 = -1.0;
/* 480 */           if (agg_value181 == 0) {
/* 481 */             agg_isNull142 = true;
/* 482 */           } else {
/* 483 */             boolean agg_isNull143 = false;
/* 484 */
/* 485 */             double agg_value180 = agg_unsafeRowAggBuffer.getDouble(26);
/* 486 */             double agg_value178 = -1.0;
/* 487 */             agg_value178 = inputadapter_value29 - agg_value180;
/* 488 */             agg_value177 = (double)(agg_value178 / agg_value181);
/* 489 */           }
/* 490 */           agg_isNull135 = agg_isNull142;
/* 491 */           agg_value170 = agg_value177;
/* 492 */         }
/* 493 */         boolean agg_isNull149 = false;
/* 494 */
/* 495 */         double agg_value186 = agg_unsafeRowAggBuffer.getDouble(15);
/* 496 */         double agg_value184 = -1.0;
/* 497 */         agg_value184 = inputadapter_value18 - agg_value186;
/* 498 */         boolean agg_isNull152 = false;
/* 499 */
/* 500 */         double agg_value188 = agg_unsafeRowAggBuffer.getDouble(25);
/* 501 */
/* 502 */         double agg_value187 = -1.0;
/* 503 */         agg_value187 = agg_value188 + inputadapter_value28;
/* 504 */         boolean agg_isNull155 = false;
/* 505 */
/* 506 */         double agg_value191 = agg_unsafeRowAggBuffer.getDouble(3);
/* 507 */
/* 508 */         double agg_value190 = -1.0;
/* 509 */         agg_value190 = agg_value191 + inputadapter_value6;
/* 510 */         boolean agg_isNull159 = false;
/* 511 */
/* 512 */         boolean agg_isNull160 = false;
/* 513 */
/* 514 */         double agg_value196 = agg_unsafeRowAggBuffer.getDouble(6);
/* 515 */
/* 516 */         double agg_value195 = -1.0;
/* 517 */         agg_value195 = agg_value196 + inputadapter_value9;
/* 518 */
/* 519 */         boolean agg_value194 = false;
/* 520 */         agg_value194 = (java.lang.Double.isNaN(agg_value195) && java.lang.Double.isNaN(0.0D)) || agg_value195 == 0.0D;
/* 521 */         boolean agg_isNull158 = false;
/* 522 */         double agg_value193 = -1.0;
/* 523 */         if (!false && agg_value194) {
/* 524 */           agg_isNull158 = false;
/* 525 */           agg_value193 = 0.0D;
/* 526 */         } else {
/* 527 */           boolean agg_isNull169 = false;
/* 528 */
/* 529 */           double agg_value205 = agg_unsafeRowAggBuffer.getDouble(6);
/* 530 */
/* 531 */           double agg_value204 = -1.0;
/* 532 */           agg_value204 = agg_value205 + inputadapter_value9;
/* 533 */           boolean agg_isNull165 = false;
/* 534 */           double agg_value200 = -1.0;
/* 535 */           if (agg_value204 == 0) {
/* 536 */             agg_isNull165 = true;
/* 537 */           } else {
/* 538 */             boolean agg_isNull166 = false;
/* 539 */
/* 540 */             double agg_value203 = agg_unsafeRowAggBuffer.getDouble(7);
/* 541 */             double agg_value201 = -1.0;
/* 542 */             agg_value201 = inputadapter_value10 - agg_value203;
/* 543 */             agg_value200 = (double)(agg_value201 / agg_value204);
/* 544 */           }
/* 545 */           agg_isNull158 = agg_isNull165;
/* 546 */           agg_value193 = agg_value200;
/* 547 */         }
/* 548 */         // evaluate aggregate function
/* 549 */         boolean agg_isNull172 = false;
/* 550 */
/* 551 */         long agg_value208 = agg_unsafeRowAggBuffer.getLong(0);
/* 552 */
/* 553 */         long agg_value207 = -1L;
/* 554 */         agg_value207 = agg_value208 + inputadapter_value3;
/* 555 */         boolean agg_isNull175 = true;
/* 556 */         double agg_value210 = -1.0;
/* 557 */
/* 558 */         boolean agg_isNull176 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 559 */         double agg_value211 = agg_isNull176 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 560 */         if (!agg_isNull176) {
/* 561 */           if (!inputadapter_isNull4) {
/* 562 */             agg_isNull175 = false; // resultCode could change nullability.
/* 563 */             agg_value210 = agg_value211 + inputadapter_value4;
/* 564 */
/* 565 */           }
/* 566 */
/* 567 */         }
/* 568 */         boolean agg_isNull178 = true;
/* 569 */         long agg_value213 = -1L;
/* 570 */
/* 571 */         boolean agg_isNull179 = agg_unsafeRowAggBuffer.isNullAt(2);
/* 572 */         long agg_value214 = agg_isNull179 ? -1L : (agg_unsafeRowAggBuffer.getLong(2));
/* 573 */         if (!agg_isNull179) {
/* 574 */           if (!inputadapter_isNull5) {
/* 575 */             agg_isNull178 = false; // resultCode could change nullability.
/* 576 */             agg_value213 = agg_value214 + inputadapter_value5;
/* 577 */
/* 578 */           }
/* 579 */
/* 580 */         }
/* 581 */         boolean agg_isNull181 = true;
/* 582 */         double agg_value216 = -1.0;
/* 583 */
/* 584 */         double agg_value217 = agg_unsafeRowAggBuffer.getDouble(4);
/* 585 */
/* 586 */         boolean agg_isNull183 = true;
/* 587 */         double agg_value218 = -1.0;
/* 588 */
/* 589 */         if (!agg_isNull115) {
/* 590 */           agg_isNull183 = false; // resultCode could change nullability.
/* 591 */           agg_value218 = agg_value150 * inputadapter_value6;
/* 592 */
/* 593 */         }
/* 594 */         if (!agg_isNull183) {
/* 595 */           agg_isNull181 = false; // resultCode could change nullability.
/* 596 */           agg_value216 = agg_value217 + agg_value218;
/* 597 */
/* 598 */         }
/* 599 */         boolean agg_isNull185 = true;
/* 600 */         double agg_value220 = -1.0;
/* 601 */
/* 602 */         boolean agg_isNull186 = false;
/* 603 */
/* 604 */         double agg_value222 = agg_unsafeRowAggBuffer.getDouble(5);
/* 605 */
/* 606 */         double agg_value221 = -1.0;
/* 607 */         agg_value221 = agg_value222 + inputadapter_value8;
/* 608 */
/* 609 */         boolean agg_isNull189 = true;
/* 610 */         double agg_value224 = -1.0;
/* 611 */
/* 612 */         boolean agg_isNull190 = true;
/* 613 */         double agg_value225 = -1.0;
/* 614 */
/* 615 */         boolean agg_isNull191 = true;
/* 616 */         double agg_value226 = -1.0;
/* 617 */
/* 618 */         if (!agg_isNull115) {
/* 619 */           agg_isNull191 = false; // resultCode could change nullability.
/* 620 */           agg_value226 = agg_value118 * agg_value150;
/* 621 */
/* 622 */         }
/* 623 */         if (!agg_isNull191) {
/* 624 */           double agg_value227 = agg_unsafeRowAggBuffer.getDouble(3);
/* 625 */
/* 626 */           agg_isNull190 = false; // resultCode could change nullability.
/* 627 */           agg_value225 = agg_value226 * agg_value227;
/* 628 */
/* 629 */         }
/* 630 */         if (!agg_isNull190) {
/* 631 */           agg_isNull189 = false; // resultCode could change nullability.
/* 632 */           agg_value224 = agg_value225 * inputadapter_value6;
/* 633 */
/* 634 */         }
/* 635 */         if (!agg_isNull189) {
/* 636 */           agg_isNull185 = false; // resultCode could change nullability.
/* 637 */           agg_value220 = agg_value221 + agg_value224;
/* 638 */
/* 639 */         }
/* 640 */         boolean agg_isNull194 = true;
/* 641 */         double agg_value229 = -1.0;
/* 642 */
/* 643 */         double agg_value230 = agg_unsafeRowAggBuffer.getDouble(7);
/* 644 */
/* 645 */         boolean agg_isNull196 = true;
/* 646 */         double agg_value231 = -1.0;
/* 647 */
/* 648 */         if (!agg_isNull158) {
/* 649 */           agg_isNull196 = false; // resultCode could change nullability.
/* 650 */           agg_value231 = agg_value193 * inputadapter_value9;
/* 651 */
/* 652 */         }
/* 653 */         if (!agg_isNull196) {
/* 654 */           agg_isNull194 = false; // resultCode could change nullability.
/* 655 */           agg_value229 = agg_value230 + agg_value231;
/* 656 */
/* 657 */         }
/* 658 */         boolean agg_isNull198 = true;
/* 659 */         double agg_value233 = -1.0;
/* 660 */
/* 661 */         boolean agg_isNull199 = false;
/* 662 */
/* 663 */         double agg_value235 = agg_unsafeRowAggBuffer.getDouble(8);
/* 664 */
/* 665 */         double agg_value234 = -1.0;
/* 666 */         agg_value234 = agg_value235 + inputadapter_value11;
/* 667 */
/* 668 */         boolean agg_isNull202 = true;
/* 669 */         double agg_value237 = -1.0;
/* 670 */
/* 671 */         boolean agg_isNull203 = true;
/* 672 */         double agg_value238 = -1.0;
/* 673 */
/* 674 */         boolean agg_isNull204 = true;
/* 675 */         double agg_value239 = -1.0;
/* 676 */
/* 677 */         if (!agg_isNull158) {
/* 678 */           agg_isNull204 = false; // resultCode could change nullability.
/* 679 */           agg_value239 = agg_value164 * agg_value193;
/* 680 */
/* 681 */         }
/* 682 */         if (!agg_isNull204) {
/* 683 */           double agg_value240 = agg_unsafeRowAggBuffer.getDouble(6);
/* 684 */
/* 685 */           agg_isNull203 = false; // resultCode could change nullability.
/* 686 */           agg_value238 = agg_value239 * agg_value240;
/* 687 */
/* 688 */         }
/* 689 */         if (!agg_isNull203) {
/* 690 */           agg_isNull202 = false; // resultCode could change nullability.
/* 691 */           agg_value237 = agg_value238 * inputadapter_value9;
/* 692 */
/* 693 */         }
/* 694 */         if (!agg_isNull202) {
/* 695 */           agg_isNull198 = false; // resultCode could change nullability.
/* 696 */           agg_value233 = agg_value234 + agg_value237;
/* 697 */
/* 698 */         }
/* 699 */         boolean agg_isNull207 = true;
/* 700 */         double agg_value242 = -1.0;
/* 701 */
/* 702 */         boolean agg_isNull208 = agg_unsafeRowAggBuffer.isNullAt(9);
/* 703 */         double agg_value243 = agg_isNull208 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(9));
/* 704 */         if (!agg_isNull208) {
/* 705 */           if (!inputadapter_isNull12) {
/* 706 */             agg_isNull207 = false; // resultCode could change nullability.
/* 707 */             agg_value242 = agg_value243 + inputadapter_value12;
/* 708 */
/* 709 */           }
/* 710 */
/* 711 */         }
/* 712 */         boolean agg_isNull210 = true;
/* 713 */         long agg_value245 = -1L;
/* 714 */
/* 715 */         boolean agg_isNull211 = agg_unsafeRowAggBuffer.isNullAt(10);
/* 716 */         long agg_value246 = agg_isNull211 ? -1L : (agg_unsafeRowAggBuffer.getLong(10));
/* 717 */         if (!agg_isNull211) {
/* 718 */           if (!inputadapter_isNull13) {
/* 719 */             agg_isNull210 = false; // resultCode could change nullability.
/* 720 */             agg_value245 = agg_value246 + inputadapter_value13;
/* 721 */
/* 722 */           }
/* 723 */
/* 724 */         }
/* 725 */         boolean agg_isNull213 = false;
/* 726 */
/* 727 */         long agg_value249 = agg_unsafeRowAggBuffer.getLong(11);
/* 728 */
/* 729 */         long agg_value248 = -1L;
/* 730 */         agg_value248 = agg_value249 + inputadapter_value14;
/* 731 */         boolean agg_isNull216 = true;
/* 732 */         double agg_value251 = -1.0;
/* 733 */
/* 734 */         boolean agg_isNull217 = agg_unsafeRowAggBuffer.isNullAt(12);
/* 735 */         double agg_value252 = agg_isNull217 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(12));
/* 736 */         if (!agg_isNull217) {
/* 737 */           if (!inputadapter_isNull15) {
/* 738 */             agg_isNull216 = false; // resultCode could change nullability.
/* 739 */             agg_value251 = agg_value252 + inputadapter_value15;
/* 740 */
/* 741 */           }
/* 742 */
/* 743 */         }
/* 744 */         boolean agg_isNull219 = true;
/* 745 */         long agg_value254 = -1L;
/* 746 */
/* 747 */         boolean agg_isNull220 = agg_unsafeRowAggBuffer.isNullAt(13);
/* 748 */         long agg_value255 = agg_isNull220 ? -1L : (agg_unsafeRowAggBuffer.getLong(13));
/* 749 */         if (!agg_isNull220) {
/* 750 */           if (!inputadapter_isNull16) {
/* 751 */             agg_isNull219 = false; // resultCode could change nullability.
/* 752 */             agg_value254 = agg_value255 + inputadapter_value16;
/* 753 */
/* 754 */           }
/* 755 */
/* 756 */         }
/* 757 */         boolean agg_isNull222 = true;
/* 758 */         double agg_value257 = -1.0;
/* 759 */
/* 760 */         double agg_value258 = agg_unsafeRowAggBuffer.getDouble(15);
/* 761 */
/* 762 */         boolean agg_isNull224 = true;
/* 763 */         double agg_value259 = -1.0;
/* 764 */
/* 765 */         if (!agg_isNull52) {
/* 766 */           agg_isNull224 = false; // resultCode could change nullability.
/* 767 */           agg_value259 = agg_value87 * inputadapter_value17;
/* 768 */
/* 769 */         }
/* 770 */         if (!agg_isNull224) {
/* 771 */           agg_isNull222 = false; // resultCode could change nullability.
/* 772 */           agg_value257 = agg_value258 + agg_value259;
/* 773 */
/* 774 */         }
/* 775 */         boolean agg_isNull226 = true;
/* 776 */         double agg_value261 = -1.0;
/* 777 */
/* 778 */         boolean agg_isNull227 = false;
/* 779 */
/* 780 */         double agg_value263 = agg_unsafeRowAggBuffer.getDouble(16);
/* 781 */
/* 782 */         double agg_value262 = -1.0;
/* 783 */         agg_value262 = agg_value263 + inputadapter_value19;
/* 784 */
/* 785 */         boolean agg_isNull230 = true;
/* 786 */         double agg_value265 = -1.0;
/* 787 */
/* 788 */         boolean agg_isNull231 = true;
/* 789 */         double agg_value266 = -1.0;
/* 790 */
/* 791 */         boolean agg_isNull232 = true;
/* 792 */         double agg_value267 = -1.0;
/* 793 */
/* 794 */         if (!agg_isNull52) {
/* 795 */           agg_isNull232 = false; // resultCode could change nullability.
/* 796 */           agg_value267 = agg_value184 * agg_value87;
/* 797 */
/* 798 */         }
/* 799 */         if (!agg_isNull232) {
/* 800 */           double agg_value268 = agg_unsafeRowAggBuffer.getDouble(14);
/* 801 */
/* 802 */           agg_isNull231 = false; // resultCode could change nullability.
/* 803 */           agg_value266 = agg_value267 * agg_value268;
/* 804 */
/* 805 */         }
/* 806 */         if (!agg_isNull231) {
/* 807 */           agg_isNull230 = false; // resultCode could change nullability.
/* 808 */           agg_value265 = agg_value266 * inputadapter_value17;
/* 809 */
/* 810 */         }
/* 811 */         if (!agg_isNull230) {
/* 812 */           agg_isNull226 = false; // resultCode could change nullability.
/* 813 */           agg_value261 = agg_value262 + agg_value265;
/* 814 */
/* 815 */         }
/* 816 */         boolean agg_isNull235 = true;
/* 817 */         double agg_value270 = -1.0;
/* 818 */
/* 819 */         double agg_value271 = agg_unsafeRowAggBuffer.getDouble(18);
/* 820 */
/* 821 */         boolean agg_isNull237 = true;
/* 822 */         double agg_value272 = -1.0;
/* 823 */
/* 824 */         if (!agg_isNull69) {
/* 825 */           agg_isNull237 = false; // resultCode could change nullability.
/* 826 */           agg_value272 = agg_value104 * inputadapter_value20;
/* 827 */
/* 828 */         }
/* 829 */         if (!agg_isNull237) {
/* 830 */           agg_isNull235 = false; // resultCode could change nullability.
/* 831 */           agg_value270 = agg_value271 + agg_value272;
/* 832 */
/* 833 */         }
/* 834 */         boolean agg_isNull239 = true;
/* 835 */         double agg_value274 = -1.0;
/* 836 */
/* 837 */         boolean agg_isNull240 = false;
/* 838 */
/* 839 */         double agg_value276 = agg_unsafeRowAggBuffer.getDouble(19);
/* 840 */
/* 841 */         double agg_value275 = -1.0;
/* 842 */         agg_value275 = agg_value276 + inputadapter_value22;
/* 843 */
/* 844 */         boolean agg_isNull243 = true;
/* 845 */         double agg_value278 = -1.0;
/* 846 */
/* 847 */         boolean agg_isNull244 = true;
/* 848 */         double agg_value279 = -1.0;
/* 849 */
/* 850 */         boolean agg_isNull245 = true;
/* 851 */         double agg_value280 = -1.0;
/* 852 */
/* 853 */         if (!agg_isNull69) {
/* 854 */           agg_isNull245 = false; // resultCode could change nullability.
/* 855 */           agg_value280 = agg_value130 * agg_value104;
/* 856 */
/* 857 */         }
/* 858 */         if (!agg_isNull245) {
/* 859 */           double agg_value281 = agg_unsafeRowAggBuffer.getDouble(17);
/* 860 */
/* 861 */           agg_isNull244 = false; // resultCode could change nullability.
/* 862 */           agg_value279 = agg_value280 * agg_value281;
/* 863 */
/* 864 */         }
/* 865 */         if (!agg_isNull244) {
/* 866 */           agg_isNull243 = false; // resultCode could change nullability.
/* 867 */           agg_value278 = agg_value279 * inputadapter_value20;
/* 868 */
/* 869 */         }
/* 870 */         if (!agg_isNull243) {
/* 871 */           agg_isNull239 = false; // resultCode could change nullability.
/* 872 */           agg_value274 = agg_value275 + agg_value278;
/* 873 */
/* 874 */         }
/* 875 */         boolean agg_isNull248 = true;
/* 876 */         double agg_value283 = -1.0;
/* 877 */
/* 878 */         boolean agg_isNull249 = agg_unsafeRowAggBuffer.isNullAt(20);
/* 879 */         double agg_value284 = agg_isNull249 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(20));
/* 880 */         if (!agg_isNull249) {
/* 881 */           if (!inputadapter_isNull23) {
/* 882 */             agg_isNull248 = false; // resultCode could change nullability.
/* 883 */             agg_value283 = agg_value284 + inputadapter_value23;
/* 884 */
/* 885 */           }
/* 886 */
/* 887 */         }
/* 888 */         boolean agg_isNull251 = true;
/* 889 */         long agg_value286 = -1L;
/* 890 */
/* 891 */         boolean agg_isNull252 = agg_unsafeRowAggBuffer.isNullAt(21);
/* 892 */         long agg_value287 = agg_isNull252 ? -1L : (agg_unsafeRowAggBuffer.getLong(21));
/* 893 */         if (!agg_isNull252) {
/* 894 */           if (!inputadapter_isNull24) {
/* 895 */             agg_isNull251 = false; // resultCode could change nullability.
/* 896 */             agg_value286 = agg_value287 + inputadapter_value24;
/* 897 */
/* 898 */           }
/* 899 */
/* 900 */         }
/* 901 */         boolean agg_isNull254 = false;
/* 902 */
/* 903 */         long agg_value290 = agg_unsafeRowAggBuffer.getLong(22);
/* 904 */
/* 905 */         long agg_value289 = -1L;
/* 906 */         agg_value289 = agg_value290 + inputadapter_value25;
/* 907 */         boolean agg_isNull257 = true;
/* 908 */         double agg_value292 = -1.0;
/* 909 */
/* 910 */         boolean agg_isNull258 = agg_unsafeRowAggBuffer.isNullAt(23);
/* 911 */         double agg_value293 = agg_isNull258 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(23));
/* 912 */         if (!agg_isNull258) {
/* 913 */           if (!inputadapter_isNull26) {
/* 914 */             agg_isNull257 = false; // resultCode could change nullability.
/* 915 */             agg_value292 = agg_value293 + inputadapter_value26;
/* 916 */
/* 917 */           }
/* 918 */
/* 919 */         }
/* 920 */         boolean agg_isNull260 = true;
/* 921 */         long agg_value295 = -1L;
/* 922 */
/* 923 */         boolean agg_isNull261 = agg_unsafeRowAggBuffer.isNullAt(24);
/* 924 */         long agg_value296 = agg_isNull261 ? -1L : (agg_unsafeRowAggBuffer.getLong(24));
/* 925 */         if (!agg_isNull261) {
/* 926 */           if (!inputadapter_isNull27) {
/* 927 */             agg_isNull260 = false; // resultCode could change nullability.
/* 928 */             agg_value295 = agg_value296 + inputadapter_value27;
/* 929 */
/* 930 */           }
/* 931 */
/* 932 */         }
/* 933 */         boolean agg_isNull263 = true;
/* 934 */         double agg_value298 = -1.0;
/* 935 */
/* 936 */         double agg_value299 = agg_unsafeRowAggBuffer.getDouble(26);
/* 937 */
/* 938 */         boolean agg_isNull265 = true;
/* 939 */         double agg_value300 = -1.0;
/* 940 */
/* 941 */         if (!agg_isNull135) {
/* 942 */           agg_isNull265 = false; // resultCode could change nullability.
/* 943 */           agg_value300 = agg_value170 * inputadapter_value28;
/* 944 */
/* 945 */         }
/* 946 */         if (!agg_isNull265) {
/* 947 */           agg_isNull263 = false; // resultCode could change nullability.
/* 948 */           agg_value298 = agg_value299 + agg_value300;
/* 949 */
/* 950 */         }
/* 951 */         boolean agg_isNull267 = true;
/* 952 */         double agg_value302 = -1.0;
/* 953 */
/* 954 */         boolean agg_isNull268 = false;
/* 955 */
/* 956 */         double agg_value304 = agg_unsafeRowAggBuffer.getDouble(27);
/* 957 */
/* 958 */         double agg_value303 = -1.0;
/* 959 */         agg_value303 = agg_value304 + inputadapter_value30;
/* 960 */
/* 961 */         boolean agg_isNull271 = true;
/* 962 */         double agg_value306 = -1.0;
/* 963 */
/* 964 */         boolean agg_isNull272 = true;
/* 965 */         double agg_value307 = -1.0;
/* 966 */
/* 967 */         boolean agg_isNull273 = true;
/* 968 */         double agg_value308 = -1.0;
/* 969 */
/* 970 */         if (!agg_isNull135) {
/* 971 */           agg_isNull273 = false; // resultCode could change nullability.
/* 972 */           agg_value308 = agg_value124 * agg_value170;
/* 973 */
/* 974 */         }
/* 975 */         if (!agg_isNull273) {
/* 976 */           double agg_value309 = agg_unsafeRowAggBuffer.getDouble(25);
/* 977 */
/* 978 */           agg_isNull272 = false; // resultCode could change nullability.
/* 979 */           agg_value307 = agg_value308 * agg_value309;
/* 980 */
/* 981 */         }
/* 982 */         if (!agg_isNull272) {
/* 983 */           agg_isNull271 = false; // resultCode could change nullability.
/* 984 */           agg_value306 = agg_value307 * inputadapter_value28;
/* 985 */
/* 986 */         }
/* 987 */         if (!agg_isNull271) {
/* 988 */           agg_isNull267 = false; // resultCode could change nullability.
/* 989 */           agg_value302 = agg_value303 + agg_value306;
/* 990 */
/* 991 */         }
/* 992 */         boolean agg_isNull276 = true;
/* 993 */         double agg_value311 = -1.0;
/* 994 */
/* 995 */         boolean agg_isNull277 = agg_unsafeRowAggBuffer.isNullAt(28);
/* 996 */         double agg_value312 = agg_isNull277 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(28));
/* 997 */         if (!agg_isNull277) {
/* 998 */           if (!inputadapter_isNull31) {
/* 999 */             agg_isNull276 = false; // resultCode could change nullability.
/* 1000 */             agg_value311 = agg_value312 + inputadapter_value31;
/* 1001 */
/* 1002 */           }
/* 1003 */
/* 1004 */         }
/* 1005 */         boolean agg_isNull279 = true;
/* 1006 */         long agg_value314 = -1L;
/* 1007 */
/* 1008 */         boolean agg_isNull280 = agg_unsafeRowAggBuffer.isNullAt(29);
/* 1009 */         long agg_value315 = agg_isNull280 ? -1L : (agg_unsafeRowAggBuffer.getLong(29));
/* 1010 */         if (!agg_isNull280) {
/* 1011 */           if (!inputadapter_isNull32) {
/* 1012 */             agg_isNull279 = false; // resultCode could change nullability.
/* 1013 */             agg_value314 = agg_value315 + inputadapter_value32;
/* 1014 */
/* 1015 */           }
/* 1016 */
/* 1017 */         }
/* 1018 */         boolean agg_isNull282 = true;
/* 1019 */         double agg_value317 = -1.0;
/* 1020 */
/* 1021 */         double agg_value318 = agg_unsafeRowAggBuffer.getDouble(31);
/* 1022 */
/* 1023 */         boolean agg_isNull284 = true;
/* 1024 */         double agg_value319 = -1.0;
/* 1025 */
/* 1026 */         if (!agg_isNull98) {
/* 1027 */           agg_isNull284 = false; // resultCode could change nullability.
/* 1028 */           agg_value319 = agg_value133 * inputadapter_value33;
/* 1029 */
/* 1030 */         }
/* 1031 */         if (!agg_isNull284) {
/* 1032 */           agg_isNull282 = false; // resultCode could change nullability.
/* 1033 */           agg_value317 = agg_value318 + agg_value319;
/* 1034 */
/* 1035 */         }
/* 1036 */         boolean agg_isNull286 = true;
/* 1037 */         double agg_value321 = -1.0;
/* 1038 */
/* 1039 */         boolean agg_isNull287 = false;
/* 1040 */
/* 1041 */         double agg_value323 = agg_unsafeRowAggBuffer.getDouble(32);
/* 1042 */
/* 1043 */         double agg_value322 = -1.0;
/* 1044 */         agg_value322 = agg_value323 + inputadapter_value35;
/* 1045 */
/* 1046 */         boolean agg_isNull290 = true;
/* 1047 */         double agg_value325 = -1.0;
/* 1048 */
/* 1049 */         boolean agg_isNull291 = true;
/* 1050 */         double agg_value326 = -1.0;
/* 1051 */
/* 1052 */         boolean agg_isNull292 = true;
/* 1053 */         double agg_value327 = -1.0;
/* 1054 */
/* 1055 */         if (!agg_isNull98) {
/* 1056 */           agg_isNull292 = false; // resultCode could change nullability.
/* 1057 */           agg_value327 = agg_value127 * agg_value133;
/* 1058 */
/* 1059 */         }
/* 1060 */         if (!agg_isNull292) {
/* 1061 */           double agg_value328 = agg_unsafeRowAggBuffer.getDouble(30);
/* 1062 */
/* 1063 */           agg_isNull291 = false; // resultCode could change nullability.
/* 1064 */           agg_value326 = agg_value327 * agg_value328;
/* 1065 */
/* 1066 */         }
/* 1067 */         if (!agg_isNull291) {
/* 1068 */           agg_isNull290 = false; // resultCode could change nullability.
/* 1069 */           agg_value325 = agg_value326 * inputadapter_value33;
/* 1070 */
/* 1071 */         }
/* 1072 */         if (!agg_isNull290) {
/* 1073 */           agg_isNull286 = false; // resultCode could change nullability.
/* 1074 */           agg_value321 = agg_value322 + agg_value325;
/* 1075 */
/* 1076 */         }
/* 1077 */         boolean agg_isNull295 = true;
/* 1078 */         double agg_value330 = -1.0;
/* 1079 */
/* 1080 */         boolean agg_isNull296 = agg_unsafeRowAggBuffer.isNullAt(33);
/* 1081 */         double agg_value331 = agg_isNull296 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(33));
/* 1082 */         if (!agg_isNull296) {
/* 1083 */           if (!inputadapter_isNull36) {
/* 1084 */             agg_isNull295 = false; // resultCode could change nullability.
/* 1085 */             agg_value330 = agg_value331 + inputadapter_value36;
/* 1086 */
/* 1087 */           }
/* 1088 */
/* 1089 */         }
/* 1090 */         boolean agg_isNull298 = true;
/* 1091 */         long agg_value333 = -1L;
/* 1092 */
/* 1093 */         boolean agg_isNull299 = agg_unsafeRowAggBuffer.isNullAt(34);
/* 1094 */         long agg_value334 = agg_isNull299 ? -1L : (agg_unsafeRowAggBuffer.getLong(34));
/* 1095 */         if (!agg_isNull299) {
/* 1096 */           if (!inputadapter_isNull37) {
/* 1097 */             agg_isNull298 = false; // resultCode could change nullability.
/* 1098 */             agg_value333 = agg_value334 + inputadapter_value37;
/* 1099 */
/* 1100 */           }
/* 1101 */
/* 1102 */         }
/* 1103 */         // update unsafe row buffer
/* 1104 */         agg_unsafeRowAggBuffer.setLong(0, agg_value207);
/* 1105 */
/* 1106 */         if (!agg_isNull175) {
/* 1107 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value210);
/* 1108 */         } else {
/* 1109 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1110 */         }
/* 1111 */
/* 1112 */         if (!agg_isNull178) {
/* 1113 */           agg_unsafeRowAggBuffer.setLong(2, agg_value213);
/* 1114 */         } else {
/* 1115 */           agg_unsafeRowAggBuffer.setNullAt(2);
/* 1116 */         }
/* 1117 */
/* 1118 */         agg_unsafeRowAggBuffer.setDouble(3, agg_value190);
/* 1119 */
/* 1120 */         if (!agg_isNull181) {
/* 1121 */           agg_unsafeRowAggBuffer.setDouble(4, agg_value216);
/* 1122 */         } else {
/* 1123 */           agg_unsafeRowAggBuffer.setNullAt(4);
/* 1124 */         }
/* 1125 */
/* 1126 */         if (!agg_isNull185) {
/* 1127 */           agg_unsafeRowAggBuffer.setDouble(5, agg_value220);
/* 1128 */         } else {
/* 1129 */           agg_unsafeRowAggBuffer.setNullAt(5);
/* 1130 */         }
/* 1131 */
/* 1132 */         agg_unsafeRowAggBuffer.setDouble(6, agg_value101);
/* 1133 */
/* 1134 */         if (!agg_isNull194) {
/* 1135 */           agg_unsafeRowAggBuffer.setDouble(7, agg_value229);
/* 1136 */         } else {
/* 1137 */           agg_unsafeRowAggBuffer.setNullAt(7);
/* 1138 */         }
/* 1139 */
/* 1140 */         if (!agg_isNull198) {
/* 1141 */           agg_unsafeRowAggBuffer.setDouble(8, agg_value233);
/* 1142 */         } else {
/* 1143 */           agg_unsafeRowAggBuffer.setNullAt(8);
/* 1144 */         }
/* 1145 */
/* 1146 */         if (!agg_isNull207) {
/* 1147 */           agg_unsafeRowAggBuffer.setDouble(9, agg_value242);
/* 1148 */         } else {
/* 1149 */           agg_unsafeRowAggBuffer.setNullAt(9);
/* 1150 */         }
/* 1151 */
/* 1152 */         if (!agg_isNull210) {
/* 1153 */           agg_unsafeRowAggBuffer.setLong(10, agg_value245);
/* 1154 */         } else {
/* 1155 */           agg_unsafeRowAggBuffer.setNullAt(10);
/* 1156 */         }
/* 1157 */
/* 1158 */         agg_unsafeRowAggBuffer.setLong(11, agg_value248);
/* 1159 */
/* 1160 */         if (!agg_isNull216) {
/* 1161 */           agg_unsafeRowAggBuffer.setDouble(12, agg_value251);
/* 1162 */         } else {
/* 1163 */           agg_unsafeRowAggBuffer.setNullAt(12);
/* 1164 */         }
/* 1165 */
/* 1166 */         if (!agg_isNull219) {
/* 1167 */           agg_unsafeRowAggBuffer.setLong(13, agg_value254);
/* 1168 */         } else {
/* 1169 */           agg_unsafeRowAggBuffer.setNullAt(13);
/* 1170 */         }
/* 1171 */
/* 1172 */         agg_unsafeRowAggBuffer.setDouble(14, agg_value147);
/* 1173 */
/* 1174 */         if (!agg_isNull222) {
/* 1175 */           agg_unsafeRowAggBuffer.setDouble(15, agg_value257);
/* 1176 */         } else {
/* 1177 */           agg_unsafeRowAggBuffer.setNullAt(15);
/* 1178 */         }
/* 1179 */
/* 1180 */         if (!agg_isNull226) {
/* 1181 */           agg_unsafeRowAggBuffer.setDouble(16, agg_value261);
/* 1182 */         } else {
/* 1183 */           agg_unsafeRowAggBuffer.setNullAt(16);
/* 1184 */         }
/* 1185 */
/* 1186 */         agg_unsafeRowAggBuffer.setDouble(17, agg_value167);
/* 1187 */
/* 1188 */         if (!agg_isNull235) {
/* 1189 */           agg_unsafeRowAggBuffer.setDouble(18, agg_value270);
/* 1190 */         } else {
/* 1191 */           agg_unsafeRowAggBuffer.setNullAt(18);
/* 1192 */         }
/* 1193 */
/* 1194 */         if (!agg_isNull239) {
/* 1195 */           agg_unsafeRowAggBuffer.setDouble(19, agg_value274);
/* 1196 */         } else {
/* 1197 */           agg_unsafeRowAggBuffer.setNullAt(19);
/* 1198 */         }
/* 1199 */
/* 1200 */         if (!agg_isNull248) {
/* 1201 */           agg_unsafeRowAggBuffer.setDouble(20, agg_value283);
/* 1202 */         } else {
/* 1203 */           agg_unsafeRowAggBuffer.setNullAt(20);
/* 1204 */         }
/* 1205 */
/* 1206 */         if (!agg_isNull251) {
/* 1207 */           agg_unsafeRowAggBuffer.setLong(21, agg_value286);
/* 1208 */         } else {
/* 1209 */           agg_unsafeRowAggBuffer.setNullAt(21);
/* 1210 */         }
/* 1211 */
/* 1212 */         agg_unsafeRowAggBuffer.setLong(22, agg_value289);
/* 1213 */
/* 1214 */         if (!agg_isNull257) {
/* 1215 */           agg_unsafeRowAggBuffer.setDouble(23, agg_value292);
/* 1216 */         } else {
/* 1217 */           agg_unsafeRowAggBuffer.setNullAt(23);
/* 1218 */         }
/* 1219 */
/* 1220 */         if (!agg_isNull260) {
/* 1221 */           agg_unsafeRowAggBuffer.setLong(24, agg_value295);
/* 1222 */         } else {
/* 1223 */           agg_unsafeRowAggBuffer.setNullAt(24);
/* 1224 */         }
/* 1225 */
/* 1226 */         agg_unsafeRowAggBuffer.setDouble(25, agg_value187);
/* 1227 */
/* 1228 */         if (!agg_isNull263) {
/* 1229 */           agg_unsafeRowAggBuffer.setDouble(26, agg_value298);
/* 1230 */         } else {
/* 1231 */           agg_unsafeRowAggBuffer.setNullAt(26);
/* 1232 */         }
/* 1233 */
/* 1234 */         if (!agg_isNull267) {
/* 1235 */           agg_unsafeRowAggBuffer.setDouble(27, agg_value302);
/* 1236 */         } else {
/* 1237 */           agg_unsafeRowAggBuffer.setNullAt(27);
/* 1238 */         }
/* 1239 */
/* 1240 */         if (!agg_isNull276) {
/* 1241 */           agg_unsafeRowAggBuffer.setDouble(28, agg_value311);
/* 1242 */         } else {
/* 1243 */           agg_unsafeRowAggBuffer.setNullAt(28);
/* 1244 */         }
/* 1245 */
/* 1246 */         if (!agg_isNull279) {
/* 1247 */           agg_unsafeRowAggBuffer.setLong(29, agg_value314);
/* 1248 */         } else {
/* 1249 */           agg_unsafeRowAggBuffer.setNullAt(29);
/* 1250 */         }
/* 1251 */
/* 1252 */         agg_unsafeRowAggBuffer.setDouble(30, agg_value121);
/* 1253 */
/* 1254 */         if (!agg_isNull282) {
/* 1255 */           agg_unsafeRowAggBuffer.setDouble(31, agg_value317);
/* 1256 */         } else {
/* 1257 */           agg_unsafeRowAggBuffer.setNullAt(31);
/* 1258 */         }
/* 1259 */
/* 1260 */         if (!agg_isNull286) {
/* 1261 */           agg_unsafeRowAggBuffer.setDouble(32, agg_value321);
/* 1262 */         } else {
/* 1263 */           agg_unsafeRowAggBuffer.setNullAt(32);
/* 1264 */         }
/* 1265 */
/* 1266 */         if (!agg_isNull295) {
/* 1267 */           agg_unsafeRowAggBuffer.setDouble(33, agg_value330);
/* 1268 */         } else {
/* 1269 */           agg_unsafeRowAggBuffer.setNullAt(33);
/* 1270 */         }
/* 1271 */
/* 1272 */         if (!agg_isNull298) {
/* 1273 */           agg_unsafeRowAggBuffer.setLong(34, agg_value333);
/* 1274 */         } else {
/* 1275 */           agg_unsafeRowAggBuffer.setNullAt(34);
/* 1276 */         }
/* 1277 */
/* 1278 */       }
/* 1279 */       if (shouldStop()) return;
/* 1280 */     }
/* 1281 */
/* 1282 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 1283 */   }
/* 1284 */
/* 1285 */   protected void processNext() throws java.io.IOException {
/* 1286 */     if (!agg_initAgg) {
/* 1287 */       agg_initAgg = true;
/* 1288 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 1289 */       agg_doAggregateWithKeys();
/* 1290 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 1291 */     }
/* 1292 */
/* 1293 */     // output the result
/* 1294 */
/* 1295 */     while (agg_mapIter.next()) {
/* 1296 */       wholestagecodegen_numOutputRows.add(1);
/* 1297 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 1298 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 1299 */
/* 1300 */       boolean agg_isNull301 = agg_aggKey.isNullAt(0);
/* 1301 */       UTF8String agg_value336 = agg_isNull301 ? null : (agg_aggKey.getUTF8String(0));
/* 1302 */       boolean agg_isNull302 = agg_aggKey.isNullAt(1);
/* 1303 */       UTF8String agg_value337 = agg_isNull302 ? null : (agg_aggKey.getUTF8String(1));
/* 1304 */       boolean agg_isNull303 = agg_aggKey.isNullAt(2);
/* 1305 */       UTF8String agg_value338 = agg_isNull303 ? null : (agg_aggKey.getUTF8String(2));
/* 1306 */       long agg_value339 = agg_aggBuffer.getLong(0);
/* 1307 */       boolean agg_isNull305 = agg_aggBuffer.isNullAt(1);
/* 1308 */       double agg_value340 = agg_isNull305 ? -1.0 : (agg_aggBuffer.getDouble(1));
/* 1309 */       boolean agg_isNull306 = agg_aggBuffer.isNullAt(2);
/* 1310 */       long agg_value341 = agg_isNull306 ? -1L : (agg_aggBuffer.getLong(2));
/* 1311 */       double agg_value342 = agg_aggBuffer.getDouble(3);
/* 1312 */       double agg_value343 = agg_aggBuffer.getDouble(4);
/* 1313 */       double agg_value344 = agg_aggBuffer.getDouble(5);
/* 1314 */       double agg_value345 = agg_aggBuffer.getDouble(6);
/* 1315 */       double agg_value346 = agg_aggBuffer.getDouble(7);
/* 1316 */       double agg_value347 = agg_aggBuffer.getDouble(8);
/* 1317 */       boolean agg_isNull313 = agg_aggBuffer.isNullAt(9);
/* 1318 */       double agg_value348 = agg_isNull313 ? -1.0 : (agg_aggBuffer.getDouble(9));
/* 1319 */       boolean agg_isNull314 = agg_aggBuffer.isNullAt(10);
/* 1320 */       long agg_value349 = agg_isNull314 ? -1L : (agg_aggBuffer.getLong(10));
/* 1321 */       long agg_value350 = agg_aggBuffer.getLong(11);
/* 1322 */       boolean agg_isNull316 = agg_aggBuffer.isNullAt(12);
/* 1323 */       double agg_value351 = agg_isNull316 ? -1.0 : (agg_aggBuffer.getDouble(12));
/* 1324 */       boolean agg_isNull317 = agg_aggBuffer.isNullAt(13);
/* 1325 */       long agg_value352 = agg_isNull317 ? -1L : (agg_aggBuffer.getLong(13));
/* 1326 */       double agg_value353 = agg_aggBuffer.getDouble(14);
/* 1327 */       double agg_value354 = agg_aggBuffer.getDouble(15);
/* 1328 */       double agg_value355 = agg_aggBuffer.getDouble(16);
/* 1329 */       double agg_value356 = agg_aggBuffer.getDouble(17);
/* 1330 */       double agg_value357 = agg_aggBuffer.getDouble(18);
/* 1331 */       double agg_value358 = agg_aggBuffer.getDouble(19);
/* 1332 */       boolean agg_isNull324 = agg_aggBuffer.isNullAt(20);
/* 1333 */       double agg_value359 = agg_isNull324 ? -1.0 : (agg_aggBuffer.getDouble(20));
/* 1334 */       boolean agg_isNull325 = agg_aggBuffer.isNullAt(21);
/* 1335 */       long agg_value360 = agg_isNull325 ? -1L : (agg_aggBuffer.getLong(21));
/* 1336 */       long agg_value361 = agg_aggBuffer.getLong(22);
/* 1337 */       boolean agg_isNull327 = agg_aggBuffer.isNullAt(23);
/* 1338 */       double agg_value362 = agg_isNull327 ? -1.0 : (agg_aggBuffer.getDouble(23));
/* 1339 */       boolean agg_isNull328 = agg_aggBuffer.isNullAt(24);
/* 1340 */       long agg_value363 = agg_isNull328 ? -1L : (agg_aggBuffer.getLong(24));
/* 1341 */       double agg_value364 = agg_aggBuffer.getDouble(25);
/* 1342 */       double agg_value365 = agg_aggBuffer.getDouble(26);
/* 1343 */       double agg_value366 = agg_aggBuffer.getDouble(27);
/* 1344 */       boolean agg_isNull332 = agg_aggBuffer.isNullAt(28);
/* 1345 */       double agg_value367 = agg_isNull332 ? -1.0 : (agg_aggBuffer.getDouble(28));
/* 1346 */       boolean agg_isNull333 = agg_aggBuffer.isNullAt(29);
/* 1347 */       long agg_value368 = agg_isNull333 ? -1L : (agg_aggBuffer.getLong(29));
/* 1348 */       double agg_value369 = agg_aggBuffer.getDouble(30);
/* 1349 */       double agg_value370 = agg_aggBuffer.getDouble(31);
/* 1350 */       double agg_value371 = agg_aggBuffer.getDouble(32);
/* 1351 */       boolean agg_isNull337 = agg_aggBuffer.isNullAt(33);
/* 1352 */       double agg_value372 = agg_isNull337 ? -1.0 : (agg_aggBuffer.getDouble(33));
/* 1353 */       boolean agg_isNull338 = agg_aggBuffer.isNullAt(34);
/* 1354 */       long agg_value373 = agg_isNull338 ? -1L : (agg_aggBuffer.getLong(34));
/* 1355 */       boolean agg_isNull343 = agg_isNull306;
/* 1356 */       double agg_value378 = -1.0;
/* 1357 */       if (!agg_isNull306) {
/* 1358 */         agg_value378 = (double) agg_value341;
/* 1359 */       }
/* 1360 */       boolean agg_isNull340 = false;
/* 1361 */       double agg_value375 = -1.0;
/* 1362 */       if (agg_isNull343 || agg_value378 == 0) {
/* 1363 */         agg_isNull340 = true;
/* 1364 */       } else {
/* 1365 */         boolean agg_isNull341 = agg_isNull305;
/* 1366 */         double agg_value376 = -1.0;
/* 1367 */         if (!agg_isNull305) {
/* 1368 */           agg_value376 = agg_value340;
/* 1369 */         }
/* 1370 */         if (agg_isNull341) {
/* 1371 */           agg_isNull340 = true;
/* 1372 */         } else {
/* 1373 */           agg_value375 = (double)(agg_value376 / agg_value378);
/* 1374 */         }
/* 1375 */       }
/* 1376 */       boolean agg_isNull346 = false;
/* 1377 */
/* 1378 */       boolean agg_value381 = false;
/* 1379 */       agg_value381 = (java.lang.Double.isNaN(agg_value342) && java.lang.Double.isNaN(0.0D)) || agg_value342 == 0.0D;
/* 1380 */       boolean agg_isNull345 = false;
/* 1381 */       double agg_value380 = -1.0;
/* 1382 */       if (!false && agg_value381) {
/* 1383 */         final double agg_value384 = -1.0;
/* 1384 */         agg_isNull345 = true;
/* 1385 */         agg_value380 = agg_value384;
/* 1386 */       } else {
/* 1387 */         boolean agg_isNull351 = false;
/* 1388 */
/* 1389 */         boolean agg_value386 = false;
/* 1390 */         agg_value386 = (java.lang.Double.isNaN(agg_value342) && java.lang.Double.isNaN(1.0D)) || agg_value342 == 1.0D;
/* 1391 */         boolean agg_isNull350 = false;
/* 1392 */         double agg_value385 = -1.0;
/* 1393 */         if (!false && agg_value386) {
/* 1394 */           Object agg_obj = ((Expression) references[3]).eval(null);
/* 1395 */           double agg_value389 = (Double) agg_obj;
/* 1396 */           agg_isNull350 = false;
/* 1397 */           agg_value385 = agg_value389;
/* 1398 */         } else {
/* 1399 */           boolean agg_isNull358 = false;
/* 1400 */
/* 1401 */           double agg_value393 = -1.0;
/* 1402 */           agg_value393 = agg_value342 - 1.0D;
/* 1403 */           boolean agg_isNull356 = false;
/* 1404 */           double agg_value391 = -1.0;
/* 1405 */           if (agg_value393 == 0) {
/* 1406 */             agg_isNull356 = true;
/* 1407 */           } else {
/* 1408 */             agg_value391 = (double)(agg_value344 / agg_value393);
/* 1409 */           }
/* 1410 */           boolean agg_isNull355 = agg_isNull356;
/* 1411 */           double agg_value390 = -1.0;
/* 1412 */
/* 1413 */           if (!agg_isNull356) {
/* 1414 */             agg_value390 = java.lang.Math.sqrt(agg_value391);
/* 1415 */           }
/* 1416 */           agg_isNull350 = agg_isNull355;
/* 1417 */           agg_value385 = agg_value390;
/* 1418 */         }
/* 1419 */         agg_isNull345 = agg_isNull350;
/* 1420 */         agg_value380 = agg_value385;
/* 1421 */       }
/* 1422 */       boolean agg_isNull362 = false;
/* 1423 */
/* 1424 */       boolean agg_value397 = false;
/* 1425 */       agg_value397 = (java.lang.Double.isNaN(agg_value345) && java.lang.Double.isNaN(0.0D)) || agg_value345 == 0.0D;
/* 1426 */       boolean agg_isNull361 = false;
/* 1427 */       double agg_value396 = -1.0;
/* 1428 */       if (!false && agg_value397) {
/* 1429 */         final double agg_value400 = -1.0;
/* 1430 */         agg_isNull361 = true;
/* 1431 */         agg_value396 = agg_value400;
/* 1432 */       } else {
/* 1433 */         boolean agg_isNull367 = false;
/* 1434 */
/* 1435 */         boolean agg_value402 = false;
/* 1436 */         agg_value402 = (java.lang.Double.isNaN(agg_value345) && java.lang.Double.isNaN(1.0D)) || agg_value345 == 1.0D;
/* 1437 */         boolean agg_isNull366 = false;
/* 1438 */         double agg_value401 = -1.0;
/* 1439 */         if (!false && agg_value402) {
/* 1440 */           Object agg_obj1 = ((Expression) references[4]).eval(null);
/* 1441 */           double agg_value405 = (Double) agg_obj1;
/* 1442 */           agg_isNull366 = false;
/* 1443 */           agg_value401 = agg_value405;
/* 1444 */         } else {
/* 1445 */           boolean agg_isNull374 = false;
/* 1446 */
/* 1447 */           double agg_value409 = -1.0;
/* 1448 */           agg_value409 = agg_value345 - 1.0D;
/* 1449 */           boolean agg_isNull372 = false;
/* 1450 */           double agg_value407 = -1.0;
/* 1451 */           if (agg_value409 == 0) {
/* 1452 */             agg_isNull372 = true;
/* 1453 */           } else {
/* 1454 */             agg_value407 = (double)(agg_value347 / agg_value409);
/* 1455 */           }
/* 1456 */           boolean agg_isNull371 = agg_isNull372;
/* 1457 */           double agg_value406 = -1.0;
/* 1458 */
/* 1459 */           if (!agg_isNull372) {
/* 1460 */             agg_value406 = java.lang.Math.sqrt(agg_value407);
/* 1461 */           }
/* 1462 */           agg_isNull366 = agg_isNull371;
/* 1463 */           agg_value401 = agg_value406;
/* 1464 */         }
/* 1465 */         agg_isNull361 = agg_isNull366;
/* 1466 */         agg_value396 = agg_value401;
/* 1467 */       }
/* 1468 */       boolean agg_isNull380 = agg_isNull314;
/* 1469 */       double agg_value415 = -1.0;
/* 1470 */       if (!agg_isNull314) {
/* 1471 */         agg_value415 = (double) agg_value349;
/* 1472 */       }
/* 1473 */       boolean agg_isNull377 = false;
/* 1474 */       double agg_value412 = -1.0;
/* 1475 */       if (agg_isNull380 || agg_value415 == 0) {
/* 1476 */         agg_isNull377 = true;
/* 1477 */       } else {
/* 1478 */         boolean agg_isNull378 = agg_isNull313;
/* 1479 */         double agg_value413 = -1.0;
/* 1480 */         if (!agg_isNull313) {
/* 1481 */           agg_value413 = agg_value348;
/* 1482 */         }
/* 1483 */         if (agg_isNull378) {
/* 1484 */           agg_isNull377 = true;
/* 1485 */         } else {
/* 1486 */           agg_value412 = (double)(agg_value413 / agg_value415);
/* 1487 */         }
/* 1488 */       }
/* 1489 */       boolean agg_isNull386 = agg_isNull317;
/* 1490 */       double agg_value421 = -1.0;
/* 1491 */       if (!agg_isNull317) {
/* 1492 */         agg_value421 = (double) agg_value352;
/* 1493 */       }
/* 1494 */       boolean agg_isNull383 = false;
/* 1495 */       double agg_value418 = -1.0;
/* 1496 */       if (agg_isNull386 || agg_value421 == 0) {
/* 1497 */         agg_isNull383 = true;
/* 1498 */       } else {
/* 1499 */         boolean agg_isNull384 = agg_isNull316;
/* 1500 */         double agg_value419 = -1.0;
/* 1501 */         if (!agg_isNull316) {
/* 1502 */           agg_value419 = agg_value351;
/* 1503 */         }
/* 1504 */         if (agg_isNull384) {
/* 1505 */           agg_isNull383 = true;
/* 1506 */         } else {
/* 1507 */           agg_value418 = (double)(agg_value419 / agg_value421);
/* 1508 */         }
/* 1509 */       }
/* 1510 */       boolean agg_isNull389 = false;
/* 1511 */
/* 1512 */       boolean agg_value424 = false;
/* 1513 */       agg_value424 = (java.lang.Double.isNaN(agg_value353) && java.lang.Double.isNaN(0.0D)) || agg_value353 == 0.0D;
/* 1514 */       boolean agg_isNull388 = false;
/* 1515 */       double agg_value423 = -1.0;
/* 1516 */       if (!false && agg_value424) {
/* 1517 */         final double agg_value427 = -1.0;
/* 1518 */         agg_isNull388 = true;
/* 1519 */         agg_value423 = agg_value427;
/* 1520 */       } else {
/* 1521 */         boolean agg_isNull394 = false;
/* 1522 */
/* 1523 */         boolean agg_value429 = false;
/* 1524 */         agg_value429 = (java.lang.Double.isNaN(agg_value353) && java.lang.Double.isNaN(1.0D)) || agg_value353 == 1.0D;
/* 1525 */         boolean agg_isNull393 = false;
/* 1526 */         double agg_value428 = -1.0;
/* 1527 */         if (!false && agg_value429) {
/* 1528 */           Object agg_obj2 = ((Expression) references[5]).eval(null);
/* 1529 */           double agg_value432 = (Double) agg_obj2;
/* 1530 */           agg_isNull393 = false;
/* 1531 */           agg_value428 = agg_value432;
/* 1532 */         } else {
/* 1533 */           boolean agg_isNull401 = false;
/* 1534 */
/* 1535 */           double agg_value436 = -1.0;
/* 1536 */           agg_value436 = agg_value353 - 1.0D;
/* 1537 */           boolean agg_isNull399 = false;
/* 1538 */           double agg_value434 = -1.0;
/* 1539 */           if (agg_value436 == 0) {
/* 1540 */             agg_isNull399 = true;
/* 1541 */           } else {
/* 1542 */             agg_value434 = (double)(agg_value355 / agg_value436);
/* 1543 */           }
/* 1544 */           boolean agg_isNull398 = agg_isNull399;
/* 1545 */           double agg_value433 = -1.0;
/* 1546 */
/* 1547 */           if (!agg_isNull399) {
/* 1548 */             agg_value433 = java.lang.Math.sqrt(agg_value434);
/* 1549 */           }
/* 1550 */           agg_isNull393 = agg_isNull398;
/* 1551 */           agg_value428 = agg_value433;
/* 1552 */         }
/* 1553 */         agg_isNull388 = agg_isNull393;
/* 1554 */         agg_value423 = agg_value428;
/* 1555 */       }
/* 1556 */       boolean agg_isNull405 = false;
/* 1557 */
/* 1558 */       boolean agg_value440 = false;
/* 1559 */       agg_value440 = (java.lang.Double.isNaN(agg_value356) && java.lang.Double.isNaN(0.0D)) || agg_value356 == 0.0D;
/* 1560 */       boolean agg_isNull404 = false;
/* 1561 */       double agg_value439 = -1.0;
/* 1562 */       if (!false && agg_value440) {
/* 1563 */         final double agg_value443 = -1.0;
/* 1564 */         agg_isNull404 = true;
/* 1565 */         agg_value439 = agg_value443;
/* 1566 */       } else {
/* 1567 */         boolean agg_isNull410 = false;
/* 1568 */
/* 1569 */         boolean agg_value445 = false;
/* 1570 */         agg_value445 = (java.lang.Double.isNaN(agg_value356) && java.lang.Double.isNaN(1.0D)) || agg_value356 == 1.0D;
/* 1571 */         boolean agg_isNull409 = false;
/* 1572 */         double agg_value444 = -1.0;
/* 1573 */         if (!false && agg_value445) {
/* 1574 */           Object agg_obj3 = ((Expression) references[6]).eval(null);
/* 1575 */           double agg_value448 = (Double) agg_obj3;
/* 1576 */           agg_isNull409 = false;
/* 1577 */           agg_value444 = agg_value448;
/* 1578 */         } else {
/* 1579 */           boolean agg_isNull417 = false;
/* 1580 */
/* 1581 */           double agg_value452 = -1.0;
/* 1582 */           agg_value452 = agg_value356 - 1.0D;
/* 1583 */           boolean agg_isNull415 = false;
/* 1584 */           double agg_value450 = -1.0;
/* 1585 */           if (agg_value452 == 0) {
/* 1586 */             agg_isNull415 = true;
/* 1587 */           } else {
/* 1588 */             agg_value450 = (double)(agg_value358 / agg_value452);
/* 1589 */           }
/* 1590 */           boolean agg_isNull414 = agg_isNull415;
/* 1591 */           double agg_value449 = -1.0;
/* 1592 */
/* 1593 */           if (!agg_isNull415) {
/* 1594 */             agg_value449 = java.lang.Math.sqrt(agg_value450);
/* 1595 */           }
/* 1596 */           agg_isNull409 = agg_isNull414;
/* 1597 */           agg_value444 = agg_value449;
/* 1598 */         }
/* 1599 */         agg_isNull404 = agg_isNull409;
/* 1600 */         agg_value439 = agg_value444;
/* 1601 */       }
/* 1602 */       boolean agg_isNull423 = agg_isNull325;
/* 1603 */       double agg_value458 = -1.0;
/* 1604 */       if (!agg_isNull325) {
/* 1605 */         agg_value458 = (double) agg_value360;
/* 1606 */       }
/* 1607 */       boolean agg_isNull420 = false;
/* 1608 */       double agg_value455 = -1.0;
/* 1609 */       if (agg_isNull423 || agg_value458 == 0) {
/* 1610 */         agg_isNull420 = true;
/* 1611 */       } else {
/* 1612 */         boolean agg_isNull421 = agg_isNull324;
/* 1613 */         double agg_value456 = -1.0;
/* 1614 */         if (!agg_isNull324) {
/* 1615 */           agg_value456 = agg_value359;
/* 1616 */         }
/* 1617 */         if (agg_isNull421) {
/* 1618 */           agg_isNull420 = true;
/* 1619 */         } else {
/* 1620 */           agg_value455 = (double)(agg_value456 / agg_value458);
/* 1621 */         }
/* 1622 */       }
/* 1623 */       boolean agg_isNull429 = agg_isNull328;
/* 1624 */       double agg_value464 = -1.0;
/* 1625 */       if (!agg_isNull328) {
/* 1626 */         agg_value464 = (double) agg_value363;
/* 1627 */       }
/* 1628 */       boolean agg_isNull426 = false;
/* 1629 */       double agg_value461 = -1.0;
/* 1630 */       if (agg_isNull429 || agg_value464 == 0) {
/* 1631 */         agg_isNull426 = true;
/* 1632 */       } else {
/* 1633 */         boolean agg_isNull427 = agg_isNull327;
/* 1634 */         double agg_value462 = -1.0;
/* 1635 */         if (!agg_isNull327) {
/* 1636 */           agg_value462 = agg_value362;
/* 1637 */         }
/* 1638 */         if (agg_isNull427) {
/* 1639 */           agg_isNull426 = true;
/* 1640 */         } else {
/* 1641 */           agg_value461 = (double)(agg_value462 / agg_value464);
/* 1642 */         }
/* 1643 */       }
/* 1644 */       boolean agg_isNull432 = false;
/* 1645 */
/* 1646 */       boolean agg_value467 = false;
/* 1647 */       agg_value467 = (java.lang.Double.isNaN(agg_value364) && java.lang.Double.isNaN(0.0D)) || agg_value364 == 0.0D;
/* 1648 */       boolean agg_isNull431 = false;
/* 1649 */       double agg_value466 = -1.0;
/* 1650 */       if (!false && agg_value467) {
/* 1651 */         final double agg_value470 = -1.0;
/* 1652 */         agg_isNull431 = true;
/* 1653 */         agg_value466 = agg_value470;
/* 1654 */       } else {
/* 1655 */         boolean agg_isNull437 = false;
/* 1656 */
/* 1657 */         boolean agg_value472 = false;
/* 1658 */         agg_value472 = (java.lang.Double.isNaN(agg_value364) && java.lang.Double.isNaN(1.0D)) || agg_value364 == 1.0D;
/* 1659 */         boolean agg_isNull436 = false;
/* 1660 */         double agg_value471 = -1.0;
/* 1661 */         if (!false && agg_value472) {
/* 1662 */           Object agg_obj4 = ((Expression) references[7]).eval(null);
/* 1663 */           double agg_value475 = (Double) agg_obj4;
/* 1664 */           agg_isNull436 = false;
/* 1665 */           agg_value471 = agg_value475;
/* 1666 */         } else {
/* 1667 */           boolean agg_isNull444 = false;
/* 1668 */
/* 1669 */           double agg_value479 = -1.0;
/* 1670 */           agg_value479 = agg_value364 - 1.0D;
/* 1671 */           boolean agg_isNull442 = false;
/* 1672 */           double agg_value477 = -1.0;
/* 1673 */           if (agg_value479 == 0) {
/* 1674 */             agg_isNull442 = true;
/* 1675 */           } else {
/* 1676 */             agg_value477 = (double)(agg_value366 / agg_value479);
/* 1677 */           }
/* 1678 */           boolean agg_isNull441 = agg_isNull442;
/* 1679 */           double agg_value476 = -1.0;
/* 1680 */
/* 1681 */           if (!agg_isNull442) {
/* 1682 */             agg_value476 = java.lang.Math.sqrt(agg_value477);
/* 1683 */           }
/* 1684 */           agg_isNull436 = agg_isNull441;
/* 1685 */           agg_value471 = agg_value476;
/* 1686 */         }
/* 1687 */         agg_isNull431 = agg_isNull436;
/* 1688 */         agg_value466 = agg_value471;
/* 1689 */       }
/* 1690 */       boolean agg_isNull450 = agg_isNull333;
/* 1691 */       double agg_value485 = -1.0;
/* 1692 */       if (!agg_isNull333) {
/* 1693 */         agg_value485 = (double) agg_value368;
/* 1694 */       }
/* 1695 */       boolean agg_isNull447 = false;
/* 1696 */       double agg_value482 = -1.0;
/* 1697 */       if (agg_isNull450 || agg_value485 == 0) {
/* 1698 */         agg_isNull447 = true;
/* 1699 */       } else {
/* 1700 */         boolean agg_isNull448 = agg_isNull332;
/* 1701 */         double agg_value483 = -1.0;
/* 1702 */         if (!agg_isNull332) {
/* 1703 */           agg_value483 = agg_value367;
/* 1704 */         }
/* 1705 */         if (agg_isNull448) {
/* 1706 */           agg_isNull447 = true;
/* 1707 */         } else {
/* 1708 */           agg_value482 = (double)(agg_value483 / agg_value485);
/* 1709 */         }
/* 1710 */       }
/* 1711 */       boolean agg_isNull453 = false;
/* 1712 */
/* 1713 */       boolean agg_value488 = false;
/* 1714 */       agg_value488 = (java.lang.Double.isNaN(agg_value369) && java.lang.Double.isNaN(0.0D)) || agg_value369 == 0.0D;
/* 1715 */       boolean agg_isNull452 = false;
/* 1716 */       double agg_value487 = -1.0;
/* 1717 */       if (!false && agg_value488) {
/* 1718 */         final double agg_value491 = -1.0;
/* 1719 */         agg_isNull452 = true;
/* 1720 */         agg_value487 = agg_value491;
/* 1721 */       } else {
/* 1722 */         boolean agg_isNull458 = false;
/* 1723 */
/* 1724 */         boolean agg_value493 = false;
/* 1725 */         agg_value493 = (java.lang.Double.isNaN(agg_value369) && java.lang.Double.isNaN(1.0D)) || agg_value369 == 1.0D;
/* 1726 */         boolean agg_isNull457 = false;
/* 1727 */         double agg_value492 = -1.0;
/* 1728 */         if (!false && agg_value493) {
/* 1729 */           Object agg_obj5 = ((Expression) references[8]).eval(null);
/* 1730 */           double agg_value496 = (Double) agg_obj5;
/* 1731 */           agg_isNull457 = false;
/* 1732 */           agg_value492 = agg_value496;
/* 1733 */         } else {
/* 1734 */           boolean agg_isNull465 = false;
/* 1735 */
/* 1736 */           double agg_value500 = -1.0;
/* 1737 */           agg_value500 = agg_value369 - 1.0D;
/* 1738 */           boolean agg_isNull463 = false;
/* 1739 */           double agg_value498 = -1.0;
/* 1740 */           if (agg_value500 == 0) {
/* 1741 */             agg_isNull463 = true;
/* 1742 */           } else {
/* 1743 */             agg_value498 = (double)(agg_value371 / agg_value500);
/* 1744 */           }
/* 1745 */           boolean agg_isNull462 = agg_isNull463;
/* 1746 */           double agg_value497 = -1.0;
/* 1747 */
/* 1748 */           if (!agg_isNull463) {
/* 1749 */             agg_value497 = java.lang.Math.sqrt(agg_value498);
/* 1750 */           }
/* 1751 */           agg_isNull457 = agg_isNull462;
/* 1752 */           agg_value492 = agg_value497;
/* 1753 */         }
/* 1754 */         agg_isNull452 = agg_isNull457;
/* 1755 */         agg_value487 = agg_value492;
/* 1756 */       }
/* 1757 */       boolean agg_isNull471 = agg_isNull338;
/* 1758 */       double agg_value506 = -1.0;
/* 1759 */       if (!agg_isNull338) {
/* 1760 */         agg_value506 = (double) agg_value373;
/* 1761 */       }
/* 1762 */       boolean agg_isNull468 = false;
/* 1763 */       double agg_value503 = -1.0;
/* 1764 */       if (agg_isNull471 || agg_value506 == 0) {
/* 1765 */         agg_isNull468 = true;
/* 1766 */       } else {
/* 1767 */         boolean agg_isNull469 = agg_isNull337;
/* 1768 */         double agg_value504 = -1.0;
/* 1769 */         if (!agg_isNull337) {
/* 1770 */           agg_value504 = agg_value372;
/* 1771 */         }
/* 1772 */         if (agg_isNull469) {
/* 1773 */           agg_isNull468 = true;
/* 1774 */         } else {
/* 1775 */           agg_value503 = (double)(agg_value504 / agg_value506);
/* 1776 */         }
/* 1777 */       }
/* 1778 */
/* 1779 */       boolean agg_isNull479 = false;
/* 1780 */       double agg_value514 = -1.0;
/* 1781 */       if (agg_isNull377 || agg_value412 == 0) {
/* 1782 */         agg_isNull479 = true;
/* 1783 */       } else {
/* 1784 */         if (agg_isNull361) {
/* 1785 */           agg_isNull479 = true;
/* 1786 */         } else {
/* 1787 */           agg_value514 = (double)(agg_value396 / agg_value412);
/* 1788 */         }
/* 1789 */       }
/* 1790 */       boolean agg_isNull485 = false;
/* 1791 */       double agg_value520 = -1.0;
/* 1792 */       if (agg_isNull420 || agg_value455 == 0) {
/* 1793 */         agg_isNull485 = true;
/* 1794 */       } else {
/* 1795 */         if (agg_isNull404) {
/* 1796 */           agg_isNull485 = true;
/* 1797 */         } else {
/* 1798 */           agg_value520 = (double)(agg_value439 / agg_value455);
/* 1799 */         }
/* 1800 */       }
/* 1801 */       boolean agg_isNull490 = false;
/* 1802 */       double agg_value525 = -1.0;
/* 1803 */       if (agg_isNull447 || agg_value482 == 0) {
/* 1804 */         agg_isNull490 = true;
/* 1805 */       } else {
/* 1806 */         if (agg_isNull431) {
/* 1807 */           agg_isNull490 = true;
/* 1808 */         } else {
/* 1809 */           agg_value525 = (double)(agg_value466 / agg_value482);
/* 1810 */         }
/* 1811 */       }
/* 1812 */       boolean agg_isNull493 = false;
/* 1813 */       double agg_value528 = -1.0;
/* 1814 */       if (agg_isNull468 || agg_value503 == 0) {
/* 1815 */         agg_isNull493 = true;
/* 1816 */       } else {
/* 1817 */         if (agg_isNull452) {
/* 1818 */           agg_isNull493 = true;
/* 1819 */         } else {
/* 1820 */           agg_value528 = (double)(agg_value487 / agg_value503);
/* 1821 */         }
/* 1822 */       }
/* 1823 */       agg_holder1.reset();
/* 1824 */
/* 1825 */       agg_rowWriter1.zeroOutNullBytes();
/* 1826 */
/* 1827 */       if (agg_isNull301) {
/* 1828 */         agg_rowWriter1.setNullAt(0);
/* 1829 */       } else {
/* 1830 */         agg_rowWriter1.write(0, agg_value336);
/* 1831 */       }
/* 1832 */
/* 1833 */       if (agg_isNull302) {
/* 1834 */         agg_rowWriter1.setNullAt(1);
/* 1835 */       } else {
/* 1836 */         agg_rowWriter1.write(1, agg_value337);
/* 1837 */       }
/* 1838 */
/* 1839 */       if (agg_isNull303) {
/* 1840 */         agg_rowWriter1.setNullAt(2);
/* 1841 */       } else {
/* 1842 */         agg_rowWriter1.write(2, agg_value338);
/* 1843 */       }
/* 1844 */
/* 1845 */       agg_rowWriter1.write(3, agg_value339);
/* 1846 */
/* 1847 */       if (agg_isNull340) {
/* 1848 */         agg_rowWriter1.setNullAt(4);
/* 1849 */       } else {
/* 1850 */         agg_rowWriter1.write(4, agg_value375);
/* 1851 */       }
/* 1852 */
/* 1853 */       if (agg_isNull345) {
/* 1854 */         agg_rowWriter1.setNullAt(5);
/* 1855 */       } else {
/* 1856 */         agg_rowWriter1.write(5, agg_value380);
/* 1857 */       }
/* 1858 */
/* 1859 */       if (agg_isNull479) {
/* 1860 */         agg_rowWriter1.setNullAt(6);
/* 1861 */       } else {
/* 1862 */         agg_rowWriter1.write(6, agg_value514);
/* 1863 */       }
/* 1864 */
/* 1865 */       agg_rowWriter1.write(7, agg_value350);
/* 1866 */
/* 1867 */       if (agg_isNull383) {
/* 1868 */         agg_rowWriter1.setNullAt(8);
/* 1869 */       } else {
/* 1870 */         agg_rowWriter1.write(8, agg_value418);
/* 1871 */       }
/* 1872 */
/* 1873 */       if (agg_isNull388) {
/* 1874 */         agg_rowWriter1.setNullAt(9);
/* 1875 */       } else {
/* 1876 */         agg_rowWriter1.write(9, agg_value423);
/* 1877 */       }
/* 1878 */
/* 1879 */       if (agg_isNull485) {
/* 1880 */         agg_rowWriter1.setNullAt(10);
/* 1881 */       } else {
/* 1882 */         agg_rowWriter1.write(10, agg_value520);
/* 1883 */       }
/* 1884 */
/* 1885 */       agg_rowWriter1.write(11, agg_value361);
/* 1886 */
/* 1887 */       if (agg_isNull426) {
/* 1888 */         agg_rowWriter1.setNullAt(12);
/* 1889 */       } else {
/* 1890 */         agg_rowWriter1.write(12, agg_value461);
/* 1891 */       }
/* 1892 */
/* 1893 */       if (agg_isNull490) {
/* 1894 */         agg_rowWriter1.setNullAt(13);
/* 1895 */       } else {
/* 1896 */         agg_rowWriter1.write(13, agg_value525);
/* 1897 */       }
/* 1898 */
/* 1899 */       if (agg_isNull493) {
/* 1900 */         agg_rowWriter1.setNullAt(14);
/* 1901 */       } else {
/* 1902 */         agg_rowWriter1.write(14, agg_value528);
/* 1903 */       }
/* 1904 */       agg_result1.setTotalSize(agg_holder1.totalSize());
/* 1905 */       append(agg_result1);
/* 1906 */
/* 1907 */       if (shouldStop()) return;
/* 1908 */     }
/* 1909 */
/* 1910 */     agg_mapIter.close();
/* 1911 */     if (agg_sorter == null) {
/* 1912 */       agg_hashMap.free();
/* 1913 */     }
/* 1914 */   }
/* 1915 */ }
