/* 001 */ public Object generate(Object[] references) {
/* 002 */   return new GeneratedIterator(references);
/* 003 */ }
/* 004 */
/* 005 */ final class GeneratedIterator extends org.apache.spark.sql.execution.BufferedRowIterator {
/* 006 */   private Object[] references;
/* 007 */   private scala.collection.Iterator[] inputs;
/* 008 */   private boolean agg_initAgg;
/* 009 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 010 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 011 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 012 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 013 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 014 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 015 */   private scala.collection.Iterator inputadapter_input;
/* 016 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 017 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 019 */   private UnsafeRow bhj_result;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 022 */   private UnsafeRow project_result;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 025 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast1;
/* 026 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows1;
/* 028 */   private UnsafeRow bhj_result1;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 031 */   private UnsafeRow project_result1;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder1;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter1;
/* 034 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast2;
/* 035 */   private org.apache.spark.sql.execution.joins.LongHashedRelation bhj_relation2;
/* 036 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows2;
/* 037 */   private UnsafeRow bhj_result2;
/* 038 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder2;
/* 039 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter2;
/* 040 */   private UnsafeRow project_result2;
/* 041 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder2;
/* 042 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter2;
/* 043 */   private UnsafeRow agg_result;
/* 044 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 045 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 046 */   private int agg_value4;
/* 047 */   private UnsafeRow agg_result1;
/* 048 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 049 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 050 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 051 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 052 */
/* 053 */   public GeneratedIterator(Object[] references) {
/* 054 */     this.references = references;
/* 055 */   }
/* 056 */
/* 057 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 058 */     partitionIndex = index;
/* 059 */     this.inputs = inputs;
/* 060 */     wholestagecodegen_init_0();
/* 061 */     wholestagecodegen_init_1();
/* 062 */     wholestagecodegen_init_2();
/* 063 */     wholestagecodegen_init_3();
/* 064 */
/* 065 */   }
/* 066 */
/* 067 */   private void wholestagecodegen_init_0() {
/* 068 */     agg_initAgg = false;
/* 069 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 070 */
/* 071 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 072 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 073 */     inputadapter_input = inputs[0];
/* 074 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 075 */
/* 076 */     bhj_relation = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 077 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 078 */
/* 079 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 080 */     bhj_result = new UnsafeRow(4);
/* 081 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 082 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 4);
/* 083 */     project_result = new UnsafeRow(2);
/* 084 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 085 */
/* 086 */   }
/* 087 */
/* 088 */   private void wholestagecodegen_init_3() {
/* 089 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 090 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 2);
/* 091 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[9];
/* 092 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[10];
/* 093 */
/* 094 */   }
/* 095 */
/* 096 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 097 */     agg_hashMap = agg_plan.createHashMap();
/* 098 */
/* 099 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 100 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 101 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 102 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 103 */
/* 104 */       // generate join key for stream side
/* 105 */
/* 106 */       boolean bhj_isNull = inputadapter_isNull2;
/* 107 */       long bhj_value = -1L;
/* 108 */       if (!inputadapter_isNull2) {
/* 109 */         bhj_value = (long) inputadapter_value2;
/* 110 */       }
/* 111 */       // find matches from HashedRelation
/* 112 */       UnsafeRow bhj_matched = bhj_isNull ? null: (UnsafeRow)bhj_relation.getValue(bhj_value);
/* 113 */       if (bhj_matched == null) continue;
/* 114 */
/* 115 */       bhj_numOutputRows.add(1);
/* 116 */
/* 117 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 118 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 119 */
/* 120 */       // generate join key for stream side
/* 121 */
/* 122 */       boolean bhj_isNull7 = inputadapter_isNull;
/* 123 */       long bhj_value7 = -1L;
/* 124 */       if (!inputadapter_isNull) {
/* 125 */         bhj_value7 = (long) inputadapter_value;
/* 126 */       }
/* 127 */       // find matches from HashedRelation
/* 128 */       UnsafeRow bhj_matched1 = bhj_isNull7 ? null: (UnsafeRow)bhj_relation1.getValue(bhj_value7);
/* 129 */       if (bhj_matched1 == null) continue;
/* 130 */
/* 131 */       bhj_numOutputRows1.add(1);
/* 132 */
/* 133 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 134 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 135 */
/* 136 */       // generate join key for stream side
/* 137 */
/* 138 */       boolean bhj_isNull13 = inputadapter_isNull1;
/* 139 */       long bhj_value13 = -1L;
/* 140 */       if (!inputadapter_isNull1) {
/* 141 */         bhj_value13 = (long) inputadapter_value1;
/* 142 */       }
/* 143 */       // find matches from HashedRelation
/* 144 */       UnsafeRow bhj_matched2 = bhj_isNull13 ? null: (UnsafeRow)bhj_relation2.getValue(bhj_value13);
/* 145 */       if (bhj_matched2 == null) continue;
/* 146 */
/* 147 */       bhj_numOutputRows2.add(1);
/* 148 */
/* 149 */       boolean bhj_isNull15 = bhj_matched2.isNullAt(0);
/* 150 */       int bhj_value15 = bhj_isNull15 ? -1 : (bhj_matched2.getInt(0));
/* 151 */       boolean bhj_isNull16 = bhj_matched2.isNullAt(1);
/* 152 */       int bhj_value16 = bhj_isNull16 ? -1 : (bhj_matched2.getInt(1));
/* 153 */
/* 154 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 155 */
/* 156 */       UnsafeRow agg_fastAggBuffer = null;
/* 157 */
/* 158 */       if (agg_fastAggBuffer == null) {
/* 159 */         // generate grouping key
/* 160 */         agg_rowWriter.zeroOutNullBytes();
/* 161 */
/* 162 */         if (bhj_isNull15) {
/* 163 */           agg_rowWriter.setNullAt(0);
/* 164 */         } else {
/* 165 */           agg_rowWriter.write(0, bhj_value15);
/* 166 */         }
/* 167 */
/* 168 */         if (bhj_isNull16) {
/* 169 */           agg_rowWriter.setNullAt(1);
/* 170 */         } else {
/* 171 */           agg_rowWriter.write(1, bhj_value16);
/* 172 */         }
/* 173 */         agg_value4 = 42;
/* 174 */
/* 175 */         if (!bhj_isNull15) {
/* 176 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value15, agg_value4);
/* 177 */         }
/* 178 */
/* 179 */         if (!bhj_isNull16) {
/* 180 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(bhj_value16, agg_value4);
/* 181 */         }
/* 182 */         if (true) {
/* 183 */           // try to get the buffer from hash map
/* 184 */           agg_unsafeRowAggBuffer =
/* 185 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 186 */         }
/* 187 */         if (agg_unsafeRowAggBuffer == null) {
/* 188 */           if (agg_sorter == null) {
/* 189 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 190 */           } else {
/* 191 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 192 */           }
/* 193 */
/* 194 */           // the hash map had be spilled, it should have enough memory now,
/* 195 */           // try  to allocate buffer again.
/* 196 */           agg_unsafeRowAggBuffer =
/* 197 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 198 */           if (agg_unsafeRowAggBuffer == null) {
/* 199 */             // failed to allocate the first page
/* 200 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 201 */           }
/* 202 */         }
/* 203 */       }
/* 204 */
/* 205 */       if (agg_fastAggBuffer != null) {
/* 206 */         // update fast row
/* 207 */
/* 208 */       } else {
/* 209 */         // update unsafe row
/* 210 */
/* 211 */         // common sub-expressions
/* 212 */
/* 213 */         // evaluate aggregate function
/* 214 */
/* 215 */         // update unsafe row buffer
/* 216 */
/* 217 */       }
/* 218 */       if (shouldStop()) return;
/* 219 */     }
/* 220 */
/* 221 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 222 */   }
/* 223 */
/* 224 */   private void wholestagecodegen_init_2() {
/* 225 */     bhj_relation2 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast2.value()).asReadOnlyCopy();
/* 226 */     incPeakExecutionMemory(bhj_relation2.estimatedSize());
/* 227 */
/* 228 */     this.bhj_numOutputRows2 = (org.apache.spark.sql.execution.metric.SQLMetric) references[8];
/* 229 */     bhj_result2 = new UnsafeRow(3);
/* 230 */     this.bhj_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result2, 0);
/* 231 */     this.bhj_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder2, 3);
/* 232 */     project_result2 = new UnsafeRow(2);
/* 233 */     this.project_holder2 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result2, 0);
/* 234 */     this.project_rowWriter2 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder2, 2);
/* 235 */     agg_result = new UnsafeRow(2);
/* 236 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 237 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 238 */
/* 239 */     agg_result1 = new UnsafeRow(2);
/* 240 */
/* 241 */   }
/* 242 */
/* 243 */   private void wholestagecodegen_init_1() {
/* 244 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 245 */     this.bhj_broadcast1 = (org.apache.spark.broadcast.TorrentBroadcast) references[5];
/* 246 */
/* 247 */     bhj_relation1 = ((org.apache.spark.sql.execution.joins.LongHashedRelation) bhj_broadcast1.value()).asReadOnlyCopy();
/* 248 */     incPeakExecutionMemory(bhj_relation1.estimatedSize());
/* 249 */
/* 250 */     this.bhj_numOutputRows1 = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 251 */     bhj_result1 = new UnsafeRow(3);
/* 252 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 253 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 3);
/* 254 */     project_result1 = new UnsafeRow(1);
/* 255 */     this.project_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result1, 0);
/* 256 */     this.project_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder1, 1);
/* 257 */     this.bhj_broadcast2 = (org.apache.spark.broadcast.TorrentBroadcast) references[7];
/* 258 */
/* 259 */   }
/* 260 */
/* 261 */   protected void processNext() throws java.io.IOException {
/* 262 */     if (!agg_initAgg) {
/* 263 */       agg_initAgg = true;
/* 264 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 265 */       agg_doAggregateWithKeys();
/* 266 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 267 */     }
/* 268 */
/* 269 */     // output the result
/* 270 */
/* 271 */     while (agg_mapIter.next()) {
/* 272 */       wholestagecodegen_numOutputRows.add(1);
/* 273 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 274 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 275 */
/* 276 */       boolean agg_isNull7 = agg_aggKey.isNullAt(0);
/* 277 */       int agg_value7 = agg_isNull7 ? -1 : (agg_aggKey.getInt(0));
/* 278 */       boolean agg_isNull8 = agg_aggKey.isNullAt(1);
/* 279 */       int agg_value8 = agg_isNull8 ? -1 : (agg_aggKey.getInt(1));
/* 280 */       agg_rowWriter1.zeroOutNullBytes();
/* 281 */
/* 282 */       if (agg_isNull7) {
/* 283 */         agg_rowWriter1.setNullAt(0);
/* 284 */       } else {
/* 285 */         agg_rowWriter1.write(0, agg_value7);
/* 286 */       }
/* 287 */
/* 288 */       if (agg_isNull8) {
/* 289 */         agg_rowWriter1.setNullAt(1);
/* 290 */       } else {
/* 291 */         agg_rowWriter1.write(1, agg_value8);
/* 292 */       }
/* 293 */       append(agg_result1);
/* 294 */
/* 295 */       if (shouldStop()) return;
/* 296 */     }
/* 297 */
/* 298 */     agg_mapIter.close();
/* 299 */     if (agg_sorter == null) {
/* 300 */       agg_hashMap.free();
/* 301 */     }
/* 302 */   }
/* 303 */ }
