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
/* 014 */   private long agg_bufValue2;
/* 015 */   private boolean agg_initAgg1;
/* 016 */   private boolean agg_bufIsNull3;
/* 017 */   private double agg_bufValue3;
/* 018 */   private boolean agg_bufIsNull4;
/* 019 */   private double agg_bufValue4;
/* 020 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 021 */   private agg_FastHashMap agg_fastHashMap;
/* 022 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter;
/* 023 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 024 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 025 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 028 */   private boolean agg_initAgg2;
/* 029 */   private boolean agg_bufIsNull5;
/* 030 */   private double agg_bufValue5;
/* 031 */   private boolean agg_bufIsNull6;
/* 032 */   private double agg_bufValue6;
/* 033 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan1;
/* 034 */   private agg_FastHashMap1 agg_fastHashMap1;
/* 035 */   private org.apache.spark.unsafe.KVIterator agg_fastHashMapIter1;
/* 036 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap1;
/* 037 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter1;
/* 038 */   private org.apache.spark.unsafe.KVIterator agg_mapIter1;
/* 039 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory1;
/* 040 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize1;
/* 041 */   private scala.collection.Iterator inputadapter_input;
/* 042 */   private UnsafeRow project_result;
/* 043 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 045 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 046 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 047 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 048 */   private UnsafeRow bhj_result;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 050 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 051 */   private UnsafeRow project_result1;
/* 052 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 053 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 054 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 055 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 056 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 057 */   private UnsafeRow bhj_result1;
/* 058 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 059 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 060 */   private UnsafeRow project_result2;
/* 061 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 062 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 063 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 064 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 065 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 066 */   private UnsafeRow bhj_result2;
/* 067 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 068 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 069 */   private UnsafeRow project_result3;
/* 070 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder3;
/* 071 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter3;
/* 072 */   private UnsafeRow agg_result2;
/* 073 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 074 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 075 */   private int agg_value13;
/* 076 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner;
/* 077 */   private UnsafeRow agg_result3;
/* 078 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 079 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 080 */   private int agg_value52;
/* 081 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows;
/* 082 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime;
/* 083 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowJoiner agg_unsafeRowJoiner1;
/* 084 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows1;
/* 085 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime1;
/* 086 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_numOutputRows2;
/* 087 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_aggTime2;
/* 088 */   private UnsafeRow agg_result4;
/* 089 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder2;
/* 090 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter2;
/* 091 */
/* 092 */   public GeneratedIterator(Object[] references) {
/* 093 */     this.references = references;
/* 094 */   }
/* 095 */
/* 096 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 097 */     partitionIndex = index;
/* 098 */     this.inputs = inputs;
/* 099 */     wholestagecodegen_init_0();
/* 100 */     wholestagecodegen_init_1();
/* 101 */     wholestagecodegen_init_2();
/* 102 */     wholestagecodegen_init_3();
/* 103 */     wholestagecodegen_init_4();
/* 104 */
/* 105 */   }
/* 106 */
/* 107 */   private void wholestagecodegen_init_0() {
/* 108 */     agg_initAgg = false;
/* 109 */
/* 110 */     agg_initAgg1 = false;
/* 111 */
/* 112 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 113 */     agg_fastHashMap = new agg_FastHashMap(agg_plan.getTaskMemoryManager(), agg_plan.getEmptyAggregationBuffer());
/* 114 */
/* 115 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 116 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 117 */     agg_initAgg2 = false;
/* 118 */
/* 119 */     this.agg_plan1 = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[6];
/* 120 */     agg_fastHashMap1 = new agg_FastHashMap1(agg_plan1.getTaskMemoryManager(), agg_plan1.getEmptyAggregationBuffer());
/* 121 */
/* 122 */     this.agg_peakMemory1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[7];
/* 123 */     this.agg_spillSize1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 124 */     inputadapter_input = inputs[0];
/* 125 */     project_result = new UnsafeRow(6);
/* 126 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 127 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 6);
/* 128 */
/* 129 */   }
/* 130 */
/* 131 */   private void agg_doAggregateWithoutKey() throws java.io.IOException {
/* 132 */     // initialize aggregation buffer
/* 133 */     final double agg_value = -1.0;
/* 134 */     agg_bufIsNull = true;
/* 135 */     agg_bufValue = agg_value;
/* 136 */     final double agg_value1 = -1.0;
/* 137 */     agg_bufIsNull1 = true;
/* 138 */     agg_bufValue1 = agg_value1;
/* 139 */     agg_bufIsNull2 = false;
/* 140 */     agg_bufValue2 = 0L;
/* 141 */
/* 142 */     if (!agg_initAgg1) {
/* 143 */       agg_initAgg1 = true;
/* 144 */       long agg_beforeAgg1 = System.nanoTime();
/* 145 */       agg_doAggregateWithKeys();
/* 146 */       agg_aggTime1.add((System.nanoTime() - agg_beforeAgg1) / 1000000);
/* 147 */     }
/* 148 */
/* 149 */     // output the result
/* 150 */
/* 151 */     while (agg_fastHashMapIter.next()) {
/* 152 */       agg_numOutputRows1.add(1);
/* 153 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_fastHashMapIter.getKey();
/* 154 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_fastHashMapIter.getValue();
/* 155 */
/* 156 */       UnsafeRow agg_resultRow1 = agg_unsafeRowJoiner1.join(agg_aggKey1, agg_aggBuffer1);
/* 157 */
/* 158 */       boolean agg_isNull82 = agg_resultRow1.isNullAt(0);
/* 159 */       int agg_value86 = agg_isNull82 ? -1 : (agg_resultRow1.getInt(0));
/* 160 */       boolean agg_isNull83 = agg_resultRow1.isNullAt(1);
/* 161 */       double agg_value87 = agg_isNull83 ? -1.0 : (agg_resultRow1.getDouble(1));
/* 162 */       boolean agg_isNull84 = agg_resultRow1.isNullAt(2);
/* 163 */       double agg_value88 = agg_isNull84 ? -1.0 : (agg_resultRow1.getDouble(2));
/* 164 */
/* 165 */       // do aggregate
/* 166 */       // common sub-expressions
/* 167 */
/* 168 */       // evaluate aggregate function
/* 169 */       boolean agg_isNull86 = true;
/* 170 */       double agg_value90 = -1.0;
/* 171 */
/* 172 */       boolean agg_isNull87 = agg_bufIsNull;
/* 173 */       double agg_value91 = agg_bufValue;
/* 174 */       if (agg_isNull87) {
/* 175 */         boolean agg_isNull89 = false;
/* 176 */         double agg_value93 = -1.0;
/* 177 */         if (!false) {
/* 178 */           agg_value93 = (double) 0;
/* 179 */         }
/* 180 */         if (!agg_isNull89) {
/* 181 */           agg_isNull87 = false;
/* 182 */           agg_value91 = agg_value93;
/* 183 */         }
/* 184 */       }
/* 185 */
/* 186 */       if (!agg_isNull83) {
/* 187 */         agg_isNull86 = false; // resultCode could change nullability.
/* 188 */         agg_value90 = agg_value91 + agg_value87;
/* 189 */
/* 190 */       }
/* 191 */       boolean agg_isNull85 = agg_isNull86;
/* 192 */       double agg_value89 = agg_value90;
/* 193 */       if (agg_isNull85) {
/* 194 */         if (!agg_bufIsNull) {
/* 195 */           agg_isNull85 = false;
/* 196 */           agg_value89 = agg_bufValue;
/* 197 */         }
/* 198 */       }
/* 199 */       boolean agg_isNull94 = true;
/* 200 */       double agg_value98 = -1.0;
/* 201 */
/* 202 */       boolean agg_isNull95 = agg_bufIsNull1;
/* 203 */       double agg_value99 = agg_bufValue1;
/* 204 */       if (agg_isNull95) {
/* 205 */         boolean agg_isNull97 = false;
/* 206 */         double agg_value101 = -1.0;
/* 207 */         if (!false) {
/* 208 */           agg_value101 = (double) 0;
/* 209 */         }
/* 210 */         if (!agg_isNull97) {
/* 211 */           agg_isNull95 = false;
/* 212 */           agg_value99 = agg_value101;
/* 213 */         }
/* 214 */       }
/* 215 */
/* 216 */       if (!agg_isNull84) {
/* 217 */         agg_isNull94 = false; // resultCode could change nullability.
/* 218 */         agg_value98 = agg_value99 + agg_value88;
/* 219 */
/* 220 */       }
/* 221 */       boolean agg_isNull93 = agg_isNull94;
/* 222 */       double agg_value97 = agg_value98;
/* 223 */       if (agg_isNull93) {
/* 224 */         if (!agg_bufIsNull1) {
/* 225 */           agg_isNull93 = false;
/* 226 */           agg_value97 = agg_bufValue1;
/* 227 */         }
/* 228 */       }
/* 229 */       boolean agg_isNull101 = false;
/* 230 */       long agg_value105 = -1L;
/* 231 */       if (!false && agg_isNull82) {
/* 232 */         agg_isNull101 = agg_bufIsNull2;
/* 233 */         agg_value105 = agg_bufValue2;
/* 234 */       } else {
/* 235 */         boolean agg_isNull105 = false;
/* 236 */
/* 237 */         long agg_value109 = -1L;
/* 238 */         agg_value109 = agg_bufValue2 + 1L;
/* 239 */         agg_isNull101 = false;
/* 240 */         agg_value105 = agg_value109;
/* 241 */       }
/* 242 */       // update aggregation buffer
/* 243 */       agg_bufIsNull = agg_isNull85;
/* 244 */       agg_bufValue = agg_value89;
/* 245 */
/* 246 */       agg_bufIsNull1 = agg_isNull93;
/* 247 */       agg_bufValue1 = agg_value97;
/* 248 */
/* 249 */       agg_bufIsNull2 = agg_isNull101;
/* 250 */       agg_bufValue2 = agg_value105;
/* 251 */
/* 252 */       if (shouldStop()) return;
/* 253 */     }
/* 254 */     agg_fastHashMap.close();
/* 255 */
/* 256 */     while (agg_mapIter.next()) {
/* 257 */       agg_numOutputRows1.add(1);
/* 258 */       UnsafeRow agg_aggKey1 = (UnsafeRow) agg_mapIter.getKey();
/* 259 */       UnsafeRow agg_aggBuffer1 = (UnsafeRow) agg_mapIter.getValue();
/* 260 */
/* 261 */       UnsafeRow agg_resultRow1 = agg_unsafeRowJoiner1.join(agg_aggKey1, agg_aggBuffer1);
/* 262 */
/* 263 */       boolean agg_isNull82 = agg_resultRow1.isNullAt(0);
/* 264 */       int agg_value86 = agg_isNull82 ? -1 : (agg_resultRow1.getInt(0));
/* 265 */       boolean agg_isNull83 = agg_resultRow1.isNullAt(1);
/* 266 */       double agg_value87 = agg_isNull83 ? -1.0 : (agg_resultRow1.getDouble(1));
/* 267 */       boolean agg_isNull84 = agg_resultRow1.isNullAt(2);
/* 268 */       double agg_value88 = agg_isNull84 ? -1.0 : (agg_resultRow1.getDouble(2));
/* 269 */
/* 270 */       // do aggregate
/* 271 */       // common sub-expressions
/* 272 */
/* 273 */       // evaluate aggregate function
/* 274 */       boolean agg_isNull86 = true;
/* 275 */       double agg_value90 = -1.0;
/* 276 */
/* 277 */       boolean agg_isNull87 = agg_bufIsNull;
/* 278 */       double agg_value91 = agg_bufValue;
/* 279 */       if (agg_isNull87) {
/* 280 */         boolean agg_isNull89 = false;
/* 281 */         double agg_value93 = -1.0;
/* 282 */         if (!false) {
/* 283 */           agg_value93 = (double) 0;
/* 284 */         }
/* 285 */         if (!agg_isNull89) {
/* 286 */           agg_isNull87 = false;
/* 287 */           agg_value91 = agg_value93;
/* 288 */         }
/* 289 */       }
/* 290 */
/* 291 */       if (!agg_isNull83) {
/* 292 */         agg_isNull86 = false; // resultCode could change nullability.
/* 293 */         agg_value90 = agg_value91 + agg_value87;
/* 294 */
/* 295 */       }
/* 296 */       boolean agg_isNull85 = agg_isNull86;
/* 297 */       double agg_value89 = agg_value90;
/* 298 */       if (agg_isNull85) {
/* 299 */         if (!agg_bufIsNull) {
/* 300 */           agg_isNull85 = false;
/* 301 */           agg_value89 = agg_bufValue;
/* 302 */         }
/* 303 */       }
/* 304 */       boolean agg_isNull94 = true;
/* 305 */       double agg_value98 = -1.0;
/* 306 */
/* 307 */       boolean agg_isNull95 = agg_bufIsNull1;
/* 308 */       double agg_value99 = agg_bufValue1;
/* 309 */       if (agg_isNull95) {
/* 310 */         boolean agg_isNull97 = false;
/* 311 */         double agg_value101 = -1.0;
/* 312 */         if (!false) {
/* 313 */           agg_value101 = (double) 0;
/* 314 */         }
/* 315 */         if (!agg_isNull97) {
/* 316 */           agg_isNull95 = false;
/* 317 */           agg_value99 = agg_value101;
/* 318 */         }
/* 319 */       }
/* 320 */
/* 321 */       if (!agg_isNull84) {
/* 322 */         agg_isNull94 = false; // resultCode could change nullability.
/* 323 */         agg_value98 = agg_value99 + agg_value88;
/* 324 */
/* 325 */       }
/* 326 */       boolean agg_isNull93 = agg_isNull94;
/* 327 */       double agg_value97 = agg_value98;
/* 328 */       if (agg_isNull93) {
/* 329 */         if (!agg_bufIsNull1) {
/* 330 */           agg_isNull93 = false;
/* 331 */           agg_value97 = agg_bufValue1;
/* 332 */         }
/* 333 */       }
/* 334 */       boolean agg_isNull101 = false;
/* 335 */       long agg_value105 = -1L;
/* 336 */       if (!false && agg_isNull82) {
/* 337 */         agg_isNull101 = agg_bufIsNull2;
/* 338 */         agg_value105 = agg_bufValue2;
/* 339 */       } else {
/* 340 */         boolean agg_isNull105 = false;
/* 341 */
/* 342 */         long agg_value109 = -1L;
/* 343 */         agg_value109 = agg_bufValue2 + 1L;
/* 344 */         agg_isNull101 = false;
/* 345 */         agg_value105 = agg_value109;
/* 346 */       }
/* 347 */       // update aggregation buffer
/* 348 */       agg_bufIsNull = agg_isNull85;
/* 349 */       agg_bufValue = agg_value89;
/* 350 */
/* 351 */       agg_bufIsNull1 = agg_isNull93;
/* 352 */       agg_bufValue1 = agg_value97;
/* 353 */
/* 354 */       agg_bufIsNull2 = agg_isNull101;
/* 355 */       agg_bufValue2 = agg_value105;
/* 356 */
/* 357 */       if (shouldStop()) return;
/* 358 */     }
/* 359 */
/* 360 */     agg_mapIter.close();
/* 361 */     if (agg_sorter == null) {
/* 362 */       agg_hashMap.free();
/* 363 */     }
/* 364 */
/* 365 */   }
/* 366 */
/* 367 */   private void wholestagecodegen_init_3() {
/* 368 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 5);
/* 369 */     project_result3 = new UnsafeRow(3);
/* 370 */     this.project_holder3 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result3, 0);
/* 371 */     this.project_rowWriter3 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder3, 3);
/* 372 */     agg_result2 = new UnsafeRow(1);
/* 373 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result2, 0);
/* 374 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 375 */
/* 376 */     agg_unsafeRowJoiner = agg_plan1.createUnsafeJoiner();
/* 377 */     agg_result3 = new UnsafeRow(1);
/* 378 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result3, 0);
/* 379 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 1);
/* 380 */
/* 381 */     this.agg_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[18];
/* 382 */     this.agg_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[19];
/* 383 */
/* 384 */   }
/* 385 */
/* 386 */   public class agg_FastHashMap {
/* 387 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 388 */     private int[] buckets;
/* 389 */     private int capacity = 1 << 16;
/* 390 */     private double loadFactor = 0.5;
/* 391 */     private int numBuckets = (int) (capacity / loadFactor);
/* 392 */     private int maxSteps = 2;
/* 393 */     private int numRows = 0;
/* 394 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[3])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 395 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[4])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 396 */     .add("((java.lang.String) references[5])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 397 */     private Object emptyVBase;
/* 398 */     private long emptyVOff;
/* 399 */     private int emptyVLen;
/* 400 */     private boolean isBatchFull = false;
/* 401 */
/* 402 */     public agg_FastHashMap(
/* 403 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 404 */       InternalRow emptyAggregationBuffer) {
/* 405 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 406 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 407 */
/* 408 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 409 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 410 */
/* 411 */       emptyVBase = emptyBuffer;
/* 412 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 413 */       emptyVLen = emptyBuffer.length;
/* 414 */
/* 415 */       buckets = new int[numBuckets];
/* 416 */       java.util.Arrays.fill(buckets, -1);
/* 417 */     }
/* 418 */
/* 419 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key) {
/* 420 */       long h = hash(agg_key);
/* 421 */       int step = 0;
/* 422 */       int idx = (int) h & (numBuckets - 1);
/* 423 */       while (step < maxSteps) {
/* 424 */         // Return bucket index if it's either an empty slot or already contains the key
/* 425 */         if (buckets[idx] == -1) {
/* 426 */           if (numRows < capacity && !isBatchFull) {
/* 427 */             // creating the unsafe for new entry
/* 428 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 429 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 430 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 431 */               0);
/* 432 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 433 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 434 */               agg_holder,
/* 435 */               1);
/* 436 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 437 */             agg_rowWriter.zeroOutNullBytes();
/* 438 */             agg_rowWriter.write(0, agg_key);
/* 439 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 440 */             Object kbase = agg_result.getBaseObject();
/* 441 */             long koff = agg_result.getBaseOffset();
/* 442 */             int klen = agg_result.getSizeInBytes();
/* 443 */
/* 444 */             UnsafeRow vRow
/* 445 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 446 */             if (vRow == null) {
/* 447 */               isBatchFull = true;
/* 448 */             } else {
/* 449 */               buckets[idx] = numRows++;
/* 450 */             }
/* 451 */             return vRow;
/* 452 */           } else {
/* 453 */             // No more space
/* 454 */             return null;
/* 455 */           }
/* 456 */         } else if (equals(idx, agg_key)) {
/* 457 */           return batch.getValueRow(buckets[idx]);
/* 458 */         }
/* 459 */         idx = (idx + 1) & (numBuckets - 1);
/* 460 */         step++;
/* 461 */       }
/* 462 */       // Didn't find it
/* 463 */       return null;
/* 464 */     }
/* 465 */
/* 466 */     private boolean equals(int idx, int agg_key) {
/* 467 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 468 */       return (row.getInt(0) == agg_key);
/* 469 */     }
/* 470 */
/* 471 */     private long hash(int agg_key) {
/* 472 */       long agg_hash = 0;
/* 473 */
/* 474 */       int agg_result = agg_key;
/* 475 */       agg_hash = (agg_hash ^ (0x9e3779b9)) + agg_result + (agg_hash << 6) + (agg_hash >>> 2);
/* 476 */
/* 477 */       return agg_hash;
/* 478 */     }
/* 479 */
/* 480 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 481 */       return batch.rowIterator();
/* 482 */     }
/* 483 */
/* 484 */     public void close() {
/* 485 */       batch.close();
/* 486 */     }
/* 487 */
/* 488 */   }
/* 489 */
/* 490 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 491 */     agg_hashMap = agg_plan.createHashMap();
/* 492 */
/* 493 */     if (!agg_initAgg2) {
/* 494 */       agg_initAgg2 = true;
/* 495 */       long agg_beforeAgg = System.nanoTime();
/* 496 */       agg_doAggregateWithKeys1();
/* 497 */       agg_aggTime.add((System.nanoTime() - agg_beforeAgg) / 1000000);
/* 498 */     }
/* 499 */
/* 500 */     // output the result
/* 501 */
/* 502 */     while (agg_fastHashMapIter1.next()) {
/* 503 */       agg_numOutputRows.add(1);
/* 504 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_fastHashMapIter1.getKey();
/* 505 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_fastHashMapIter1.getValue();
/* 506 */
/* 507 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 508 */
/* 509 */       boolean agg_isNull43 = agg_resultRow.isNullAt(0);
/* 510 */       int agg_value47 = agg_isNull43 ? -1 : (agg_resultRow.getInt(0));
/* 511 */       boolean agg_isNull44 = agg_resultRow.isNullAt(1);
/* 512 */       double agg_value48 = agg_isNull44 ? -1.0 : (agg_resultRow.getDouble(1));
/* 513 */       boolean agg_isNull45 = agg_resultRow.isNullAt(2);
/* 514 */       double agg_value49 = agg_isNull45 ? -1.0 : (agg_resultRow.getDouble(2));
/* 515 */
/* 516 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 517 */
/* 518 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 519 */
/* 520 */       if (true) {
/* 521 */         if (!agg_isNull43) {
/* 522 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 523 */             agg_value47);
/* 524 */         }
/* 525 */       }
/* 526 */
/* 527 */       if (agg_fastAggBuffer1 == null) {
/* 528 */         // generate grouping key
/* 529 */         agg_rowWriter1.zeroOutNullBytes();
/* 530 */
/* 531 */         if (agg_isNull43) {
/* 532 */           agg_rowWriter1.setNullAt(0);
/* 533 */         } else {
/* 534 */           agg_rowWriter1.write(0, agg_value47);
/* 535 */         }
/* 536 */         agg_value52 = 42;
/* 537 */
/* 538 */         if (!agg_isNull43) {
/* 539 */           agg_value52 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value47, agg_value52);
/* 540 */         }
/* 541 */         if (true) {
/* 542 */           // try to get the buffer from hash map
/* 543 */           agg_unsafeRowAggBuffer1 =
/* 544 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 545 */         }
/* 546 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 547 */           if (agg_sorter == null) {
/* 548 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 549 */           } else {
/* 550 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 551 */           }
/* 552 */
/* 553 */           // the hash map had be spilled, it should have enough memory now,
/* 554 */           // try  to allocate buffer again.
/* 555 */           agg_unsafeRowAggBuffer1 =
/* 556 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 557 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 558 */             // failed to allocate the first page
/* 559 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 560 */           }
/* 561 */         }
/* 562 */       }
/* 563 */
/* 564 */       if (agg_fastAggBuffer1 != null) {
/* 565 */         // update fast row
/* 566 */
/* 567 */         // common sub-expressions
/* 568 */
/* 569 */         // evaluate aggregate function
/* 570 */         boolean agg_isNull67 = true;
/* 571 */         double agg_value71 = -1.0;
/* 572 */
/* 573 */         boolean agg_isNull69 = agg_fastAggBuffer1.isNullAt(0);
/* 574 */         double agg_value73 = agg_isNull69 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 575 */         boolean agg_isNull68 = agg_isNull69;
/* 576 */         double agg_value72 = agg_value73;
/* 577 */         if (agg_isNull68) {
/* 578 */           boolean agg_isNull70 = false;
/* 579 */           double agg_value74 = -1.0;
/* 580 */           if (!false) {
/* 581 */             agg_value74 = (double) 0;
/* 582 */           }
/* 583 */           if (!agg_isNull70) {
/* 584 */             agg_isNull68 = false;
/* 585 */             agg_value72 = agg_value74;
/* 586 */           }
/* 587 */         }
/* 588 */
/* 589 */         if (!agg_isNull44) {
/* 590 */           agg_isNull67 = false; // resultCode could change nullability.
/* 591 */           agg_value71 = agg_value72 + agg_value48;
/* 592 */
/* 593 */         }
/* 594 */         boolean agg_isNull66 = agg_isNull67;
/* 595 */         double agg_value70 = agg_value71;
/* 596 */         if (agg_isNull66) {
/* 597 */           boolean agg_isNull73 = agg_fastAggBuffer1.isNullAt(0);
/* 598 */           double agg_value77 = agg_isNull73 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 599 */           if (!agg_isNull73) {
/* 600 */             agg_isNull66 = false;
/* 601 */             agg_value70 = agg_value77;
/* 602 */           }
/* 603 */         }
/* 604 */         boolean agg_isNull75 = true;
/* 605 */         double agg_value79 = -1.0;
/* 606 */
/* 607 */         boolean agg_isNull77 = agg_fastAggBuffer1.isNullAt(1);
/* 608 */         double agg_value81 = agg_isNull77 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 609 */         boolean agg_isNull76 = agg_isNull77;
/* 610 */         double agg_value80 = agg_value81;
/* 611 */         if (agg_isNull76) {
/* 612 */           boolean agg_isNull78 = false;
/* 613 */           double agg_value82 = -1.0;
/* 614 */           if (!false) {
/* 615 */             agg_value82 = (double) 0;
/* 616 */           }
/* 617 */           if (!agg_isNull78) {
/* 618 */             agg_isNull76 = false;
/* 619 */             agg_value80 = agg_value82;
/* 620 */           }
/* 621 */         }
/* 622 */
/* 623 */         if (!agg_isNull45) {
/* 624 */           agg_isNull75 = false; // resultCode could change nullability.
/* 625 */           agg_value79 = agg_value80 + agg_value49;
/* 626 */
/* 627 */         }
/* 628 */         boolean agg_isNull74 = agg_isNull75;
/* 629 */         double agg_value78 = agg_value79;
/* 630 */         if (agg_isNull74) {
/* 631 */           boolean agg_isNull81 = agg_fastAggBuffer1.isNullAt(1);
/* 632 */           double agg_value85 = agg_isNull81 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 633 */           if (!agg_isNull81) {
/* 634 */             agg_isNull74 = false;
/* 635 */             agg_value78 = agg_value85;
/* 636 */           }
/* 637 */         }
/* 638 */         // update fast row
/* 639 */         if (!agg_isNull66) {
/* 640 */           agg_fastAggBuffer1.setDouble(0, agg_value70);
/* 641 */         } else {
/* 642 */           agg_fastAggBuffer1.setNullAt(0);
/* 643 */         }
/* 644 */
/* 645 */         if (!agg_isNull74) {
/* 646 */           agg_fastAggBuffer1.setDouble(1, agg_value78);
/* 647 */         } else {
/* 648 */           agg_fastAggBuffer1.setNullAt(1);
/* 649 */         }
/* 650 */
/* 651 */       } else {
/* 652 */         // update unsafe row
/* 653 */
/* 654 */         // common sub-expressions
/* 655 */
/* 656 */         // evaluate aggregate function
/* 657 */         boolean agg_isNull51 = true;
/* 658 */         double agg_value55 = -1.0;
/* 659 */
/* 660 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 661 */         double agg_value57 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 662 */         boolean agg_isNull52 = agg_isNull53;
/* 663 */         double agg_value56 = agg_value57;
/* 664 */         if (agg_isNull52) {
/* 665 */           boolean agg_isNull54 = false;
/* 666 */           double agg_value58 = -1.0;
/* 667 */           if (!false) {
/* 668 */             agg_value58 = (double) 0;
/* 669 */           }
/* 670 */           if (!agg_isNull54) {
/* 671 */             agg_isNull52 = false;
/* 672 */             agg_value56 = agg_value58;
/* 673 */           }
/* 674 */         }
/* 675 */
/* 676 */         if (!agg_isNull44) {
/* 677 */           agg_isNull51 = false; // resultCode could change nullability.
/* 678 */           agg_value55 = agg_value56 + agg_value48;
/* 679 */
/* 680 */         }
/* 681 */         boolean agg_isNull50 = agg_isNull51;
/* 682 */         double agg_value54 = agg_value55;
/* 683 */         if (agg_isNull50) {
/* 684 */           boolean agg_isNull57 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 685 */           double agg_value61 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 686 */           if (!agg_isNull57) {
/* 687 */             agg_isNull50 = false;
/* 688 */             agg_value54 = agg_value61;
/* 689 */           }
/* 690 */         }
/* 691 */         boolean agg_isNull59 = true;
/* 692 */         double agg_value63 = -1.0;
/* 693 */
/* 694 */         boolean agg_isNull61 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 695 */         double agg_value65 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 696 */         boolean agg_isNull60 = agg_isNull61;
/* 697 */         double agg_value64 = agg_value65;
/* 698 */         if (agg_isNull60) {
/* 699 */           boolean agg_isNull62 = false;
/* 700 */           double agg_value66 = -1.0;
/* 701 */           if (!false) {
/* 702 */             agg_value66 = (double) 0;
/* 703 */           }
/* 704 */           if (!agg_isNull62) {
/* 705 */             agg_isNull60 = false;
/* 706 */             agg_value64 = agg_value66;
/* 707 */           }
/* 708 */         }
/* 709 */
/* 710 */         if (!agg_isNull45) {
/* 711 */           agg_isNull59 = false; // resultCode could change nullability.
/* 712 */           agg_value63 = agg_value64 + agg_value49;
/* 713 */
/* 714 */         }
/* 715 */         boolean agg_isNull58 = agg_isNull59;
/* 716 */         double agg_value62 = agg_value63;
/* 717 */         if (agg_isNull58) {
/* 718 */           boolean agg_isNull65 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 719 */           double agg_value69 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 720 */           if (!agg_isNull65) {
/* 721 */             agg_isNull58 = false;
/* 722 */             agg_value62 = agg_value69;
/* 723 */           }
/* 724 */         }
/* 725 */         // update unsafe row buffer
/* 726 */         if (!agg_isNull50) {
/* 727 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value54);
/* 728 */         } else {
/* 729 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 730 */         }
/* 731 */
/* 732 */         if (!agg_isNull58) {
/* 733 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value62);
/* 734 */         } else {
/* 735 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 736 */         }
/* 737 */
/* 738 */       }
/* 739 */
/* 740 */       if (shouldStop()) return;
/* 741 */     }
/* 742 */     agg_fastHashMap1.close();
/* 743 */
/* 744 */     while (agg_mapIter1.next()) {
/* 745 */       agg_numOutputRows.add(1);
/* 746 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter1.getKey();
/* 747 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter1.getValue();
/* 748 */
/* 749 */       UnsafeRow agg_resultRow = agg_unsafeRowJoiner.join(agg_aggKey, agg_aggBuffer);
/* 750 */
/* 751 */       boolean agg_isNull43 = agg_resultRow.isNullAt(0);
/* 752 */       int agg_value47 = agg_isNull43 ? -1 : (agg_resultRow.getInt(0));
/* 753 */       boolean agg_isNull44 = agg_resultRow.isNullAt(1);
/* 754 */       double agg_value48 = agg_isNull44 ? -1.0 : (agg_resultRow.getDouble(1));
/* 755 */       boolean agg_isNull45 = agg_resultRow.isNullAt(2);
/* 756 */       double agg_value49 = agg_isNull45 ? -1.0 : (agg_resultRow.getDouble(2));
/* 757 */
/* 758 */       UnsafeRow agg_unsafeRowAggBuffer1 = null;
/* 759 */
/* 760 */       UnsafeRow agg_fastAggBuffer1 = null;
/* 761 */
/* 762 */       if (true) {
/* 763 */         if (!agg_isNull43) {
/* 764 */           agg_fastAggBuffer1 = agg_fastHashMap.findOrInsert(
/* 765 */             agg_value47);
/* 766 */         }
/* 767 */       }
/* 768 */
/* 769 */       if (agg_fastAggBuffer1 == null) {
/* 770 */         // generate grouping key
/* 771 */         agg_rowWriter1.zeroOutNullBytes();
/* 772 */
/* 773 */         if (agg_isNull43) {
/* 774 */           agg_rowWriter1.setNullAt(0);
/* 775 */         } else {
/* 776 */           agg_rowWriter1.write(0, agg_value47);
/* 777 */         }
/* 778 */         agg_value52 = 42;
/* 779 */
/* 780 */         if (!agg_isNull43) {
/* 781 */           agg_value52 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(agg_value47, agg_value52);
/* 782 */         }
/* 783 */         if (true) {
/* 784 */           // try to get the buffer from hash map
/* 785 */           agg_unsafeRowAggBuffer1 =
/* 786 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 787 */         }
/* 788 */         if (agg_unsafeRowAggBuffer1 == null) {
/* 789 */           if (agg_sorter == null) {
/* 790 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 791 */           } else {
/* 792 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 793 */           }
/* 794 */
/* 795 */           // the hash map had be spilled, it should have enough memory now,
/* 796 */           // try  to allocate buffer again.
/* 797 */           agg_unsafeRowAggBuffer1 =
/* 798 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result3, agg_value52);
/* 799 */           if (agg_unsafeRowAggBuffer1 == null) {
/* 800 */             // failed to allocate the first page
/* 801 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 802 */           }
/* 803 */         }
/* 804 */       }
/* 805 */
/* 806 */       if (agg_fastAggBuffer1 != null) {
/* 807 */         // update fast row
/* 808 */
/* 809 */         // common sub-expressions
/* 810 */
/* 811 */         // evaluate aggregate function
/* 812 */         boolean agg_isNull67 = true;
/* 813 */         double agg_value71 = -1.0;
/* 814 */
/* 815 */         boolean agg_isNull69 = agg_fastAggBuffer1.isNullAt(0);
/* 816 */         double agg_value73 = agg_isNull69 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 817 */         boolean agg_isNull68 = agg_isNull69;
/* 818 */         double agg_value72 = agg_value73;
/* 819 */         if (agg_isNull68) {
/* 820 */           boolean agg_isNull70 = false;
/* 821 */           double agg_value74 = -1.0;
/* 822 */           if (!false) {
/* 823 */             agg_value74 = (double) 0;
/* 824 */           }
/* 825 */           if (!agg_isNull70) {
/* 826 */             agg_isNull68 = false;
/* 827 */             agg_value72 = agg_value74;
/* 828 */           }
/* 829 */         }
/* 830 */
/* 831 */         if (!agg_isNull44) {
/* 832 */           agg_isNull67 = false; // resultCode could change nullability.
/* 833 */           agg_value71 = agg_value72 + agg_value48;
/* 834 */
/* 835 */         }
/* 836 */         boolean agg_isNull66 = agg_isNull67;
/* 837 */         double agg_value70 = agg_value71;
/* 838 */         if (agg_isNull66) {
/* 839 */           boolean agg_isNull73 = agg_fastAggBuffer1.isNullAt(0);
/* 840 */           double agg_value77 = agg_isNull73 ? -1.0 : (agg_fastAggBuffer1.getDouble(0));
/* 841 */           if (!agg_isNull73) {
/* 842 */             agg_isNull66 = false;
/* 843 */             agg_value70 = agg_value77;
/* 844 */           }
/* 845 */         }
/* 846 */         boolean agg_isNull75 = true;
/* 847 */         double agg_value79 = -1.0;
/* 848 */
/* 849 */         boolean agg_isNull77 = agg_fastAggBuffer1.isNullAt(1);
/* 850 */         double agg_value81 = agg_isNull77 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 851 */         boolean agg_isNull76 = agg_isNull77;
/* 852 */         double agg_value80 = agg_value81;
/* 853 */         if (agg_isNull76) {
/* 854 */           boolean agg_isNull78 = false;
/* 855 */           double agg_value82 = -1.0;
/* 856 */           if (!false) {
/* 857 */             agg_value82 = (double) 0;
/* 858 */           }
/* 859 */           if (!agg_isNull78) {
/* 860 */             agg_isNull76 = false;
/* 861 */             agg_value80 = agg_value82;
/* 862 */           }
/* 863 */         }
/* 864 */
/* 865 */         if (!agg_isNull45) {
/* 866 */           agg_isNull75 = false; // resultCode could change nullability.
/* 867 */           agg_value79 = agg_value80 + agg_value49;
/* 868 */
/* 869 */         }
/* 870 */         boolean agg_isNull74 = agg_isNull75;
/* 871 */         double agg_value78 = agg_value79;
/* 872 */         if (agg_isNull74) {
/* 873 */           boolean agg_isNull81 = agg_fastAggBuffer1.isNullAt(1);
/* 874 */           double agg_value85 = agg_isNull81 ? -1.0 : (agg_fastAggBuffer1.getDouble(1));
/* 875 */           if (!agg_isNull81) {
/* 876 */             agg_isNull74 = false;
/* 877 */             agg_value78 = agg_value85;
/* 878 */           }
/* 879 */         }
/* 880 */         // update fast row
/* 881 */         if (!agg_isNull66) {
/* 882 */           agg_fastAggBuffer1.setDouble(0, agg_value70);
/* 883 */         } else {
/* 884 */           agg_fastAggBuffer1.setNullAt(0);
/* 885 */         }
/* 886 */
/* 887 */         if (!agg_isNull74) {
/* 888 */           agg_fastAggBuffer1.setDouble(1, agg_value78);
/* 889 */         } else {
/* 890 */           agg_fastAggBuffer1.setNullAt(1);
/* 891 */         }
/* 892 */
/* 893 */       } else {
/* 894 */         // update unsafe row
/* 895 */
/* 896 */         // common sub-expressions
/* 897 */
/* 898 */         // evaluate aggregate function
/* 899 */         boolean agg_isNull51 = true;
/* 900 */         double agg_value55 = -1.0;
/* 901 */
/* 902 */         boolean agg_isNull53 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 903 */         double agg_value57 = agg_isNull53 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 904 */         boolean agg_isNull52 = agg_isNull53;
/* 905 */         double agg_value56 = agg_value57;
/* 906 */         if (agg_isNull52) {
/* 907 */           boolean agg_isNull54 = false;
/* 908 */           double agg_value58 = -1.0;
/* 909 */           if (!false) {
/* 910 */             agg_value58 = (double) 0;
/* 911 */           }
/* 912 */           if (!agg_isNull54) {
/* 913 */             agg_isNull52 = false;
/* 914 */             agg_value56 = agg_value58;
/* 915 */           }
/* 916 */         }
/* 917 */
/* 918 */         if (!agg_isNull44) {
/* 919 */           agg_isNull51 = false; // resultCode could change nullability.
/* 920 */           agg_value55 = agg_value56 + agg_value48;
/* 921 */
/* 922 */         }
/* 923 */         boolean agg_isNull50 = agg_isNull51;
/* 924 */         double agg_value54 = agg_value55;
/* 925 */         if (agg_isNull50) {
/* 926 */           boolean agg_isNull57 = agg_unsafeRowAggBuffer1.isNullAt(0);
/* 927 */           double agg_value61 = agg_isNull57 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(0));
/* 928 */           if (!agg_isNull57) {
/* 929 */             agg_isNull50 = false;
/* 930 */             agg_value54 = agg_value61;
/* 931 */           }
/* 932 */         }
/* 933 */         boolean agg_isNull59 = true;
/* 934 */         double agg_value63 = -1.0;
/* 935 */
/* 936 */         boolean agg_isNull61 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 937 */         double agg_value65 = agg_isNull61 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 938 */         boolean agg_isNull60 = agg_isNull61;
/* 939 */         double agg_value64 = agg_value65;
/* 940 */         if (agg_isNull60) {
/* 941 */           boolean agg_isNull62 = false;
/* 942 */           double agg_value66 = -1.0;
/* 943 */           if (!false) {
/* 944 */             agg_value66 = (double) 0;
/* 945 */           }
/* 946 */           if (!agg_isNull62) {
/* 947 */             agg_isNull60 = false;
/* 948 */             agg_value64 = agg_value66;
/* 949 */           }
/* 950 */         }
/* 951 */
/* 952 */         if (!agg_isNull45) {
/* 953 */           agg_isNull59 = false; // resultCode could change nullability.
/* 954 */           agg_value63 = agg_value64 + agg_value49;
/* 955 */
/* 956 */         }
/* 957 */         boolean agg_isNull58 = agg_isNull59;
/* 958 */         double agg_value62 = agg_value63;
/* 959 */         if (agg_isNull58) {
/* 960 */           boolean agg_isNull65 = agg_unsafeRowAggBuffer1.isNullAt(1);
/* 961 */           double agg_value69 = agg_isNull65 ? -1.0 : (agg_unsafeRowAggBuffer1.getDouble(1));
/* 962 */           if (!agg_isNull65) {
/* 963 */             agg_isNull58 = false;
/* 964 */             agg_value62 = agg_value69;
/* 965 */           }
/* 966 */         }
/* 967 */         // update unsafe row buffer
/* 968 */         if (!agg_isNull50) {
/* 969 */           agg_unsafeRowAggBuffer1.setDouble(0, agg_value54);
/* 970 */         } else {
/* 971 */           agg_unsafeRowAggBuffer1.setNullAt(0);
/* 972 */         }
/* 973 */
/* 974 */         if (!agg_isNull58) {
/* 975 */           agg_unsafeRowAggBuffer1.setDouble(1, agg_value62);
/* 976 */         } else {
/* 977 */           agg_unsafeRowAggBuffer1.setNullAt(1);
/* 978 */         }
/* 979 */
/* 980 */       }
/* 981 */
/* 982 */       if (shouldStop()) return;
/* 983 */     }
/* 984 */
/* 985 */     agg_mapIter1.close();
/* 986 */     if (agg_sorter1 == null) {
/* 987 */       agg_hashMap1.free();
/* 988 */     }
/* 989 */
/* 990 */     agg_fastHashMapIter = agg_fastHashMap.rowIterator();
/* 991 */
/* 992 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 993 */   }
/* 994 */
/* 995 */   public class agg_FastHashMap1 {
/* 996 */     private org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch batch;
/* 997 */     private int[] buckets;
/* 998 */     private int capacity = 1 << 16;
/* 999 */     private double loadFactor = 0.5;
/* 1000 */     private int numBuckets = (int) (capacity / loadFactor);
/* 1001 */     private int maxSteps = 2;
/* 1002 */     private int numRows = 0;
/* 1003 */     private org.apache.spark.sql.types.StructType keySchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[9])", org.apache.spark.sql.types.DataTypes.IntegerType);
/* 1004 */     private org.apache.spark.sql.types.StructType valueSchema = new org.apache.spark.sql.types.StructType().add("((java.lang.String) references[10])", org.apache.spark.sql.types.DataTypes.DoubleType)
/* 1005 */     .add("((java.lang.String) references[11])", org.apache.spark.sql.types.DataTypes.DoubleType);
/* 1006 */     private Object emptyVBase;
/* 1007 */     private long emptyVOff;
/* 1008 */     private int emptyVLen;
/* 1009 */     private boolean isBatchFull = false;
/* 1010 */
/* 1011 */     public agg_FastHashMap1(
/* 1012 */       org.apache.spark.memory.TaskMemoryManager taskMemoryManager,
/* 1013 */       InternalRow emptyAggregationBuffer) {
/* 1014 */       batch = org.apache.spark.sql.catalyst.expressions.RowBasedKeyValueBatch
/* 1015 */       .allocate(keySchema, valueSchema, taskMemoryManager, capacity);
/* 1016 */
/* 1017 */       final UnsafeProjection valueProjection = UnsafeProjection.create(valueSchema);
/* 1018 */       final byte[] emptyBuffer = valueProjection.apply(emptyAggregationBuffer).getBytes();
/* 1019 */
/* 1020 */       emptyVBase = emptyBuffer;
/* 1021 */       emptyVOff = Platform.BYTE_ARRAY_OFFSET;
/* 1022 */       emptyVLen = emptyBuffer.length;
/* 1023 */
/* 1024 */       buckets = new int[numBuckets];
/* 1025 */       java.util.Arrays.fill(buckets, -1);
/* 1026 */     }
/* 1027 */
/* 1028 */     public org.apache.spark.sql.catalyst.expressions.UnsafeRow findOrInsert(int agg_key1) {
/* 1029 */       long h = hash(agg_key1);
/* 1030 */       int step = 0;
/* 1031 */       int idx = (int) h & (numBuckets - 1);
/* 1032 */       while (step < maxSteps) {
/* 1033 */         // Return bucket index if it's either an empty slot or already contains the key
/* 1034 */         if (buckets[idx] == -1) {
/* 1035 */           if (numRows < capacity && !isBatchFull) {
/* 1036 */             // creating the unsafe for new entry
/* 1037 */             UnsafeRow agg_result = new UnsafeRow(1);
/* 1038 */             org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder
/* 1039 */             = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result,
/* 1040 */               0);
/* 1041 */             org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter
/* 1042 */             = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(
/* 1043 */               agg_holder,
/* 1044 */               1);
/* 1045 */             agg_holder.reset(); //TODO: investigate if reset or zeroout are actually needed
/* 1046 */             agg_rowWriter.zeroOutNullBytes();
/* 1047 */             agg_rowWriter.write(0, agg_key1);
/* 1048 */             agg_result.setTotalSize(agg_holder.totalSize());
/* 1049 */             Object kbase = agg_result.getBaseObject();
/* 1050 */             long koff = agg_result.getBaseOffset();
/* 1051 */             int klen = agg_result.getSizeInBytes();
/* 1052 */
/* 1053 */             UnsafeRow vRow
/* 1054 */             = batch.appendRow(kbase, koff, klen, emptyVBase, emptyVOff, emptyVLen);
/* 1055 */             if (vRow == null) {
/* 1056 */               isBatchFull = true;
/* 1057 */             } else {
/* 1058 */               buckets[idx] = numRows++;
/* 1059 */             }
/* 1060 */             return vRow;
/* 1061 */           } else {
/* 1062 */             // No more space
/* 1063 */             return null;
/* 1064 */           }
/* 1065 */         } else if (equals(idx, agg_key1)) {
/* 1066 */           return batch.getValueRow(buckets[idx]);
/* 1067 */         }
/* 1068 */         idx = (idx + 1) & (numBuckets - 1);
/* 1069 */         step++;
/* 1070 */       }
/* 1071 */       // Didn't find it
/* 1072 */       return null;
/* 1073 */     }
/* 1074 */
/* 1075 */     private boolean equals(int idx, int agg_key1) {
/* 1076 */       UnsafeRow row = batch.getKeyRow(buckets[idx]);
/* 1077 */       return (row.getInt(0) == agg_key1);
/* 1078 */     }
/* 1079 */
/* 1080 */     private long hash(int agg_key1) {
/* 1081 */       long agg_hash1 = 0;
/* 1082 */
/* 1083 */       int agg_result1 = agg_key1;
/* 1084 */       agg_hash1 = (agg_hash1 ^ (0x9e3779b9)) + agg_result1 + (agg_hash1 << 6) + (agg_hash1 >>> 2);
/* 1085 */
/* 1086 */       return agg_hash1;
/* 1087 */     }
/* 1088 */
/* 1089 */     public org.apache.spark.unsafe.KVIterator<UnsafeRow, UnsafeRow> rowIterator() {
/* 1090 */       return batch.rowIterator();
/* 1091 */     }
/* 1092 */
/* 1093 */     public void close() {
/* 1094 */       batch.close();
/* 1095 */     }
/* 1096 */
/* 1097 */   }
/* 1098 */
/* 1099 */   private void agg_doAggregateWithKeys1() throws java.io.IOException {
/* 1100 */     agg_hashMap1 = agg_plan1.createHashMap();
/* 1101 */
/* 1102 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 1103 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 1104 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 1105 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 1106 */
/* 1107 */       // generate join key for stream side
/* 1108 */
/* 1109 */       boolean bhj_isNull = inputadapter_isNull1;
/* 1110 */       long bhj_value = -1L;
/* 1111 */       if (!inputadapter_isNull1) {
/* 1112 */         bhj_value = (long) inputadapter_value1;
/* 1113 */       }
/* 1114 */       // find matches from HashedRelation
/* 1115 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 1116 */       if (bhj_matched == null) continue;
/* 1117 */
/* 1118 */       bhj_numOutputRows.add(1);
/* 1119 */
/* 1120 */       boolean inputadapter_isNull9 = inputadapter_row.isNullAt(9);
/* 1121 */       int inputadapter_value9 = inputadapter_isNull9 ? -1 : (inputadapter_row.getInt(9));
/* 1122 */
/* 1123 */       // generate join key for stream side
/* 1124 */
/* 1125 */       boolean bhj_isNull10 = inputadapter_isNull9;
/* 1126 */       long bhj_value10 = -1L;
/* 1127 */       if (!inputadapter_isNull9) {
/* 1128 */         bhj_value10 = (long) inputadapter_value9;
/* 1129 */       }
/* 1130 */       // find matches from HashedRelation
/* 1131 */       UnsafeRow bhj_matched1 = bhj_isNull10 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value10);
/* 1132 */       if (bhj_matched1 == null) continue;
/* 1133 */
/* 1134 */       bhj_numOutputRows1.add(1);
/* 1135 */
/* 1136 */       boolean inputadapter_isNull10 = inputadapter_row.isNullAt(10);
/* 1137 */       int inputadapter_value10 = inputadapter_isNull10 ? -1 : (inputadapter_row.getInt(10));
/* 1138 */
/* 1139 */       // generate join key for stream side
/* 1140 */
/* 1141 */       boolean bhj_isNull19 = inputadapter_isNull10;
/* 1142 */       long bhj_value19 = -1L;
/* 1143 */       if (!inputadapter_isNull10) {
/* 1144 */         bhj_value19 = (long) inputadapter_value10;
/* 1145 */       }
/* 1146 */       // find matches from HashedRelation
/* 1147 */       UnsafeRow bhj_matched2 = bhj_isNull19 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value19);
/* 1148 */       if (bhj_matched2 == null) continue;
/* 1149 */
/* 1150 */       bhj_numOutputRows2.add(1);
/* 1151 */
/* 1152 */       boolean inputadapter_isNull16 = inputadapter_row.isNullAt(16);
/* 1153 */       int inputadapter_value16 = inputadapter_isNull16 ? -1 : (inputadapter_row.getInt(16));
/* 1154 */       boolean inputadapter_isNull27 = inputadapter_row.isNullAt(27);
/* 1155 */       double inputadapter_value27 = inputadapter_isNull27 ? -1.0 : (inputadapter_row.getDouble(27));
/* 1156 */       boolean inputadapter_isNull32 = inputadapter_row.isNullAt(32);
/* 1157 */       double inputadapter_value32 = inputadapter_isNull32 ? -1.0 : (inputadapter_row.getDouble(32));
/* 1158 */
/* 1159 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 1160 */
/* 1161 */       UnsafeRow agg_fastAggBuffer = null;
/* 1162 */
/* 1163 */       if (true) {
/* 1164 */         if (!inputadapter_isNull16) {
/* 1165 */           agg_fastAggBuffer = agg_fastHashMap1.findOrInsert(
/* 1166 */             inputadapter_value16);
/* 1167 */         }
/* 1168 */       }
/* 1169 */
/* 1170 */       if (agg_fastAggBuffer == null) {
/* 1171 */         // generate grouping key
/* 1172 */         agg_rowWriter.zeroOutNullBytes();
/* 1173 */
/* 1174 */         if (inputadapter_isNull16) {
/* 1175 */           agg_rowWriter.setNullAt(0);
/* 1176 */         } else {
/* 1177 */           agg_rowWriter.write(0, inputadapter_value16);
/* 1178 */         }
/* 1179 */         agg_value13 = 42;
/* 1180 */
/* 1181 */         if (!inputadapter_isNull16) {
/* 1182 */           agg_value13 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value16, agg_value13);
/* 1183 */         }
/* 1184 */         if (true) {
/* 1185 */           // try to get the buffer from hash map
/* 1186 */           agg_unsafeRowAggBuffer =
/* 1187 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result2, agg_value13);
/* 1188 */         }
/* 1189 */         if (agg_unsafeRowAggBuffer == null) {
/* 1190 */           if (agg_sorter1 == null) {
/* 1191 */             agg_sorter1 = agg_hashMap1.destructAndCreateExternalSorter();
/* 1192 */           } else {
/* 1193 */             agg_sorter1.merge(agg_hashMap1.destructAndCreateExternalSorter());
/* 1194 */           }
/* 1195 */
/* 1196 */           // the hash map had be spilled, it should have enough memory now,
/* 1197 */           // try  to allocate buffer again.
/* 1198 */           agg_unsafeRowAggBuffer =
/* 1199 */           agg_hashMap1.getAggregationBufferFromUnsafeRow(agg_result2, agg_value13);
/* 1200 */           if (agg_unsafeRowAggBuffer == null) {
/* 1201 */             // failed to allocate the first page
/* 1202 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 1203 */           }
/* 1204 */         }
/* 1205 */       }
/* 1206 */
/* 1207 */       if (agg_fastAggBuffer != null) {
/* 1208 */         // update fast row
/* 1209 */
/* 1210 */         // common sub-expressions
/* 1211 */
/* 1212 */         // evaluate aggregate function
/* 1213 */         boolean agg_isNull28 = true;
/* 1214 */         double agg_value32 = -1.0;
/* 1215 */
/* 1216 */         boolean agg_isNull30 = agg_fastAggBuffer.isNullAt(0);
/* 1217 */         double agg_value34 = agg_isNull30 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 1218 */         boolean agg_isNull29 = agg_isNull30;
/* 1219 */         double agg_value33 = agg_value34;
/* 1220 */         if (agg_isNull29) {
/* 1221 */           boolean agg_isNull31 = false;
/* 1222 */           double agg_value35 = -1.0;
/* 1223 */           if (!false) {
/* 1224 */             agg_value35 = (double) 0;
/* 1225 */           }
/* 1226 */           if (!agg_isNull31) {
/* 1227 */             agg_isNull29 = false;
/* 1228 */             agg_value33 = agg_value35;
/* 1229 */           }
/* 1230 */         }
/* 1231 */
/* 1232 */         if (!inputadapter_isNull27) {
/* 1233 */           agg_isNull28 = false; // resultCode could change nullability.
/* 1234 */           agg_value32 = agg_value33 + inputadapter_value27;
/* 1235 */
/* 1236 */         }
/* 1237 */         boolean agg_isNull27 = agg_isNull28;
/* 1238 */         double agg_value31 = agg_value32;
/* 1239 */         if (agg_isNull27) {
/* 1240 */           boolean agg_isNull34 = agg_fastAggBuffer.isNullAt(0);
/* 1241 */           double agg_value38 = agg_isNull34 ? -1.0 : (agg_fastAggBuffer.getDouble(0));
/* 1242 */           if (!agg_isNull34) {
/* 1243 */             agg_isNull27 = false;
/* 1244 */             agg_value31 = agg_value38;
/* 1245 */           }
/* 1246 */         }
/* 1247 */         boolean agg_isNull36 = true;
/* 1248 */         double agg_value40 = -1.0;
/* 1249 */
/* 1250 */         boolean agg_isNull38 = agg_fastAggBuffer.isNullAt(1);
/* 1251 */         double agg_value42 = agg_isNull38 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1252 */         boolean agg_isNull37 = agg_isNull38;
/* 1253 */         double agg_value41 = agg_value42;
/* 1254 */         if (agg_isNull37) {
/* 1255 */           boolean agg_isNull39 = false;
/* 1256 */           double agg_value43 = -1.0;
/* 1257 */           if (!false) {
/* 1258 */             agg_value43 = (double) 0;
/* 1259 */           }
/* 1260 */           if (!agg_isNull39) {
/* 1261 */             agg_isNull37 = false;
/* 1262 */             agg_value41 = agg_value43;
/* 1263 */           }
/* 1264 */         }
/* 1265 */
/* 1266 */         if (!inputadapter_isNull32) {
/* 1267 */           agg_isNull36 = false; // resultCode could change nullability.
/* 1268 */           agg_value40 = agg_value41 + inputadapter_value32;
/* 1269 */
/* 1270 */         }
/* 1271 */         boolean agg_isNull35 = agg_isNull36;
/* 1272 */         double agg_value39 = agg_value40;
/* 1273 */         if (agg_isNull35) {
/* 1274 */           boolean agg_isNull42 = agg_fastAggBuffer.isNullAt(1);
/* 1275 */           double agg_value46 = agg_isNull42 ? -1.0 : (agg_fastAggBuffer.getDouble(1));
/* 1276 */           if (!agg_isNull42) {
/* 1277 */             agg_isNull35 = false;
/* 1278 */             agg_value39 = agg_value46;
/* 1279 */           }
/* 1280 */         }
/* 1281 */         // update fast row
/* 1282 */         if (!agg_isNull27) {
/* 1283 */           agg_fastAggBuffer.setDouble(0, agg_value31);
/* 1284 */         } else {
/* 1285 */           agg_fastAggBuffer.setNullAt(0);
/* 1286 */         }
/* 1287 */
/* 1288 */         if (!agg_isNull35) {
/* 1289 */           agg_fastAggBuffer.setDouble(1, agg_value39);
/* 1290 */         } else {
/* 1291 */           agg_fastAggBuffer.setNullAt(1);
/* 1292 */         }
/* 1293 */
/* 1294 */       } else {
/* 1295 */         // update unsafe row
/* 1296 */
/* 1297 */         // common sub-expressions
/* 1298 */
/* 1299 */         // evaluate aggregate function
/* 1300 */         boolean agg_isNull12 = true;
/* 1301 */         double agg_value16 = -1.0;
/* 1302 */
/* 1303 */         boolean agg_isNull14 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 1304 */         double agg_value18 = agg_isNull14 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 1305 */         boolean agg_isNull13 = agg_isNull14;
/* 1306 */         double agg_value17 = agg_value18;
/* 1307 */         if (agg_isNull13) {
/* 1308 */           boolean agg_isNull15 = false;
/* 1309 */           double agg_value19 = -1.0;
/* 1310 */           if (!false) {
/* 1311 */             agg_value19 = (double) 0;
/* 1312 */           }
/* 1313 */           if (!agg_isNull15) {
/* 1314 */             agg_isNull13 = false;
/* 1315 */             agg_value17 = agg_value19;
/* 1316 */           }
/* 1317 */         }
/* 1318 */
/* 1319 */         if (!inputadapter_isNull27) {
/* 1320 */           agg_isNull12 = false; // resultCode could change nullability.
/* 1321 */           agg_value16 = agg_value17 + inputadapter_value27;
/* 1322 */
/* 1323 */         }
/* 1324 */         boolean agg_isNull11 = agg_isNull12;
/* 1325 */         double agg_value15 = agg_value16;
/* 1326 */         if (agg_isNull11) {
/* 1327 */           boolean agg_isNull18 = agg_unsafeRowAggBuffer.isNullAt(0);
/* 1328 */           double agg_value22 = agg_isNull18 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(0));
/* 1329 */           if (!agg_isNull18) {
/* 1330 */             agg_isNull11 = false;
/* 1331 */             agg_value15 = agg_value22;
/* 1332 */           }
/* 1333 */         }
/* 1334 */         boolean agg_isNull20 = true;
/* 1335 */         double agg_value24 = -1.0;
/* 1336 */
/* 1337 */         boolean agg_isNull22 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1338 */         double agg_value26 = agg_isNull22 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1339 */         boolean agg_isNull21 = agg_isNull22;
/* 1340 */         double agg_value25 = agg_value26;
/* 1341 */         if (agg_isNull21) {
/* 1342 */           boolean agg_isNull23 = false;
/* 1343 */           double agg_value27 = -1.0;
/* 1344 */           if (!false) {
/* 1345 */             agg_value27 = (double) 0;
/* 1346 */           }
/* 1347 */           if (!agg_isNull23) {
/* 1348 */             agg_isNull21 = false;
/* 1349 */             agg_value25 = agg_value27;
/* 1350 */           }
/* 1351 */         }
/* 1352 */
/* 1353 */         if (!inputadapter_isNull32) {
/* 1354 */           agg_isNull20 = false; // resultCode could change nullability.
/* 1355 */           agg_value24 = agg_value25 + inputadapter_value32;
/* 1356 */
/* 1357 */         }
/* 1358 */         boolean agg_isNull19 = agg_isNull20;
/* 1359 */         double agg_value23 = agg_value24;
/* 1360 */         if (agg_isNull19) {
/* 1361 */           boolean agg_isNull26 = agg_unsafeRowAggBuffer.isNullAt(1);
/* 1362 */           double agg_value30 = agg_isNull26 ? -1.0 : (agg_unsafeRowAggBuffer.getDouble(1));
/* 1363 */           if (!agg_isNull26) {
/* 1364 */             agg_isNull19 = false;
/* 1365 */             agg_value23 = agg_value30;
/* 1366 */           }
/* 1367 */         }
/* 1368 */         // update unsafe row buffer
/* 1369 */         if (!agg_isNull11) {
/* 1370 */           agg_unsafeRowAggBuffer.setDouble(0, agg_value15);
/* 1371 */         } else {
/* 1372 */           agg_unsafeRowAggBuffer.setNullAt(0);
/* 1373 */         }
/* 1374 */
/* 1375 */         if (!agg_isNull19) {
/* 1376 */           agg_unsafeRowAggBuffer.setDouble(1, agg_value23);
/* 1377 */         } else {
/* 1378 */           agg_unsafeRowAggBuffer.setNullAt(1);
/* 1379 */         }
/* 1380 */
/* 1381 */       }
/* 1382 */       if (shouldStop()) return;
/* 1383 */     }
/* 1384 */
/* 1385 */     agg_fastHashMapIter1 = agg_fastHashMap1.rowIterator();
/* 1386 */
/* 1387 */     agg_mapIter1 = agg_plan1.finishAggregate(agg_hashMap1, agg_sorter1, agg_peakMemory1, agg_spillSize1);
/* 1388 */   }
/* 1389 */
/* 1390 */   private void wholestagecodegen_init_2() {
/* 1391 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[15];
/* 1392 */     bhj_result1 = new UnsafeRow(6);
/* 1393 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 1394 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 6);
/* 1395 */     project_result2 = new UnsafeRow(4);
/* 1396 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 1397 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 4);
/* 1398 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[16];
/* 1399 */
/* 1400 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 1401 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 1402 */
/* 1403 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[17];
/* 1404 */     bhj_result2 = new UnsafeRow(5);
/* 1405 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 1406 */
/* 1407 */   }
/* 1408 */
/* 1409 */   private void wholestagecodegen_init_1() {
/* 1410 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[12];
/* 1411 */
/* 1412 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 1413 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 1414 */
/* 1415 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[13];
/* 1416 */     bhj_result = new UnsafeRow(7);
/* 1417 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 1418 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 7);
/* 1419 */     project_result1 = new UnsafeRow(5);
/* 1420 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 1421 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 5);
/* 1422 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[14];
/* 1423 */
/* 1424 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 1425 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 1426 */
/* 1427 */   }
/* 1428 */
/* 1429 */   private void wholestagecodegen_init_4() {
/* 1430 */     agg_unsafeRowJoiner1 = agg_plan.createUnsafeJoiner();
/* 1431 */     this.agg_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[20];
/* 1432 */     this.agg_aggTime1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[21];
/* 1433 */     this.agg_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[22];
/* 1434 */     this.agg_aggTime2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[23];
/* 1435 */     agg_result4 = new UnsafeRow(3);
/* 1436 */     this.agg_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result4, 0);
/* 1437 */     this.agg_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder2, 3);
/* 1438 */
/* 1439 */   }
/* 1440 */
/* 1441 */   protected void processNext() throws java.io.IOException {
/* 1442 */     while (!agg_initAgg) {
/* 1443 */       agg_initAgg = true;
/* 1444 */       long agg_beforeAgg2 = System.nanoTime();
/* 1445 */       agg_doAggregateWithoutKey();
/* 1446 */       agg_aggTime2.add((System.nanoTime() - agg_beforeAgg2) / 1000000);
/* 1447 */
/* 1448 */       // output the result
/* 1449 */
/* 1450 */       agg_numOutputRows2.add(1);
/* 1451 */       agg_rowWriter2.zeroOutNullBytes();
/* 1452 */
/* 1453 */       if (agg_bufIsNull) {
/* 1454 */         agg_rowWriter2.setNullAt(0);
/* 1455 */       } else {
/* 1456 */         agg_rowWriter2.write(0, agg_bufValue);
/* 1457 */       }
/* 1458 */
/* 1459 */       if (agg_bufIsNull1) {
/* 1460 */         agg_rowWriter2.setNullAt(1);
/* 1461 */       } else {
/* 1462 */         agg_rowWriter2.write(1, agg_bufValue1);
/* 1463 */       }
/* 1464 */
/* 1465 */       if (agg_bufIsNull2) {
/* 1466 */         agg_rowWriter2.setNullAt(2);
/* 1467 */       } else {
/* 1468 */         agg_rowWriter2.write(2, agg_bufValue2);
/* 1469 */       }
/* 1470 */       append(agg_result4);
/* 1471 */     }
/* 1472 */   }
/* 1473 */ }
