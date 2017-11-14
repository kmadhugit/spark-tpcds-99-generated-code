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
/* 011 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 012 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 013 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 014 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 015 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 016 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 017 */   private scala.collection.Iterator inputadapter_input;
/* 018 */   private UnsafeRow agg_result;
/* 019 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 020 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 021 */   private int agg_value6;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 026 */   private UnsafeRow filter_result;
/* 027 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 028 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 029 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 030 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 031 */
/* 032 */   public GeneratedIterator(Object[] references) {
/* 033 */     this.references = references;
/* 034 */   }
/* 035 */
/* 036 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 037 */     partitionIndex = index;
/* 038 */     this.inputs = inputs;
/* 039 */     wholestagecodegen_init_0();
/* 040 */     wholestagecodegen_init_1();
/* 041 */
/* 042 */   }
/* 043 */
/* 044 */   private void wholestagecodegen_init_0() {
/* 045 */     agg_initAgg = false;
/* 046 */
/* 047 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 048 */
/* 049 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 050 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 051 */     inputadapter_input = inputs[0];
/* 052 */     agg_result = new UnsafeRow(2);
/* 053 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 054 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 2);
/* 055 */
/* 056 */     agg_result1 = new UnsafeRow(3);
/* 057 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 058 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 059 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 060 */     filter_result = new UnsafeRow(3);
/* 061 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 0);
/* 062 */
/* 063 */   }
/* 064 */
/* 065 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 066 */     agg_hashMap = agg_plan.createHashMap();
/* 067 */
/* 068 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 069 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 070 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 071 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 072 */       boolean inputadapter_isNull1 = inputadapter_row.isNullAt(1);
/* 073 */       int inputadapter_value1 = inputadapter_isNull1 ? -1 : (inputadapter_row.getInt(1));
/* 074 */       long inputadapter_value2 = inputadapter_row.getLong(2);
/* 075 */
/* 076 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 077 */
/* 078 */       UnsafeRow agg_fastAggBuffer = null;
/* 079 */
/* 080 */       if (agg_fastAggBuffer == null) {
/* 081 */         // generate grouping key
/* 082 */         agg_rowWriter.zeroOutNullBytes();
/* 083 */
/* 084 */         if (inputadapter_isNull) {
/* 085 */           agg_rowWriter.setNullAt(0);
/* 086 */         } else {
/* 087 */           agg_rowWriter.write(0, inputadapter_value);
/* 088 */         }
/* 089 */
/* 090 */         if (inputadapter_isNull1) {
/* 091 */           agg_rowWriter.setNullAt(1);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(1, inputadapter_value1);
/* 094 */         }
/* 095 */         agg_value6 = 42;
/* 096 */
/* 097 */         if (!inputadapter_isNull) {
/* 098 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value6);
/* 099 */         }
/* 100 */
/* 101 */         if (!inputadapter_isNull1) {
/* 102 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value1, agg_value6);
/* 103 */         }
/* 104 */         if (true) {
/* 105 */           // try to get the buffer from hash map
/* 106 */           agg_unsafeRowAggBuffer =
/* 107 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 108 */         }
/* 109 */         if (agg_unsafeRowAggBuffer == null) {
/* 110 */           if (agg_sorter == null) {
/* 111 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 112 */           } else {
/* 113 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 114 */           }
/* 115 */
/* 116 */           // the hash map had be spilled, it should have enough memory now,
/* 117 */           // try  to allocate buffer again.
/* 118 */           agg_unsafeRowAggBuffer =
/* 119 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 120 */           if (agg_unsafeRowAggBuffer == null) {
/* 121 */             // failed to allocate the first page
/* 122 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 123 */           }
/* 124 */         }
/* 125 */       }
/* 126 */
/* 127 */       if (agg_fastAggBuffer != null) {
/* 128 */         // update fast row
/* 129 */
/* 130 */       } else {
/* 131 */         // update unsafe row
/* 132 */
/* 133 */         // common sub-expressions
/* 134 */
/* 135 */         // evaluate aggregate function
/* 136 */         boolean agg_isNull8 = false;
/* 137 */
/* 138 */         long agg_value10 = agg_unsafeRowAggBuffer.getLong(0);
/* 139 */
/* 140 */         long agg_value9 = -1L;
/* 141 */         agg_value9 = agg_value10 + inputadapter_value2;
/* 142 */         // update unsafe row buffer
/* 143 */         agg_unsafeRowAggBuffer.setLong(0, agg_value9);
/* 144 */
/* 145 */       }
/* 146 */       if (shouldStop()) return;
/* 147 */     }
/* 148 */
/* 149 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 150 */   }
/* 151 */
/* 152 */   private void wholestagecodegen_init_1() {
/* 153 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 154 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 155 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 156 */
/* 157 */   }
/* 158 */
/* 159 */   protected void processNext() throws java.io.IOException {
/* 160 */     if (!agg_initAgg) {
/* 161 */       agg_initAgg = true;
/* 162 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 163 */       agg_doAggregateWithKeys();
/* 164 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 165 */     }
/* 166 */
/* 167 */     // output the result
/* 168 */
/* 169 */     while (agg_mapIter.next()) {
/* 170 */       wholestagecodegen_numOutputRows.add(1);
/* 171 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 172 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 173 */
/* 174 */       boolean agg_isNull11 = agg_aggKey.isNullAt(0);
/* 175 */       int agg_value12 = agg_isNull11 ? -1 : (agg_aggKey.getInt(0));
/* 176 */       boolean agg_isNull12 = agg_aggKey.isNullAt(1);
/* 177 */       int agg_value13 = agg_isNull12 ? -1 : (agg_aggKey.getInt(1));
/* 178 */       long agg_value14 = agg_aggBuffer.getLong(0);
/* 179 */
/* 180 */       boolean filter_isNull = false;
/* 181 */
/* 182 */       boolean filter_value = false;
/* 183 */       filter_value = agg_value14 >= 1L;
/* 184 */       if (!filter_value) continue;
/* 185 */       boolean filter_isNull3 = false;
/* 186 */
/* 187 */       boolean filter_value3 = false;
/* 188 */       filter_value3 = agg_value14 <= 5L;
/* 189 */       if (!filter_value3) continue;
/* 190 */
/* 191 */       filter_numOutputRows.add(1);
/* 192 */
/* 193 */       filter_rowWriter.zeroOutNullBytes();
/* 194 */
/* 195 */       if (agg_isNull11) {
/* 196 */         filter_rowWriter.setNullAt(0);
/* 197 */       } else {
/* 198 */         filter_rowWriter.write(0, agg_value12);
/* 199 */       }
/* 200 */
/* 201 */       if (agg_isNull12) {
/* 202 */         filter_rowWriter.setNullAt(1);
/* 203 */       } else {
/* 204 */         filter_rowWriter.write(1, agg_value13);
/* 205 */       }
/* 206 */
/* 207 */       filter_rowWriter.write(2, agg_value14);
/* 208 */       append(filter_result);
/* 209 */
/* 210 */       if (shouldStop()) return;
/* 211 */     }
/* 212 */
/* 213 */     agg_mapIter.close();
/* 214 */     if (agg_sorter == null) {
/* 215 */       agg_hashMap.free();
/* 216 */     }
/* 217 */   }
/* 218 */ }
