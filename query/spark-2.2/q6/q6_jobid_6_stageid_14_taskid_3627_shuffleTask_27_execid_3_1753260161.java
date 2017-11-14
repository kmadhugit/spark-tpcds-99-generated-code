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
/* 013 */   private org.apache.spark.sql.execution.aggregate.HashAggregateExec agg_plan;
/* 014 */   private org.apache.spark.sql.execution.UnsafeFixedWidthAggregationMap agg_hashMap;
/* 015 */   private org.apache.spark.sql.execution.UnsafeKVExternalSorter agg_sorter;
/* 016 */   private org.apache.spark.unsafe.KVIterator agg_mapIter;
/* 017 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_peakMemory;
/* 018 */   private org.apache.spark.sql.execution.metric.SQLMetric agg_spillSize;
/* 019 */   private scala.collection.Iterator inputadapter_input;
/* 020 */   private UnsafeRow agg_result;
/* 021 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder;
/* 022 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter;
/* 023 */   private int agg_value6;
/* 024 */   private UnsafeRow agg_result1;
/* 025 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 026 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 027 */   private org.apache.spark.sql.execution.metric.SQLMetric filter_numOutputRows;
/* 028 */   private UnsafeRow filter_result;
/* 029 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder filter_holder;
/* 030 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter filter_rowWriter;
/* 031 */   private UnsafeRow project_result;
/* 032 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder project_holder;
/* 033 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter project_rowWriter;
/* 034 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 035 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 036 */
/* 037 */   public GeneratedIterator(Object[] references) {
/* 038 */     this.references = references;
/* 039 */   }
/* 040 */
/* 041 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 042 */     partitionIndex = index;
/* 043 */     this.inputs = inputs;
/* 044 */     wholestagecodegen_init_0();
/* 045 */     wholestagecodegen_init_1();
/* 046 */
/* 047 */   }
/* 048 */
/* 049 */   private void wholestagecodegen_init_0() {
/* 050 */     agg_initAgg = false;
/* 051 */
/* 052 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 053 */
/* 054 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 055 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 056 */     inputadapter_input = inputs[0];
/* 057 */     agg_result = new UnsafeRow(1);
/* 058 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 32);
/* 059 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 060 */
/* 061 */     agg_result1 = new UnsafeRow(3);
/* 062 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 32);
/* 063 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 064 */     this.filter_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 065 */     filter_result = new UnsafeRow(3);
/* 066 */     this.filter_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(filter_result, 32);
/* 067 */
/* 068 */   }
/* 069 */
/* 070 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 071 */     agg_hashMap = agg_plan.createHashMap();
/* 072 */
/* 073 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 074 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 075 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 076 */       UTF8String inputadapter_value = inputadapter_isNull ? null : (inputadapter_row.getUTF8String(0));
/* 077 */       long inputadapter_value1 = inputadapter_row.getLong(1);
/* 078 */       long inputadapter_value2 = inputadapter_row.getLong(2);
/* 079 */
/* 080 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 081 */
/* 082 */       UnsafeRow agg_fastAggBuffer = null;
/* 083 */
/* 084 */       if (agg_fastAggBuffer == null) {
/* 085 */         // generate grouping key
/* 086 */         agg_holder.reset();
/* 087 */
/* 088 */         agg_rowWriter.zeroOutNullBytes();
/* 089 */
/* 090 */         if (inputadapter_isNull) {
/* 091 */           agg_rowWriter.setNullAt(0);
/* 092 */         } else {
/* 093 */           agg_rowWriter.write(0, inputadapter_value);
/* 094 */         }
/* 095 */         agg_result.setTotalSize(agg_holder.totalSize());
/* 096 */         agg_value6 = 42;
/* 097 */
/* 098 */         if (!inputadapter_isNull) {
/* 099 */           agg_value6 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashUnsafeBytes(inputadapter_value.getBaseObject(), inputadapter_value.getBaseOffset(), inputadapter_value.numBytes(), agg_value6);
/* 100 */         }
/* 101 */         if (true) {
/* 102 */           // try to get the buffer from hash map
/* 103 */           agg_unsafeRowAggBuffer =
/* 104 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 105 */         }
/* 106 */         if (agg_unsafeRowAggBuffer == null) {
/* 107 */           if (agg_sorter == null) {
/* 108 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 109 */           } else {
/* 110 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 111 */           }
/* 112 */
/* 113 */           // the hash map had be spilled, it should have enough memory now,
/* 114 */           // try  to allocate buffer again.
/* 115 */           agg_unsafeRowAggBuffer =
/* 116 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value6);
/* 117 */           if (agg_unsafeRowAggBuffer == null) {
/* 118 */             // failed to allocate the first page
/* 119 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 120 */           }
/* 121 */         }
/* 122 */       }
/* 123 */
/* 124 */       if (agg_fastAggBuffer != null) {
/* 125 */         // update fast row
/* 126 */
/* 127 */       } else {
/* 128 */         // update unsafe row
/* 129 */
/* 130 */         // common sub-expressions
/* 131 */
/* 132 */         // evaluate aggregate function
/* 133 */         boolean agg_isNull6 = false;
/* 134 */
/* 135 */         long agg_value9 = agg_unsafeRowAggBuffer.getLong(0);
/* 136 */
/* 137 */         long agg_value8 = -1L;
/* 138 */         agg_value8 = agg_value9 + inputadapter_value1;
/* 139 */         boolean agg_isNull9 = false;
/* 140 */
/* 141 */         long agg_value12 = agg_unsafeRowAggBuffer.getLong(1);
/* 142 */
/* 143 */         long agg_value11 = -1L;
/* 144 */         agg_value11 = agg_value12 + inputadapter_value2;
/* 145 */         // update unsafe row buffer
/* 146 */         agg_unsafeRowAggBuffer.setLong(0, agg_value8);
/* 147 */         agg_unsafeRowAggBuffer.setLong(1, agg_value11);
/* 148 */
/* 149 */       }
/* 150 */       if (shouldStop()) return;
/* 151 */     }
/* 152 */
/* 153 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 154 */   }
/* 155 */
/* 156 */   private void wholestagecodegen_init_1() {
/* 157 */     this.filter_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(filter_holder, 3);
/* 158 */     project_result = new UnsafeRow(2);
/* 159 */     this.project_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(project_result, 32);
/* 160 */     this.project_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(project_holder, 2);
/* 161 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 162 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[5];
/* 163 */
/* 164 */   }
/* 165 */
/* 166 */   protected void processNext() throws java.io.IOException {
/* 167 */     if (!agg_initAgg) {
/* 168 */       agg_initAgg = true;
/* 169 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 170 */       agg_doAggregateWithKeys();
/* 171 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 172 */     }
/* 173 */
/* 174 */     // output the result
/* 175 */
/* 176 */     while (agg_mapIter.next()) {
/* 177 */       wholestagecodegen_numOutputRows.add(1);
/* 178 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 179 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 180 */
/* 181 */       boolean agg_isNull12 = agg_aggKey.isNullAt(0);
/* 182 */       UTF8String agg_value14 = agg_isNull12 ? null : (agg_aggKey.getUTF8String(0));
/* 183 */       long agg_value15 = agg_aggBuffer.getLong(0);
/* 184 */       long agg_value16 = agg_aggBuffer.getLong(1);
/* 185 */
/* 186 */       boolean filter_isNull = false;
/* 187 */
/* 188 */       boolean filter_value = false;
/* 189 */       filter_value = agg_value16 >= 10L;
/* 190 */       if (!filter_value) continue;
/* 191 */
/* 192 */       filter_numOutputRows.add(1);
/* 193 */
/* 194 */       project_holder.reset();
/* 195 */
/* 196 */       project_rowWriter.zeroOutNullBytes();
/* 197 */
/* 198 */       if (agg_isNull12) {
/* 199 */         project_rowWriter.setNullAt(0);
/* 200 */       } else {
/* 201 */         project_rowWriter.write(0, agg_value14);
/* 202 */       }
/* 203 */
/* 204 */       project_rowWriter.write(1, agg_value15);
/* 205 */       project_result.setTotalSize(project_holder.totalSize());
/* 206 */       append(project_result);
/* 207 */
/* 208 */       if (shouldStop()) return;
/* 209 */     }
/* 210 */
/* 211 */     agg_mapIter.close();
/* 212 */     if (agg_sorter == null) {
/* 213 */       agg_hashMap.free();
/* 214 */     }
/* 215 */   }
/* 216 */ }
