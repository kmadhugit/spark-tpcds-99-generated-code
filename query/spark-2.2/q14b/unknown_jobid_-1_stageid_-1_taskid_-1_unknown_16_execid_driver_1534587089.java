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
/* 016 */   private UnsafeRow agg_result;
/* 017 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 018 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 019 */   private int agg_value6;
/* 020 */   private UnsafeRow agg_result1;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 023 */   private org.apache.spark.broadcast.TorrentBroadcast bhj_broadcast;
/* 024 */   private org.apache.spark.sql.execution.joins.UnsafeHashedRelation bhj_relation;
/* 025 */   private UnsafeRow bhj_result;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter;
/* 028 */   private org.apache.spark.sql.execution.metric.SQLMetric bhj_numOutputRows;
/* 029 */   private UnsafeRow bhj_result1;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder bhj_holder1;
/* 031 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter bhj_rowWriter1;
/* 032 */   private UnsafeRow project_result;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 034 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
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
/* 045 */     wholestagecodegen_init_0();
/* 046 */     wholestagecodegen_init_1();
/* 047 */
/* 048 */   }
/* 049 */
/* 050 */   private void wholestagecodegen_init_0() {
/* 051 */     agg_initAgg = false;
/* 052 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 053 */
/* 054 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 055 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     inputadapter_input = inputs[0];
/* 057 */     agg_result = new UnsafeRow(3);
/* 058 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 059 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 3);
/* 060 */
/* 061 */     agg_result1 = new UnsafeRow(3);
/* 062 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 063 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 064 */     this.bhj_broadcast = (org.apache.spark.broadcast.TorrentBroadcast) references[3];
/* 065 */
/* 066 */     bhj_relation = ((org.apache.spark.sql.execution.joins.UnsafeHashedRelation) bhj_broadcast.value()).asReadOnlyCopy();
/* 067 */     incPeakExecutionMemory(bhj_relation.estimatedSize());
/* 068 */
/* 069 */   }
/* 070 */
/* 071 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 072 */     agg_hashMap = agg_plan.createHashMap();
/* 073 */
/* 074 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 075 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 076 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 077 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 078 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 079 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 080 */       boolean inputadapter_isNull2 = inputadapter_row.isNullAt(2);
/* 081 */       int inputadapter_value2 = inputadapter_isNull2 ? -1 : (inputadapter_row.getInt(2));
/* 082 */
/* 083 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 084 */
/* 085 */       UnsafeRow agg_fastAggBuffer = null;
/* 086 */
/* 087 */       if (agg_fastAggBuffer == null) {
/* 088 */         // generate grouping key
/* 089 */         agg_rowWriter.zeroOutNullBytes();
/* 090 */
/* 091 */         if (inputadapter_isNull) {
/* 092 */           agg_rowWriter.setNullAt(0);
/* 093 */         } else {
/* 094 */           agg_rowWriter.write(0, inputadapter_value);
/* 095 */         }
/* 096 */
/* 097 */         if (inputadapter_isNull1) {
/* 098 */           agg_rowWriter.setNullAt(1);
/* 099 */         } else {
/* 100 */           agg_rowWriter.write(1, inputadapter_value1);
/* 101 */         }
/* 102 */
/* 103 */         if (inputadapter_isNull2) {
/* 104 */           agg_rowWriter.setNullAt(2);
/* 105 */         } else {
/* 106 */           agg_rowWriter.write(2, inputadapter_value2);
/* 107 */         }
/* 108 */         agg_value6 = 42;
/* 109 */
/* 110 */         if (!inputadapter_isNull) {
/* 111 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 112 */         }
/* 113 */
/* 114 */         if (!inputadapter_isNull1) {
/* 115 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value6);
/* 116 */         }
/* 117 */
/* 118 */         if (!inputadapter_isNull2) {
/* 119 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value2, agg_value6);
/* 120 */         }
/* 121 */         if (true) {
/* 122 */           // try to get the buffer from hash map
/* 123 */           agg_unsafeRowAggBuffer =
/* 124 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 125 */         }
/* 126 */         if (agg_unsafeRowAggBuffer == null) {
/* 127 */           if (agg_sorter == null) {
/* 128 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 129 */           } else {
/* 130 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 131 */           }
/* 132 */
/* 133 */           // the hash map had be spilled, it should have enough memory now,
/* 134 */           // try  to allocate buffer again.
/* 135 */           agg_unsafeRowAggBuffer =
/* 136 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 137 */           if (agg_unsafeRowAggBuffer == null) {
/* 138 */             // failed to allocate the first page
/* 139 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 140 */           }
/* 141 */         }
/* 142 */       }
/* 143 */
/* 144 */       if (agg_fastAggBuffer != null) {
/* 145 */         // update fast row
/* 146 */
/* 147 */       } else {
/* 148 */         // update unsafe row
/* 149 */
/* 150 */         // common sub-expressions
/* 151 */
/* 152 */         // evaluate aggregate function
/* 153 */
/* 154 */         // update unsafe row buffer
/* 155 */
/* 156 */       }
/* 157 */       if (shouldStop()) return;
/* 158 */     }
/* 159 */
/* 160 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 161 */   }
/* 162 */
/* 163 */   private void wholestagecodegen_init_1() {
/* 164 */     bhj_result = new UnsafeRow(3);
/* 165 */     this.bhj_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result, 0);
/* 166 */     this.bhj_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder, 3);
/* 167 */     this.bhj_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 168 */     bhj_result1 = new UnsafeRow(7);
/* 169 */     this.bhj_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(bhj_result1, 0);
/* 170 */     this.bhj_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(bhj_holder1, 7);
/* 171 */     project_result = new UnsafeRow(1);
/* 172 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 0);
/* 173 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 1);
/* 174 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 175 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[6];
/* 176 */
/* 177 */   }
/* 178 */
/* 179 */   protected void processNext() throws java.io.IOException {
/* 180 */     if (!agg_initAgg) {
/* 181 */       agg_initAgg = true;
/* 182 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 183 */       agg_doAggregateWithKeys();
/* 184 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 185 */     }
/* 186 */
/* 187 */     // output the result
/* 188 */
/* 189 */     while (agg_mapIter.next()) {
/* 190 */       wholestagecodegen_numOutputRows.add(1);
/* 191 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 192 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 193 */
/* 194 */       boolean agg_isNull10 = agg_aggKey.isNullAt(0);
/* 195 */       int agg_value10 = agg_isNull10 ? -1 : (agg_aggKey.getInt(0));
/* 196 */       boolean agg_isNull11 = agg_aggKey.isNullAt(1);
/* 197 */       int agg_value11 = agg_isNull11 ? -1 : (agg_aggKey.getInt(1));
/* 198 */       boolean agg_isNull12 = agg_aggKey.isNullAt(2);
/* 199 */       int agg_value12 = agg_isNull12 ? -1 : (agg_aggKey.getInt(2));
/* 200 */
/* 201 */       // generate join key for stream side
/* 202 */
/* 203 */       bhj_rowWriter.zeroOutNullBytes();
/* 204 */
/* 205 */       if (agg_isNull10) {
/* 206 */         bhj_rowWriter.setNullAt(0);
/* 207 */       } else {
/* 208 */         bhj_rowWriter.write(0, agg_value10);
/* 209 */       }
/* 210 */
/* 211 */       if (agg_isNull11) {
/* 212 */         bhj_rowWriter.setNullAt(1);
/* 213 */       } else {
/* 214 */         bhj_rowWriter.write(1, agg_value11);
/* 215 */       }
/* 216 */
/* 217 */       if (agg_isNull12) {
/* 218 */         bhj_rowWriter.setNullAt(2);
/* 219 */       } else {
/* 220 */         bhj_rowWriter.write(2, agg_value12);
/* 221 */       }
/* 222 */
/* 223 */       // find matches from HashRelation
/* 224 */       scala.collection.Iterator bhj_matches = bhj_result.anyNull() ? null : (scala.collection.Iterator)bhj_relation.get(bhj_result);
/* 225 */       if (bhj_matches == null) continue;
/* 226 */       while (bhj_matches.hasNext()) {
/* 227 */         UnsafeRow bhj_matched = (UnsafeRow) bhj_matches.next();
/* 228 */
/* 229 */         bhj_numOutputRows.add(1);
/* 230 */
/* 231 */         boolean bhj_isNull3 = bhj_matched.isNullAt(0);
/* 232 */         int bhj_value3 = bhj_isNull3 ? -1 : (bhj_matched.getInt(0));
/* 233 */         project_rowWriter.zeroOutNullBytes();
/* 234 */
/* 235 */         if (bhj_isNull3) {
/* 236 */           project_rowWriter.setNullAt(0);
/* 237 */         } else {
/* 238 */           project_rowWriter.write(0, bhj_value3);
/* 239 */         }
/* 240 */         append(project_result.copy());
/* 241 */
/* 242 */       }
/* 243 */
/* 244 */       if (shouldStop()) return;
/* 245 */     }
/* 246 */
/* 247 */     agg_mapIter.close();
/* 248 */     if (agg_sorter == null) {
/* 249 */       agg_hashMap.free();
/* 250 */     }
/* 251 */   }
/* 252 */ }
