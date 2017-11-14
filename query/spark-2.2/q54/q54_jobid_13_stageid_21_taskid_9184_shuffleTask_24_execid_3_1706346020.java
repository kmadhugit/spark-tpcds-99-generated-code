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
/* 021 */   private int agg_value4;
/* 022 */   private UnsafeRow agg_result1;
/* 023 */   private org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder agg_holder1;
/* 024 */   private org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter agg_rowWriter1;
/* 025 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_numOutputRows;
/* 026 */   private org.apache.spark.sql.execution.metric.SQLMetric wholestagecodegen_aggTime;
/* 027 */
/* 028 */   public GeneratedIterator(Object[] references) {
/* 029 */     this.references = references;
/* 030 */   }
/* 031 */
/* 032 */   public void init(int index, scala.collection.Iterator[] inputs) {
/* 033 */     partitionIndex = index;
/* 034 */     this.inputs = inputs;
/* 035 */     agg_initAgg = false;
/* 036 */
/* 037 */     this.agg_plan = (org.apache.spark.sql.execution.aggregate.HashAggregateExec) references[0];
/* 038 */
/* 039 */     this.agg_peakMemory = (org.apache.spark.sql.execution.metric.SQLMetric) references[1];
/* 040 */     this.agg_spillSize = (org.apache.spark.sql.execution.metric.SQLMetric) references[2];
/* 041 */     inputadapter_input = inputs[0];
/* 042 */     agg_result = new UnsafeRow(1);
/* 043 */     this.agg_holder = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result, 0);
/* 044 */     this.agg_rowWriter = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder, 1);
/* 045 */
/* 046 */     agg_result1 = new UnsafeRow(3);
/* 047 */     this.agg_holder1 = new org.apache.spark.sql.catalyst.expressions.codegen.BufferHolder(agg_result1, 0);
/* 048 */     this.agg_rowWriter1 = new org.apache.spark.sql.catalyst.expressions.codegen.UnsafeRowWriter(agg_holder1, 3);
/* 049 */     this.wholestagecodegen_numOutputRows = (org.apache.spark.sql.execution.metric.SQLMetric) references[3];
/* 050 */     this.wholestagecodegen_aggTime = (org.apache.spark.sql.execution.metric.SQLMetric) references[4];
/* 051 */
/* 052 */   }
/* 053 */
/* 054 */   private void agg_doAggregateWithKeys() throws java.io.IOException {
/* 055 */     agg_hashMap = agg_plan.createHashMap();
/* 056 */
/* 057 */     while (inputadapter_input.hasNext() && !stopEarly()) {
/* 058 */       InternalRow inputadapter_row = (InternalRow) inputadapter_input.next();
/* 059 */       boolean inputadapter_isNull = inputadapter_row.isNullAt(0);
/* 060 */       int inputadapter_value = inputadapter_isNull ? -1 : (inputadapter_row.getInt(0));
/* 061 */       long inputadapter_value1 = inputadapter_row.getLong(1);
/* 062 */
/* 063 */       UnsafeRow agg_unsafeRowAggBuffer = null;
/* 064 */
/* 065 */       UnsafeRow agg_fastAggBuffer = null;
/* 066 */
/* 067 */       if (agg_fastAggBuffer == null) {
/* 068 */         // generate grouping key
/* 069 */         agg_rowWriter.zeroOutNullBytes();
/* 070 */
/* 071 */         if (inputadapter_isNull) {
/* 072 */           agg_rowWriter.setNullAt(0);
/* 073 */         } else {
/* 074 */           agg_rowWriter.write(0, inputadapter_value);
/* 075 */         }
/* 076 */         agg_value4 = 42;
/* 077 */
/* 078 */         if (!inputadapter_isNull) {
/* 079 */           agg_value4 = org.apache.spark.unsafe.hash.Murmur3_x86_32.hashInt(inputadapter_value, agg_value4);
/* 080 */         }
/* 081 */         if (true) {
/* 082 */           // try to get the buffer from hash map
/* 083 */           agg_unsafeRowAggBuffer =
/* 084 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 085 */         }
/* 086 */         if (agg_unsafeRowAggBuffer == null) {
/* 087 */           if (agg_sorter == null) {
/* 088 */             agg_sorter = agg_hashMap.destructAndCreateExternalSorter();
/* 089 */           } else {
/* 090 */             agg_sorter.merge(agg_hashMap.destructAndCreateExternalSorter());
/* 091 */           }
/* 092 */
/* 093 */           // the hash map had be spilled, it should have enough memory now,
/* 094 */           // try  to allocate buffer again.
/* 095 */           agg_unsafeRowAggBuffer =
/* 096 */           agg_hashMap.getAggregationBufferFromUnsafeRow(agg_result, agg_value4);
/* 097 */           if (agg_unsafeRowAggBuffer == null) {
/* 098 */             // failed to allocate the first page
/* 099 */             throw new OutOfMemoryError("No enough memory for aggregation");
/* 100 */           }
/* 101 */         }
/* 102 */       }
/* 103 */
/* 104 */       if (agg_fastAggBuffer != null) {
/* 105 */         // update fast row
/* 106 */
/* 107 */       } else {
/* 108 */         // update unsafe row
/* 109 */
/* 110 */         // common sub-expressions
/* 111 */
/* 112 */         // evaluate aggregate function
/* 113 */         boolean agg_isNull5 = false;
/* 114 */
/* 115 */         long agg_value7 = agg_unsafeRowAggBuffer.getLong(0);
/* 116 */
/* 117 */         long agg_value6 = -1L;
/* 118 */         agg_value6 = agg_value7 + inputadapter_value1;
/* 119 */         // update unsafe row buffer
/* 120 */         agg_unsafeRowAggBuffer.setLong(0, agg_value6);
/* 121 */
/* 122 */       }
/* 123 */       if (shouldStop()) return;
/* 124 */     }
/* 125 */
/* 126 */     agg_mapIter = agg_plan.finishAggregate(agg_hashMap, agg_sorter, agg_peakMemory, agg_spillSize);
/* 127 */   }
/* 128 */
/* 129 */   protected void processNext() throws java.io.IOException {
/* 130 */     if (!agg_initAgg) {
/* 131 */       agg_initAgg = true;
/* 132 */       long wholestagecodegen_beforeAgg = System.nanoTime();
/* 133 */       agg_doAggregateWithKeys();
/* 134 */       wholestagecodegen_aggTime.add((System.nanoTime() - wholestagecodegen_beforeAgg) / 1000000);
/* 135 */     }
/* 136 */
/* 137 */     // output the result
/* 138 */
/* 139 */     while (agg_mapIter.next()) {
/* 140 */       wholestagecodegen_numOutputRows.add(1);
/* 141 */       UnsafeRow agg_aggKey = (UnsafeRow) agg_mapIter.getKey();
/* 142 */       UnsafeRow agg_aggBuffer = (UnsafeRow) agg_mapIter.getValue();
/* 143 */
/* 144 */       boolean agg_isNull8 = agg_aggKey.isNullAt(0);
/* 145 */       int agg_value9 = agg_isNull8 ? -1 : (agg_aggKey.getInt(0));
/* 146 */       long agg_value10 = agg_aggBuffer.getLong(0);
/* 147 */
/* 148 */       boolean agg_isNull13 = true;
/* 149 */       int agg_value14 = -1;
/* 150 */
/* 151 */       if (!agg_isNull8) {
/* 152 */         agg_isNull13 = false; // resultCode could change nullability.
/* 153 */         agg_value14 = agg_value9 * 50;
/* 154 */
/* 155 */       }
/* 156 */       agg_rowWriter1.zeroOutNullBytes();
/* 157 */
/* 158 */       if (agg_isNull8) {
/* 159 */         agg_rowWriter1.setNullAt(0);
/* 160 */       } else {
/* 161 */         agg_rowWriter1.write(0, agg_value9);
/* 162 */       }
/* 163 */
/* 164 */       agg_rowWriter1.write(1, agg_value10);
/* 165 */
/* 166 */       if (agg_isNull13) {
/* 167 */         agg_rowWriter1.setNullAt(2);
/* 168 */       } else {
/* 169 */         agg_rowWriter1.write(2, agg_value14);
/* 170 */       }
/* 171 */       append(agg_result1);
/* 172 */
/* 173 */       if (shouldStop()) return;
/* 174 */     }
/* 175 */
/* 176 */     agg_mapIter.close();
/* 177 */     if (agg_sorter == null) {
/* 178 */       agg_hashMap.free();
/* 179 */     }
/* 180 */   }
/* 181 */ }
